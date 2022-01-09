package com.viktor.beer.services.common;

import com.viktor.beer.models.Beer;
import com.viktor.beer.models.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    void update(Rating rating);

    void delete(Rating rating);

    double getAverageRatingForBeer(int beerId);

    List<Rating> getBeersOfUser(int userId);

    List<Beer> getTopBeersOfUser(int userId);
}
