package com.viktor.beer.controlers.rest;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Beer;
import com.viktor.beer.models.Style;
import com.viktor.beer.services.common.BeerService;
import com.viktor.beer.services.common.StyleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/styles")
public class StyleRestController {
    private final StyleService styleService;
    private final BeerService beerService;

    public StyleRestController(StyleService styleService, BeerService beerService) {
        this.styleService = styleService;
        this.beerService = beerService;
    }

    @GetMapping
    public List<Style> getAll() {
        return styleService.getAll();
    }

    @GetMapping("/{id}")
    public Style getById(@PathVariable int id) {
        try {
            return styleService.getById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @GetMapping("/{id}/beers")
    public List<Beer> getStyleBeers(@PathVariable int id) {
        return beerService.filterByStyle(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid Style style) {
        try {
            styleService.create(style);
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try {
            styleService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
