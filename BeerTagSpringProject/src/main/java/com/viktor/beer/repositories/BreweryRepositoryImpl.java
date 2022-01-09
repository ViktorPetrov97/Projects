package com.viktor.beer.repositories;

import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Brewery;
import com.viktor.beer.repositories.common.BreweryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BreweryRepositoryImpl implements BreweryRepository {
    private final SessionFactory factory;

    @Autowired
    public BreweryRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Brewery brewery) {
        try (Session session = factory.openSession()) {
            session.save(brewery);
        }
    }

    @Override
    public void delete(Brewery brewery) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(brewery);
            session.getTransaction().commit();
        }
    }

    @Override
    public Brewery getById(int id) {
        try (Session session = factory.openSession()) {
            Brewery brewery = session.get(Brewery.class, id);
            if (brewery == null) {
                throw new EntityNotFoundException(
                        String.format("Brewery with id %d not found!", id));
            }
            return brewery;
        }
    }

    @Override
    public List<Brewery> getAll() {
        try (Session session = factory.openSession()) {
            Query<Brewery> query = session.createQuery("from Brewery ");
            return query.list();
        }
    }

    @Override
    public List<Brewery> getByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Brewery> query = session.createQuery("from Brewery where name LIKE :name", Brewery.class);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        }
    }

    @Override
    public boolean checkBreweryExists(String name) {
        return getByName(name).size() != 0;
    }

}
