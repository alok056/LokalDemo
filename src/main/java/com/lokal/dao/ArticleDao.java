package com.lokal.dao;

import com.lokal.Model.Article;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class ArticleDao extends AbstractDAO<Article> {
    public ArticleDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Article createorUpdate(Article article) {
        return persist(article);
    }
}
