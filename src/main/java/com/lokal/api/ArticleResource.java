package com.lokal.api;

import com.google.common.collect.Lists;
import com.lokal.Model.Article;
import com.lokal.core.ArticleService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {

    private ArticleService articleService;

    public ArticleResource() {
    }

    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @POST
    @UnitOfWork
    public Article createOrUpdate(Article article) {
        return articleService.createOrUpdate(article);
    }

    @GET
    @UnitOfWork
    public List<Article> getResources() {
        List<Article> articleList = Lists.newArrayList(
                new Article()
        );

        return articleList;
    }
}
