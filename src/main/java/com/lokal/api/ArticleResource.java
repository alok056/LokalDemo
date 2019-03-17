package com.lokal.api;

import com.google.common.collect.Lists;
import com.lokal.Model.Article;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {

    @GET
    public List<Article> getResources() {
        List<Article> articleList = Lists.newArrayList(
                new Article()
        );

        return articleList;
    }
}
