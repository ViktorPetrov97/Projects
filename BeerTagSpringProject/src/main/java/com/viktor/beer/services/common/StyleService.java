package com.viktor.beer.services.common;

import com.viktor.beer.models.Style;

import java.util.List;

public interface StyleService {
    List<Style> getAll();

    Style getById(int id);

    List<Style> getByName(String name);

    void create(Style style);

    void delete(int id);
}
