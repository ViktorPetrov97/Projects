package com.viktor.beer.repositories;

import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Beer;
import com.viktor.beer.models.User;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.repositories.common.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepositorySqlImpl implements UserRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepositorySqlImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(UserDetails userDetails) {
        try (Session session = sessionFactory.openSession()) {
//            if (existsByName(userDetails.getName())) {
//                throw new DuplicateEntityException(String.format("User with name %s already exist", userDetails.getName()));
//            }
            session.save(userDetails);
        }
    }

    @Override
    public UserDetails getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            UserDetails userDetails = session.get(UserDetails.class, id);
            if (userDetails == null) {
                throw new EntityNotFoundException(
                        String.format("User with id %d not found!", id));
            }
            return userDetails;
        }
    }

    @Override
    public User getUserById(int id) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            if (user == null) {
                throw new EntityNotFoundException(
                        String.format("User with id %d not found!", id));
            }
            return user;
        }
    }

    @Override
    public UserDetails getByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<UserDetails> query = session.createQuery("from UserDetails where username = :username", UserDetails.class); // I am not sure if it is name in where clause!
            query.setParameter("username", username);
            List<UserDetails> userDetails = query.list();
            if (userDetails.isEmpty()) {
                throw new EntityNotFoundException(String.format("User with username %s not found", username));
            }
            return userDetails.get(0);
        }
    }

    @Override
    public User getByUsernameFromUser(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where username = :username", User.class); // I am not sure if it is name in where clause!
            query.setParameter("username", username);
            List<User> users = query.list();
            if (users.isEmpty()) {
                throw new EntityNotFoundException(String.format("User with username %s not found", username));
            }
            return users.get(0);
        }
    }

    @Override
    public boolean existsByName(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<UserDetails> query = session.createQuery("from UserDetails where username = :username", UserDetails.class);
            query.setParameter("username", username);
            List<UserDetails> userDetails = query.list();
            if (userDetails.isEmpty()) {
                return false;
            }
            return true;
        }
    }

    @Override
    public List<UserDetails> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<UserDetails> query = session.createQuery("from UserDetails ", UserDetails.class);
            return query.list();
        }
    }

    @Override
    public void update(UserDetails userDetails) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(userDetails);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            // if () If we should make exception!
            session.beginTransaction();
            session.delete(getById(id));
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean checkIfBeerExistInWishList(int user_id, int beer_id) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createSQLQuery("select user_id, beer_id from wish_beer_list where user_id=:user_id and beer_id=:beer_id");
            query.setParameter("user_id", user_id);
            query.setParameter("beer_id", beer_id);
            return query.list().size() != 0;
        }
    }

    @Override
    public boolean checkIfBeerExistInDrankList(int user_id, int beer_id) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createSQLQuery("select user_id, beer_id " +
                    "from drank_beer_list where user_id=:user_id and beer_id=:beer_id");
            query.setParameter("user_id", user_id);
            query.setParameter("beer_id", beer_id);
            return query.list().size() != 0;
        }
    }

    public Set<Beer> showList(String listOfChoice, UserDetails userDetails) {

        try (Session session = sessionFactory.openSession()) {
            if (listOfChoice.equalsIgnoreCase("wishlist")) {
                return userDetails.getUsersWishList();
            } else if (listOfChoice.equalsIgnoreCase("dranklist")) {
                return userDetails.getUsersDrankList();
            } else {
                throw new IllegalArgumentException(String.format("'%s' does not exists for users!", listOfChoice));
            }
        }
    }

    @Override
    public void deleteBeerFromWishList(int beerId, int userId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Beer beer = session.get(Beer.class, beerId);
            UserDetails user = session.get(UserDetails.class, userId);
            user.getUsersWishList().remove(beer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteBeerFromDrankList(int beerId, int userId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Beer beer = session.get(Beer.class, beerId);
            UserDetails user = session.get(UserDetails.class, userId);
            user.getUsersDrankList().remove(beer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void enable(String userName) {
//        User user = getByUsernameFromUser(userName);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
//            session.delete(brewery);
            session.update(getByUsernameFromUser(userName));
//            Query query = session.createQuery("select enabled")
            session.getTransaction().commit();
        }
    }
    @Override
    public void disable(String userName) {
//        User user = getByUsernameFromUser(userName);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
//            session.delete(brewery);
            session.update(getByUsernameFromUser(userName));
//            Query query = session.createQuery("select enabled")
            session.getTransaction().commit();
        }
    }


    @Override
    public List<UserDetails> filter(Optional<Integer> id, Optional<String> name, Optional<String> email) {
        return null;
    }

    public boolean checkIfBeerIsRated(int user_id, int beer_id) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createSQLQuery("select user_id, beer_id,rating " +
                    "from beer_rating where user_id=:user_id and beer_id=:beer_id");
            query.setParameter("user_id", user_id);
            query.setParameter("beer_id", beer_id);
            return query.list().size() != 0;
        }
    }

    public Object getRateForBeer(int user_id, int beer_id, int rating) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createSQLQuery("select user_id, beer_id,rating " +
                    "from beer_rating where user_id=:user_id and beer_id=:beer_id");
            query.setParameter("user_id", user_id);
            query.setParameter("beer_id", beer_id);
            return query.getSingleResult();
        }
    }

    public void removeRateForBeer(int user_id, int beer_id) {
        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            Query query = session.createSQLQuery("delete from beer_rating where user_id=:user_id and beer_id=:beer_id");
            query.setParameter("user_id", user_id);
            query.setParameter("beer_id", beer_id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
