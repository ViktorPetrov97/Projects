package com.viktor.beer.services;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.models.Style;
import com.viktor.beer.repositories.common.StyleRepository;
import com.viktor.beer.services.common.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {
    private static final String STYLE_ALREADY_EXISTS = "Style with name %s already exists!";
    private final StyleRepository repository;

    @Autowired
    public StyleServiceImpl(StyleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Style> getAll() {
        return repository.getAll();
    }

    @Override
    public Style getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Style> getByName(String name) {
        return null;
    }

    @Override
    public void create(Style style) {
        if (repository.checkStyleExists(style.getName())) {
            throw new DuplicateEntityException(
                    String.format(STYLE_ALREADY_EXISTS, style.getName()));
        }
        repository.create(style);
    }

    @Override
    public void delete(int id) {
        Style style = getById(id);
        repository.delete(style);
    }
}
