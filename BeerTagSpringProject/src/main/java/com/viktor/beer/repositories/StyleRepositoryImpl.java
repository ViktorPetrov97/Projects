package com.viktor.beer.repositories;

import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Style;
import com.viktor.beer.repositories.common.StyleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StyleRepositoryImpl implements StyleRepository {
    private final SessionFactory factory;

    @Autowired
    public StyleRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Style> getAll() {
        try (Session session = factory.openSession()) {
            Query<Style> query = session.createQuery("from Style");
            return query.list();
        }
    }

    @Override
    public Style getById(int id) {
        try (Session session = factory.openSession()) {
            Style style = session.get(Style.class, id);
            if (style == null) {
                throw new EntityNotFoundException(
                        String.format("Style with id %d not found!", id));
            }
            return style;
        }
    }

    @Override
    public List<Style> getByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Style> query = session.createQuery("from Style where name LIKE :name", Style.class);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        }
    }

    @Override
    public void create(Style style) {
        try (Session session = factory.openSession()) {
            session.save(style);
        }
    }

    @Override
    public void delete(Style style) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(style);
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean checkStyleExists(String name) {
        return getByName(name).size() != 0;
    }
}
