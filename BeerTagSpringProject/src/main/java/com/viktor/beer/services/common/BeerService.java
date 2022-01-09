package com.viktor.beer.services.common;

import com.viktor.beer.models.Beer;
import com.viktor.beer.models.User;

import java.util.List;
import java.util.Optional;

public interface BeerService {
    void create(Beer beer);

    Beer getById(int id);

    List<Beer> getAll();

    void update(Beer beer, User user);

    void delete(int id);

    List<Beer> filterByStyle(int styleId);

    List<Beer> filterByName(String name);

    List<Beer> filter(Optional<Integer> id, Optional<String> name);

    List<Beer> search(String name, int styleId, int countryId);

    // TODO: 9/22/2020 sort by Name, ABV and rating

    List<Beer> sortByName();

    List<Beer> sortByAbv();

    List<Beer> sortByRating();
}
