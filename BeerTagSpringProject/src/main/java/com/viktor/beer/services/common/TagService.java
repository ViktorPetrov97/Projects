package com.viktor.beer.services.common;

import com.viktor.beer.models.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();

    Tag getById(int id);

    List<Tag> getByName(String name);

    void create(Tag tag);

    void delete(int id);

    boolean checkTagExists(String name);
}
