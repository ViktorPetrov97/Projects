package com.viktor.beer.services;

import com.viktor.beer.models.User;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.InvalidOperationException;
import com.viktor.beer.models.Beer;
import com.viktor.beer.repositories.common.BeerRepository;
import com.viktor.beer.services.common.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerServiceImpl implements BeerService {
    private BeerRepository repository;

    @Autowired
    public BeerServiceImpl(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Beer beer) {
        if (!repository.filterByName(beer.getName()).isEmpty()) {
            throw new DuplicateEntityException(
                    String.format("Beer with the name %s already exists", beer.getName())
            );
        }
        repository.create(beer);
    }

    @Override
    public Beer getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Beer> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Beer beer, User user) {
        checkUserCanEditBeer(beer, user);
        checkBeerNameUnique(beer);
        repository.update(beer);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Beer> filterByStyle(int styleId) {
        return repository.filterByStyle(styleId);
    }

    @Override
    public List<Beer> filterByName(String name) {
        return repository.filterByName(name);
    }

    @Override
    public List<Beer> filter(Optional<Integer> id, Optional<String> name) {
        return repository.filter(id, name);
    }

    private void validateUniqueBeerName(String name) {
        if (repository.existsByName(name)) {
            throw new DuplicateEntityException(String.format("Beer with name %s already exists!", name));
        }
    }

    @Override
    public List<Beer> search(String name, int styleId, int countryId) {

        return repository.search(name, styleId, countryId);
    }


    private void checkUserCanEditBeer(Beer beer, User user) {
        if (!user.isAdmin() &&
                beer.getOwner().getId() != user.getUserDetails().getId()) {
            throw new InvalidOperationException(
                    String.format(
                            "User %s can't edit beer %s",
                            user.getUsername(),
                            beer.getName()));
        }
    }

    private void checkBeerNameUnique(Beer beer) {
        List<Beer> beers = repository.filterByName(beer.getName());
        if (beers.size() > 0 && beers.get(0).getId() != beer.getId()) {
            throw new DuplicateEntityException(
                    String.format(
                            "Beer with name %s already exists!",
                            beer.getName())
            );
        }
    }

    @Override
    public List<Beer> sortByName() {
        return repository.SortByName();
    }

    @Override
    public List<Beer> sortByAbv() {
        return repository.SortByAbv();
    }

    @Override
    public List<Beer> sortByRating() {
        return repository.SortByRating();
    }
}
