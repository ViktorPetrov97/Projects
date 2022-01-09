package com.viktor.beer.repositories;

import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Beer;
import com.viktor.beer.repositories.common.BeerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BeerRepositorySqlImpl implements BeerRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public BeerRepositorySqlImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Beer beer) {
        try (Session session = sessionFactory.openSession()) {
            session.save(beer);
        }
    }

    @Override
    public Beer getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Beer beer = session.get(Beer.class, id);
            if (beer == null) {
                throw new EntityNotFoundException(
                        String.format("Beer with id %d not found!", id));
            }
            return beer;
        }
    }

    @Override
    public boolean existsByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer", Beer.class);
        }
        return false;
    }

    @Override
    public List<Beer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer", Beer.class);
            return query.list();
        }
    }

    @Override
    public void update(Beer beer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(beer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(getById(id));
            session.getTransaction().commit();
        }
    }



// TODO: 26.9.2020 г.

    @Override
    public List<Beer> SortByName() {
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer order by name asc", Beer.class);
            return query.list();
        }
    }

    @Override
    public List<Beer> SortByAbv() {
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer order by abv desc", Beer.class);
            //query.setParameter("name", name);
            return query.list();
        }
    }
    @Override
    public List<Beer> SortByRating() {
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer b join Rating r where b.id = r.beer.id order by avg(r.rating)", Beer.class);
            return query.list();
        }
    }

    @Override
    public List<Beer> filterByName(String name) {
//        if (name.isEmpty()) {
//            return getAll();
//        }
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer where name like concat('%',:name,'%') order by name desc", Beer.class);
            query.setParameter("name", name);
            return query.list();
        }
    }

    @Override
    public List<Beer> filterByStyle(int styleId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer where style.id = :styleId", Beer.class);
            query.setParameter("styleId", styleId);
            return query.list();
        }
    }

    @Override
    public List<Beer> search(String name, int styleId, int countryId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Beer> cq = cb.createQuery(Beer.class);
            Root<Beer> rb = cq.from(Beer.class);

            List<Predicate> predicates = new ArrayList<>();
            Predicate like = cb.like(rb.get("name"), "%" + name + "%");
            predicates.add(like);
            if (styleId != -1){
                predicates.add(cb.equal(rb.get("style").get("id"), styleId));
            }
            if (countryId != -1){
                predicates.add(cb.equal(rb.get("brewery").get("country").get("id"), countryId));
            }
            cq.select(rb).where(predicates.toArray(Predicate[]::new));

            return session.createQuery(cq).getResultList();
        }
    }

    @Override
    public List<Beer> filter(Optional<Integer> id, Optional<String> name) {
        return null;
    }


}
