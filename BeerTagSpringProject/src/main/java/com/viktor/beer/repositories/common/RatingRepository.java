package com.viktor.beer.repositories.common;

import com.viktor.beer.models.Rating;

import java.util.List;

public interface RatingRepository {
    Rating create(Rating rating);

    void update(Rating rating);

    void delete(Rating rating);

    double getAverageRatingForBeer(int beerId);

    List<Rating> getBeersOfUser(int userId);

//    List<Rating> getAllBeersRating();
}
