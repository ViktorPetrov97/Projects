package com.viktor.beer.services.common;

import com.viktor.beer.models.Brewery;

import java.util.List;

public interface BreweryService {
    Brewery getById(int id);
    List<Brewery> getAll();
    void create(Brewery brewery);
    void delete(int id);
    List<Brewery> getByName(String name);
}
