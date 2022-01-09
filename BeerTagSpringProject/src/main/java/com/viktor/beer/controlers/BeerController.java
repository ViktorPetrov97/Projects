package com.viktor.beer.controlers;

import com.viktor.beer.exceptions.DuplicateEntityException;
import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.exceptions.InvalidOperationException;
import com.viktor.beer.models.*;
import com.viktor.beer.services.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/beers")
public class BeerController {

    private final BeerService beerService;
    private final StyleService styleService;
    private final BreweryService breweryService;
    private final TagService tagService;
    private final CountryService countryService;
    private final UserService userService;
    private final RatingService ratingService;

    @Autowired
    public BeerController(BeerService beerService, StyleService styleService, BreweryService breweryService, TagService tagService, CountryService countryService, UserService userService, RatingService ratingService) {
        this.beerService = beerService;
        this.styleService = styleService;
        this.breweryService = breweryService;
        this.tagService = tagService;
        this.countryService = countryService;
        this.userService = userService;
        this.ratingService = ratingService;
    }

    @GetMapping
    public String showBeers(Model model) {

        // for displaying information
        model.addAttribute("beers", beerService.getAll());
        model.addAttribute("styles", styleService.getAll());
        model.addAttribute("countries", countryService.getAll());

        // for receiving user input
        model.addAttribute("searchBeerDto", new SearchBeerDTO());
        return "results";
    }

    @GetMapping("/sort/name")
    public String sortBeersByName(Model model) {

        model.addAttribute("beers", beerService.sortByName());
        model.addAttribute("searchBeerDto", new SearchBeerDTO());

        return "results";
    }
    @GetMapping("/sort/abv")
    public String sortBeersByAbv(Model model) {

        model.addAttribute("beers", beerService.sortByAbv());
        model.addAttribute("searchBeerDto", new SearchBeerDTO());

        return "results";
    }
    @GetMapping("/sort/rating")
    public String sortBeersByRating(Model model,SearchBeerDTO searchBeerDTO) {

        model.addAttribute("beers", beerService.sortByRating());
        model.addAttribute("searchBeerDto", new SearchBeerDTO());

        return "results";
    }


    @PostMapping
    public String searchBeers(@ModelAttribute SearchBeerDTO searchBeerDTO, Model model) {
        List<Beer> search = beerService.search(searchBeerDTO.name, searchBeerDTO.styleId, searchBeerDTO.getCountryId());
        model.addAttribute("beers", search);
        model.addAttribute("styles", styleService.getAll());
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("searchBeerDto", searchBeerDTO);
        return "results";
    }

    @GetMapping("/new")
    public String getCreateBeerPage(Model model) {

        model.addAttribute("beerDto", new CreateBeerDTO());
        model.addAttribute("styles", styleService.getAll());
        model.addAttribute("breweries", breweryService.getAll());
        model.addAttribute("tags", tagService.getAll());

        return "CreateBeer";
    }

    @PostMapping("/new")
    public String handleCreateBeer(@Valid @ModelAttribute CreateBeerDTO dto,
                                   BindingResult bindingResult,
                                   Model model,
                                   Principal principal) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("styles", styleService.getAll());
            model.addAttribute("beerDto", dto);
            return "CreateBeer";
        }

        try {
            User user = userService.getByUsernameFromUser(principal.getName());
            Beer beer = new Beer();
            beer = ModelMapper.toBeer(dto, beer, styleService, breweryService, tagService);
            beer.setOwner(user.getUserDetails());
            beerService.create(beer);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        return "redirect:/beers";
    }

    @GetMapping("/{id}/delete")
    public String deleteBeer(@PathVariable int id, Principal principal) {
        User user = userService.getByUsernameFromUser(principal.getName());
        Beer beer = beerService.getById(id);

        if (user.getUserDetails().getUsersDrankList().stream().filter(beer1 -> beer.getId() == id).count() == 1) {
            userService.deleteBeerFromDrankList(id, user.getUserDetails().getId());
        }

        if (user.getUserDetails().getUsersWishList().stream().filter(beer1 -> beer.getId() == id).count() == 1) {
            userService.deleteBeerFromWishList(id, user.getUserDetails().getId());
        }
        beerService.delete(id);
        return "redirect:/beers";
    }

    @GetMapping("/{id}")
    public String getEditBeerPage(@PathVariable Integer id, Model model) {

        Beer beer;

        try {
            beer = beerService.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        CreateBeerDTO dto = new CreateBeerDTO();
        dto.setAbv(beer.getAbv());
        dto.setName(beer.getName());
        dto.setStyleId(beer.getStyle().getId());
        dto.setBreweryId(beer.getBrewery().getId());

        model.addAttribute("styles", styleService.getAll());
        model.addAttribute("breweries", breweryService.getAll());
        model.addAttribute("tags", tagService.getAll());
        model.addAttribute("beerDto", dto);
        model.addAttribute("id", id);

        return "CreateBeer";
    }

    @PostMapping("/{id}")
    public String handleEditBeer(@PathVariable int id,
                                 @Valid @ModelAttribute CreateBeerDTO dto,
                                 BindingResult bindingResult,
                                 Model model,
                                 Principal principal) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("styles", styleService.getAll());
            model.addAttribute("breweries", breweryService.getAll());
            model.addAttribute("tags", tagService.getAll());
            model.addAttribute("beerDto", dto);
            return "CreateBeer";
        }

        try {
            User user = userService.getByUsernameFromUser(principal.getName());
            Beer beerToUpdate = beerService.getById(id);
            beerToUpdate = ModelMapper.toBeer(dto, beerToUpdate, styleService, breweryService, tagService);
            beerService.update(beerToUpdate, user);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (InvalidOperationException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }

        model.addAttribute("styles", styleService.getAll());
        model.addAttribute("beers", beerService.getAll());
        model.addAttribute("searchBeerDto", new SearchBeerDTO());

        return "results";
    }

    @GetMapping("/beerProfile/{id}")
    public String beerProfile(Model model, @PathVariable int id) {

        model.addAttribute("beer", beerService.getById(id));
        return "beerProfile";
    }
}
