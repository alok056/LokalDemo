package com.lokal.dao;

import com.lokal.Model.Author;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDao extends AbstractDAO<Author> {
    public AuthorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Author getAuthor(Integer id) {
        return get(id);
    }

    public Author getAuthorByName(String name) {
        String sql = "SELECT * FROM authors WHERE name = :name";
        SQLQuery query = currentSession().createSQLQuery(sql);
        query.addEntity(Author.class);
        query.setParameter("name", name);
        List results = query.list();

        return (Author) results.get(0);
    }
}
