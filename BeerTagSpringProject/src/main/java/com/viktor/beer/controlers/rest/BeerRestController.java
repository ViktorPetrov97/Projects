package com.viktor.beer.controlers.rest;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.exceptions.InvalidOperationException;
import com.viktor.beer.models.*;
import com.viktor.beer.models.*;
import com.viktor.beer.services.common.BeerService;
import com.viktor.beer.services.common.BreweryService;
import com.viktor.beer.services.common.StyleService;
import com.viktor.beer.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beers")

public class BeerRestController {

    private final BeerService service;
    private final StyleService styleService;
    private final UserService userService;
    private final BreweryService breweryService;

    @Autowired
    public BeerRestController(BeerService service, StyleService styleService, UserService userService, BreweryService breweryService) {
        this.service = service;
        this.styleService = styleService;
        this.userService = userService;
        this.breweryService = breweryService;
    }

    @GetMapping
    public List<Beer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Beer getById(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/search")

    public List<Beer> search(@RequestParam(required = false) Integer styleId,
                             @RequestParam(required = false) Integer countryId,
                             @RequestParam(required = false) String name) {
        Optional<String> nId = Optional.ofNullable(name); //optional for name
        Optional<Integer> sId = Optional.ofNullable(styleId); //optional for style id
        Optional<Integer> cId = Optional.ofNullable(countryId); //optional for country id
        return service.search(nId.orElse(""), sId.orElse(-1),cId.orElse(-1));
        // TODO: 22.9.2020 г. FOR COMPREHENSION: optional връща NULL или друго с това казваме ако е NULL да върне друга стойност. (в случая -1 и/или празен стринг)
    }

    @PostMapping
    public Beer create(@Valid @RequestBody CreateBeerDTO beerDto, Principal principal) {
        try {
            // TODO: 9/25/2020 Fix rest controllers 
            Beer beer = new Beer();
            Beer newBeer = toBeer(beerDto, beer, styleService, breweryService);
            UserDetails beerOwner = userService.getByUsername(principal.getName());
            newBeer.setOwner(beerOwner);
            service.create(newBeer);
            return newBeer;
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());

        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping
    public Beer update(@Valid @RequestBody CreateBeerDTO beerDTO,
                       Principal principal) {
        try {
            Beer beer = service.getById(beerDTO.getId());
            Beer updatedBeer = toBeer(beerDTO, beer, styleService, breweryService);
            User user = userService.getByUsernameFromUser(principal.getName());
            updatedBeer.setOwner(beer.getOwner());
            service.update(updatedBeer, user);
            return updatedBeer;
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (InvalidOperationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    // TODO: 9/11/2020 To implement updateTags method
    @PutMapping("/{id}/tags")
    public List<Tag> updateTags(@RequestParam int id, @RequestBody List<String> tags) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    private static Beer toBeer(CreateBeerDTO beerDto, Beer beer, StyleService styleService, BreweryService breweryService) {
        beer.setId(beerDto.getId());
        beer.setName(beerDto.getName());
        beer.setAbv(beerDto.getAbv());
        Style style = styleService.getById(beerDto.getStyleId());
        beer.setStyle(style);
        Brewery brewery = breweryService.getById(beerDto.getBreweryId());
        beer.setBrewery(brewery);
        return beer;
    }

//    private Optional<Beer> findById(int id) {
//        return beers.stream()
//                .filter(b -> b.getId() == id)
//                .findFirst();
//    }
}
