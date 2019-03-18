package com.lokal.core;

import com.lokal.Model.*;
import com.lokal.client.ArticleESClient;
import com.lokal.dao.ArticleDao;
import com.lokal.dao.AuthorDao;
import com.lokal.dao.LocationDao;
import com.lokal.dao.TagDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ArticleService {
    private ArticleDao articleDao;
    private AuthorDao authorDao;
    private LocationDao locationDao;
    private TagDao tagDao;
    private ArticleESClient articleESClient;

    public ArticleBO createOrUpdate (ArticleBO articleBORequest) throws Exception {
        Article article =  articleDao.createorUpdate(articleBORequest.getArticle());

        for (String authorName: articleBORequest.getAuthors()) {
            Author author = authorDao.getAuthorByName(authorName);

            if (author == null) {
                throw new Exception("author not found");
            }
        }

        for (String locationName: articleBORequest.getLocations()) {
            Location location = locationDao.getLocationByName(locationName);

            if (location == null) {
                throw new Exception("location not found");
            }
        }

        for (String tagName: articleBORequest.getTags()) {
            Tag tag = tagDao.getTagByName(tagName);

            if (tag == null) {
                throw new Exception("tag not found");
            }
        }

        ArticleBO articleBOResponse = ArticleBO.builder()
                .article(article)
                .categories(articleBORequest.getCategories())
                .authors(articleBORequest.getAuthors())
                .locations(articleBORequest.getLocations())
                .tags(articleBORequest.getTags())
                .build();

        articleESClient.indexObject(articleBOResponse);

        return articleBOResponse;
    }
}
