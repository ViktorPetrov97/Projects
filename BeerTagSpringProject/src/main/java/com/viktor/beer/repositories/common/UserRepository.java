package com.viktor.beer.repositories.common;

import com.viktor.beer.models.Beer;
import com.viktor.beer.models.User;
import com.viktor.beer.models.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository {
    void create(UserDetails userDetails);

    UserDetails getById(int id);

    User getUserById(int id);

    UserDetails getByUsername(String username);

    User getByUsernameFromUser(String username);

    boolean existsByName(String name);

    List<UserDetails> getAll();

    void update(UserDetails userDetails);

    void delete(int id);

    List<UserDetails> filter(Optional<Integer> id, Optional<String> name, Optional<String> email);

    boolean checkIfBeerExistInWishList(int user_id, int beer_id);

    boolean checkIfBeerExistInDrankList(int user_id, int beer_id);

    Set<Beer> showList(String listOfChoice, UserDetails userDetails);

    public void deleteBeerFromWishList(int beerId, int userId);

    public void deleteBeerFromDrankList(int beerId, int userId);

    public void removeRateForBeer(int user_id, int beer_id);

    public Object getRateForBeer(int user_id, int beer_id, int rating);

    public boolean checkIfBeerIsRated(int user_id, int beer_id);

    void update(User user);

    void enable(String userName);

    void disable(String userName);

}
