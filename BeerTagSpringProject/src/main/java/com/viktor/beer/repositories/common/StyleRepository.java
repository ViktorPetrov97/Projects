package com.viktor.beer.repositories.common;

import com.viktor.beer.models.Style;

import java.util.List;

public interface StyleRepository {
    List<Style> getAll();

    Style getById(int id);

    List<Style> getByName(String name);

    void create(Style style);

    void delete(Style style);

    boolean checkStyleExists(String name);
}
