package com.viktor.beer.controlers.rest;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.Beer;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")

public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDetails> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDetails getById(@PathVariable int id) {
        try {
            return userService.getById(id);
        }catch (EntityNotFoundException e ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/search")

    public List<UserDetails> search(@RequestParam(required = false) Integer id,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String email) {

        return userService.filter(Optional.ofNullable(id), Optional.ofNullable(name), Optional.ofNullable(email));
    }

    @PostMapping
    public UserDetails create(@Valid @RequestBody UserDetails userDetails) {

        try{
           userService.create(userDetails);
           return userDetails;
        }catch (DuplicateEntityException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping
    public UserDetails update(@Valid @RequestBody UserDetails userDetails) {
        try{
            userService.update(userDetails);
            return userDetails;
        }catch (DuplicateEntityException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try{
            userService.delete(id);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{user_id}/{list}/{beer_id}")
    public void addToList(@PathVariable int user_id, @PathVariable String list, @PathVariable int beer_id) {
        try {
            userService.addToList(list, user_id, beer_id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        } catch (IllegalArgumentException i) {
            throw new IllegalArgumentException(i.getMessage());
        }catch (DuplicateEntityException d){
            throw new ResponseStatusException(HttpStatus.CONFLICT,d.getMessage());
        }
    }

    @GetMapping("/{user_id}/{list}")
    public Set<Beer> showListOfBeers(@PathVariable int user_id,@PathVariable String list){
        try {
            return userService.showList(list, user_id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (IllegalArgumentException i) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, i.getMessage());
        }
    }

}
