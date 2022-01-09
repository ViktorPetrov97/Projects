package com.viktor.beer.repositories;

import com.viktor.beer.models.Tag;
import com.viktor.beer.repositories.common.TagRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public TagRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Tag> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Tag> query = session.createQuery("from Tag");
            return query.list();
        }
    }

    @Override
    public List<Tag> getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Tag> query = session.createQuery(
                    "from Tag where id=:id", Tag.class);
            query.setParameter("id", id);
            return query.list();
        }
    }

    @Override
    public List<Tag> getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Tag> query = session.createQuery("from Tag where name LIKE :name", Tag.class);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        }
    }

    @Override
    public boolean checkTagExists(String name) {
        return getByName(name).size() != 0;
    }

    @Override
    public void create(Tag tag) {
        try (Session session = sessionFactory.openSession()) {
            session.save(tag);
        }
    }

    @Override
    public void delete(Tag tag) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(tag);
            session.getTransaction().commit();
        }
    }
}
