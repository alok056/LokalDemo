package com.lokal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lokal.Model.Article;
import com.lokal.Model.Author;
import com.lokal.Model.Location;
import com.lokal.Model.Tag;
import com.lokal.api.ArticleResource;
import com.lokal.client.ArticleESClient;
import com.lokal.core.ArticleService;
import com.lokal.dao.ArticleDao;
import com.lokal.dao.AuthorDao;
import com.lokal.dao.LocationDao;
import com.lokal.dao.TagDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LokalDemoApplication extends Application<LokalDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LokalDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "LokalDemo";
    }

    private final HibernateBundle<LokalDemoConfiguration> hibernate = new HibernateBundle<LokalDemoConfiguration>(Article.class, Author.class, Tag.class, Location.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(LokalDemoConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(final Bootstrap<LokalDemoConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final LokalDemoConfiguration configuration,
                    final Environment environment) {

        final Logger logger = LoggerFactory.getLogger(LokalDemoApplication.class);
        logger.info("Application started....................................................");

        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);

        ObjectMapper objectMapper = new ObjectMapper();

        final ArticleESClient articleESClient = new ArticleESClient(objectMapper);

        final ArticleDao articleDao = new ArticleDao(hibernate.getSessionFactory());
        final TagDao tagDao = new TagDao(hibernate.getSessionFactory());
        final AuthorDao authorDao = new AuthorDao(hibernate.getSessionFactory());
        final LocationDao locationDao = new LocationDao(hibernate.getSessionFactory());

        final ArticleService articleService = new ArticleService(articleDao, authorDao, locationDao, tagDao, articleESClient);
        ArticleResource articleResource = new ArticleResource(articleService);
        environment.jersey().register(articleResource);
    }

}
