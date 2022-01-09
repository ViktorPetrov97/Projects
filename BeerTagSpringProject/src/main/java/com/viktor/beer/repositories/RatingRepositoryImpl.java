package com.viktor.beer.repositories;

import com.viktor.beer.models.Beer;
import com.viktor.beer.models.Rating;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.repositories.common.RatingRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

@Repository
public class RatingRepositoryImpl implements RatingRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public RatingRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Rating create(Rating rating) {
        try (Session session = sessionFactory.openSession()) {
            session.save(rating);
            return rating;
        }
    }

    @Override
    public void update(Rating rating) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(rating);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Rating rating) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(rating);
            session.getTransaction().commit();
        }
    }

    @Override
    public double getAverageRatingForBeer(int beerId) {
        try (Session session = sessionFactory.openSession()) {
            Beer beer = session.get(Beer.class, beerId);
            int averageRating = (int) session.createQuery("select avg(rating) from Rating where beer = :beerId")
                    .setParameter("beerId", beer).getSingleResult();
            return averageRating;
        }
    }



    @Override
    public List<Rating> getBeersOfUser(int userId) {
        try (Session session = sessionFactory.openSession()) {
            UserDetails user = session.get(UserDetails.class, userId);
            Query<Rating> query = session.createQuery("from Rating where user = :user", Rating.class);
            query.setParameter("user", user);

            return query.list();
        }
    }

//    @Override
//    public List<Rating> getAllBeersRating() {
//        try(Session session = sessionFactory.openSession()) {
//            Beer beer = session.get(Beer.class, )
//        }
//    }

}
