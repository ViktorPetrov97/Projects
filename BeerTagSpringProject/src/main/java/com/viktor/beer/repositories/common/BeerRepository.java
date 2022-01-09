package com.viktor.beer.repositories.common;

import com.viktor.beer.models.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerRepository {
    void create(Beer beer);

    Beer getById(int id);

    boolean existsByName(String name);

    List<Beer> getAll();

    void update(Beer beer);

    void delete(int id);

    List<Beer> filterByName(String name);

    List<Beer> filterByStyle(int styleId);

    List<Beer> filter(Optional<Integer> id, Optional<String> name);

    List<Beer> search(String name, int styleId, int countryId);

    // TODO: 9/22/2020 sort by Name, ABV and rating

    // TODO: 9/22/2020 filter by origin country, style and tags

    // TODO: 9/22/2020 Rate a beer

    List<Beer> SortByName();

    List<Beer> SortByAbv();

    List<Beer> SortByRating();


}
