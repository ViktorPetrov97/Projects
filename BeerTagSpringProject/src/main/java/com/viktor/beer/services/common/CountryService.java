package com.viktor.beer.services.common;

import com.viktor.beer.models.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAll();

    Country getById(int id);

    List<Country> getByName(String name);

    void create(Country country);

    void delete(int id);
}
