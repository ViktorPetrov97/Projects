package com.viktor.beer.models;

import com.viktor.beer.services.common.BreweryService;
import com.viktor.beer.services.common.StyleService;
import com.viktor.beer.services.common.TagService;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {

    public static Beer toBeer(CreateBeerDTO dto, Beer beer, StyleService styleService, BreweryService breweryService, TagService tagService) {
        Style style = styleService.getById(dto.getStyleId());
        Brewery brewery = breweryService.getById(dto.getBreweryId());
        beer.setName(dto.getName());
        beer.setStyle(style);
        beer.setAbv(dto.getAbv());
        beer.setBrewery(brewery);
        Tag tag = tagService.getById(dto.getTagId());
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        beer.setTags(tags);
        beer.setPicture(dto.getPicture());
        return beer;
    }
}
