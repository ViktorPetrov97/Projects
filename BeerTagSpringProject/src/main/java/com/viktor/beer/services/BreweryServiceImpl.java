package com.viktor.beer.services;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.models.Brewery;
import com.viktor.beer.repositories.common.BreweryRepository;
import com.viktor.beer.services.common.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryServiceImpl implements BreweryService {
    private static final String BREWERY_ALREADY_EXIST = "Brewery with name %s already exists!";
    private final BreweryRepository repository;

    @Autowired
    public BreweryServiceImpl(BreweryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Brewery getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Brewery> getAll() {
        return repository.getAll();
    }

    @Override
    public void create(Brewery brewery) {
        if (repository.checkBreweryExists(brewery.getName())) {
            throw new DuplicateEntityException(
                    String.format(BREWERY_ALREADY_EXIST, brewery.getName()));
        }
        repository.create(brewery);
    }

    @Override
    public void delete(int id) {
        Brewery brewery = getById(id);
        repository.delete(brewery);
    }

    @Override
    public List<Brewery> getByName(String name) {
        return repository.getByName(name);
    }
}
