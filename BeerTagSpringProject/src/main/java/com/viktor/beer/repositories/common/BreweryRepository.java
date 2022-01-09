package com.viktor.beer.repositories.common;

import com.viktor.beer.models.Brewery;

import java.util.List;

public interface BreweryRepository {
    void create(Brewery brewery);
    void delete(Brewery brewery);
    Brewery getById(int id);
    List<Brewery> getAll();
    boolean checkBreweryExists(String name);
    List<Brewery> getByName(String name);

}
