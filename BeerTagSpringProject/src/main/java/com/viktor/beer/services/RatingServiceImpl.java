package com.viktor.beer.services;

import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Beer;
import com.viktor.beer.models.Rating;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.repositories.common.RatingRepository;
import com.viktor.beer.services.common.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating create(Rating rating) {
        Beer beer = rating.getBeer();
        if (beer == null) {
            throw new EntityNotFoundException("Beer not found");
        }

        UserDetails userDetails = rating.getUser();
        if (userDetails == null) {
            throw new EntityNotFoundException("User not found!");
        }

        beer.getRatingList().add(rating);
        return ratingRepository.create(rating);
    }

    @Override
    public void update(Rating rating) {
        Beer beer = rating.getBeer();
        if (beer == null) {
            throw new EntityNotFoundException("Beer not found!");
        }

        UserDetails UserDetails = rating.getUser();
        if (UserDetails == null) {
            throw new EntityNotFoundException("User not found!");
        }

        ratingRepository.update(rating);
    }

    @Override
    public void delete(Rating rating) {
        ratingRepository.delete(rating);
    }

    @Override
    public double getAverageRatingForBeer(int beerId) {
        return ratingRepository.getAverageRatingForBeer(beerId);
    }

    @Override
    public List<Rating> getBeersOfUser(int userId) {
        return ratingRepository.getBeersOfUser(userId);
    }

    @Override
    public List<Beer> getTopBeersOfUser(int userId) {
        Map<Double, Beer> beerMap = new HashMap<>();

        for (Rating rating : getBeersOfUser(userId)) {
            double avgRating = getAverageRatingForBeer(rating.getBeer().getId());
            Beer beer = rating.getBeer();
            beerMap.put(avgRating, beer);
        }

        Map<Double, Beer> map = beerMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        return new ArrayList<>(map.values());
    }
}
