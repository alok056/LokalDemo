package com.lokal.dao;

import com.lokal.Model.Location;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class LocationDao extends AbstractDAO<Location> {
    public LocationDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Location getLocation(Integer id) {
        return get(id);
    }

    public Location getLocationByName(String name) {
        String sql = "SELECT * FROM locations WHERE name = :name";
        SQLQuery query = currentSession().createSQLQuery(sql);
        query.addEntity(Location.class);
        query.setParameter("name", name);
        List results = query.list();

        return (Location) results.get(0);
    }
}
