package com.viktor.beer.repositories;

import com.viktor.beer.models.Country;
import com.viktor.beer.repositories.common.CountryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public CountryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Country> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Country", Country.class)
                    .list();

        }
    }

    @Override
    public List<Country> getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Country> query = session.createQuery(
                    "from Country where id=:id", Country.class);
            query.setParameter("id", id);
            return query.list();
        }
    }

    @Override
    public List<Country> getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Country> query = session.createQuery("from Country where name LIKE :name", Country.class);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        }
    }

    @Override
    public void create(Country country) {
        try (Session session = sessionFactory.openSession()) {
            session.save(country);
        }
    }

    @Override
    public void delete(Country country) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(country);
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean checkCountryExists(String name) {
        return getByName(name).size() != 0;
    }
}
