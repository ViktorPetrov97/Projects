package com.viktor.beer.controlers.rest;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Brewery;
import com.viktor.beer.services.common.BreweryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/breweries")
public class BreweryRestController {

    private BreweryService service;

    public BreweryRestController(BreweryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Brewery> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Brewery getOne(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public void create(@RequestBody @Valid Brewery brewery) {
        try {
            service.create(brewery);
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
