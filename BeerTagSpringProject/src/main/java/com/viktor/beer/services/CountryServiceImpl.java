package com.viktor.beer.services;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Country;
import com.viktor.beer.repositories.common.CountryRepository;
import com.viktor.beer.services.common.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private static final String NOT_FOUND_COUNTRY_BY_ID = "Country with id:%d does not exists!";
    private final CountryRepository repository;
    private static final String COUNTRY_ALREADY_EXISTS = "Country with name:%s already exists!";

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Country> getAll() {
        return repository.getAll();
    }

    @Override
    public Country getById(int id) {
        List<Country> countries = repository.getById(id);
        if (countries.size() == 0) {
            throw new EntityNotFoundException(
                    String.format(NOT_FOUND_COUNTRY_BY_ID, id));
        }
        return countries.get(0);
    }

    public List<Country> getByName(String name) {
        return repository.getByName(name);
    }

    public void create(Country country) {
        if (repository.checkCountryExists(country.getName())) {
            throw new DuplicateEntityException(
                    String.format(COUNTRY_ALREADY_EXISTS, country.getName()));
        }
        repository.create(country);
    }

    @Override
    public void delete(int id) {
        Country country = getById(id);
        repository.delete(country);
    }
}
