package com.viktor.beer.repositories.common;

import com.viktor.beer.models.Country;

import java.util.List;

public interface CountryRepository {
    List<Country> getAll();

    List<Country> getByName(String name);

    List<Country> getById(int id);

    void create(Country country);

    void delete(Country country);

    boolean checkCountryExists(String name);
}
