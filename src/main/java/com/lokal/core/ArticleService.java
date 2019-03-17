package com.lokal.core;

import com.lokal.Model.Article;
import com.lokal.dao.ArticleDao;

public class ArticleService {
    private ArticleDao articleDao;

    public ArticleService() {
    }

    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public Article createOrUpdate(Article article) {
        return articleDao.createorUpdate(article);
    }
}
