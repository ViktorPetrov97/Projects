package com.viktor.beer.repositories.common;

import com.viktor.beer.models.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> getAll();

    List<Tag> getById(int id);

    List<Tag> getByName(String name);

    boolean checkTagExists(String name);

    void create(Tag brewery);

    void delete(Tag tag);
}
