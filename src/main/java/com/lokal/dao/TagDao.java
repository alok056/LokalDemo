package com.lokal.dao;

import com.lokal.Model.Tag;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class TagDao extends AbstractDAO<Tag> {
    public TagDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Tag getLocation(Integer id) {
        return get(id);
    }

    public Tag getTagByName(String name) {
        String sql = "SELECT * FROM tags WHERE name = :name";
        SQLQuery query = currentSession().createSQLQuery(sql);
        query.addEntity(Tag.class);
        query.setParameter("name", name);
        List results = query.list();

        return (Tag) results.get(0);
    }
}
