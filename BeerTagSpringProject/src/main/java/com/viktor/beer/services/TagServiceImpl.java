package com.viktor.beer.services;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Tag;
import com.viktor.beer.repositories.common.TagRepository;
import com.viktor.beer.services.common.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private static final String NOT_FOUND_TAG_BY_ID = "Tag with id:%d does not exists!";
    private static final String TAG_ALREADY_EXISTS = "Tag with name:%s already exists!";
    private final TagRepository repository;

    @Autowired
    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    public List<Tag> getAll() {
        return repository.getAll();
    }

    public Tag getById(int id) {
        List<Tag> tags = repository.getById(id);
        if (tags.size() == 0) {
            throw new EntityNotFoundException(
                    String.format(NOT_FOUND_TAG_BY_ID, id));
        }
        return tags.get(0);
    }

    public List<Tag> getByName(String name) {
        return repository.getByName(name);
    }

    public void create(Tag tag) {
        if (repository.checkTagExists(tag.getName())) {
            throw new DuplicateEntityException(
                    String.format(TAG_ALREADY_EXISTS, tag.getName()));
        }
        repository.create(tag);
    }

    public void delete(int id) {
        Tag tag = getById(id);
        repository.delete(tag);
    }

    @Override
    public boolean checkTagExists(String name) {
        return getByName(name).size() != 0;
    }
}
