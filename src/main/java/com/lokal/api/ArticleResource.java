package com.lokal.api;

import com.google.common.collect.Lists;
import com.lokal.Model.Article;
import com.lokal.Model.ArticleBO;
import com.lokal.core.ArticleService;
import io.dropwizard.hibernate.UnitOfWork;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("article")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {
    private ArticleService articleService;

    @POST
    @UnitOfWork
    public ArticleBO createOrUpdate(ArticleBO articleRequest) throws Exception {
        return articleService.createOrUpdate(articleRequest);
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
