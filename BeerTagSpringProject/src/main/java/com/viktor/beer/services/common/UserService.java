package com.viktor.beer.services.common;

import com.viktor.beer.models.Beer;
import com.viktor.beer.models.User;
import com.viktor.beer.models.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    void create(UserDetails userDetails);

    UserDetails getById(int id);

    User getUserById(int id);

    UserDetails getByUsername(String username);

    List<UserDetails> getAll();

    void update(UserDetails userDetails);

    void delete(int id);

    List<UserDetails> filter(Optional<Integer> id, Optional<String> name, Optional<String> email);

    void addToWishList(UserDetails userDetails, Beer beer);

    void addToDrankList(UserDetails userDetails, Beer beer);

    void addToList(String listOfChoice, int user_id, int beer_id);

    Set<Beer> showList(String listOfChoice, int user_id);

    void deleteBeerFromWishList(int beerId, int userId);

    void deleteBeerFromDrankList(int beerId, int userId);

    User getByUsernameFromUser(String username);

    void update(User user);

    void rateBeer(int user_id, int beer_id, int rating);

    void enable(String userName);

    void disable(String userName);

    boolean checkIfBeerExistInWishList(int user_id, int beer_id);

    boolean checkIfBeerExistInDrankList(int user_id, int beer_id);
}
