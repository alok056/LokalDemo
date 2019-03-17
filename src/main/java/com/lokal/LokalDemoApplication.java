package com.lokal;

import com.lokal.Model.Article;
import com.lokal.api.ArticleResource;
import com.lokal.core.ArticleService;
import com.lokal.dao.ArticleDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.validator.internal.util.logging.Log;

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

    private final HibernateBundle<LokalDemoConfiguration> hibernate = new HibernateBundle<LokalDemoConfiguration>(Article.class) {
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
        // TODO: implement application
        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);

        final ArticleDao articleDao = new ArticleDao(hibernate.getSessionFactory());
        final ArticleService articleService = new ArticleService(articleDao);
        ArticleResource articleResource = new ArticleResource(articleService);
        environment.jersey().register(articleResource);

    }

}
