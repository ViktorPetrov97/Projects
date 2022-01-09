package com.viktor.beer.services;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.models.Beer;
import com.viktor.beer.models.Rating;
import com.viktor.beer.models.User;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.repositories.common.BeerRepository;
import com.viktor.beer.repositories.common.UserRepository;
import com.viktor.beer.services.common.BeerService;
import com.viktor.beer.services.common.RatingService;
import com.viktor.beer.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceSqlImpl implements UserService {
    private static final String NOT_EXISTING_LIST = "%s does not exists for this user!";
    static final String BEER_ALREADY_EXIST_IN_WISHLIST = "Beer with id %d already exists in wishlist of user with id %d!";
    static final String BEER_ALREADY_EXIST_IN_DRANKLIST = "Beer with id %d already exists in dranklist of user with id %d!";
    private final UserRepository userRepository;
    private final BeerRepository beerRepository;
    private final BeerService beerService;
    private final RatingService ratingService;

    @Autowired
    public UserServiceSqlImpl(UserRepository userRepository, BeerRepository beerRepository, BeerService beerService, RatingService ratingService) {
        this.userRepository = userRepository;
        this.beerRepository = beerRepository;
        this.beerService = beerService;
        this.ratingService = ratingService;
    }

    @Override
    public void create(UserDetails userDetails) {
        userRepository.create(userDetails);
    }

    @Override
    public UserDetails getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public UserDetails getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public List<UserDetails> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void update(UserDetails userDetails) {
        userRepository.update(userDetails);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<UserDetails> filter(Optional<Integer> id, Optional<String> name, Optional<String> email) {
        return null;
    }

    @Override
    public void addToList(String listOfChoice, int user_id, int beer_id) {
        UserDetails userDetails = getById(user_id);
        Beer beer = beerService.getById(beer_id);

        if (listOfChoice.equalsIgnoreCase("wishlist")) {
            addToWishList(userDetails, beer);

        } else if (listOfChoice.equalsIgnoreCase("dranklist")) {

            addToDrankList(userDetails, beer);
        } else {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_LIST, listOfChoice));
        }
    }

    @Override
    public void addToWishList(UserDetails userDetails, Beer beer) {
        if (userRepository.checkIfBeerExistInWishList(userDetails.getId(), beer.getId())) {
            throw new DuplicateEntityException(
                    String.format(BEER_ALREADY_EXIST_IN_WISHLIST, beer.getId(), userDetails.getId()));
        }
        userDetails.addToWishlist(beer);
        userRepository.update(userDetails);
    }

    @Override
    public void addToDrankList(UserDetails userDetails, Beer beer) {

        if (userRepository.checkIfBeerExistInDrankList(userDetails.getId(), beer.getId())) {
            throw new DuplicateEntityException(
                    String.format(BEER_ALREADY_EXIST_IN_DRANKLIST, beer.getId(), userDetails.getId()));
        }
        userDetails.addToDranklist(beer);
        userRepository.update(userDetails);
    }

    @Override
    public Set<Beer> showList(String listOfChoice, int user_id) {
        UserDetails userDetails = getById(user_id);
        return userRepository.showList(listOfChoice, userDetails);
    }

    @Override
    public void deleteBeerFromWishList(int beerId, int userId) {
        userRepository.deleteBeerFromWishList(beerId, userId);
    }

    @Override
    public void deleteBeerFromDrankList(int beerId, int userId) {
        userRepository.deleteBeerFromDrankList(beerId, userId);
    }

    @Override
    public User getByUsernameFromUser(String username) {
        return userRepository.getByUsernameFromUser(username);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void rateBeer(int user_id, int beer_id, int rating) {
        if (userRepository.checkIfBeerIsRated(user_id, beer_id)) {
            userRepository.removeRateForBeer(user_id, beer_id);
        }

        UserDetails user = getById(user_id);
        Beer beer=beerService.getById(beer_id);

        Rating rating1 = new Rating(user, beer, rating);

        ratingService.create(rating1);
    }

    @Override
    public void enable(String userName) {
        User user = getByUsernameFromUser(userName);
        user.setEnabled(true);
        userRepository.enable(userName);
    }
    @Override
    public void disable(String userName) {
        User user = getByUsernameFromUser(userName);
        user.setEnabled(false);
        userRepository.disable(userName);
    }

    @Override
    public boolean checkIfBeerExistInWishList(int user_id, int beer_id) {
        return userRepository.checkIfBeerExistInWishList(user_id, beer_id);
    }

    @Override
    public boolean checkIfBeerExistInDrankList(int user_id, int beer_id) {
        return userRepository.checkIfBeerExistInDrankList(user_id, beer_id);
    }


}
