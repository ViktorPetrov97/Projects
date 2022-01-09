package com.viktor.beer.controlers;

import com.viktor.beer.models.User;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.services.common.BeerService;
import com.viktor.beer.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;
    private BeerService beerService;

    @Autowired
    public UserController(UserService userService,
                          BeerService beerService) {
        this.userService = userService;
        this.beerService = beerService;
    }

    @GetMapping("/getAllUsers")
    public String getAllUsers(
            Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @RequestMapping("/add/wishlist/{beer_id}")
    public String addBeerToWishList(Model model,
                                    @PathVariable int beer_id, Principal principal) {

        User user = userService.getByUsernameFromUser(principal.getName());
        userService.addToList("wishlist", user.getUserDetails().getId(), beer_id);
        model.addAttribute("beer", beerService.getById(beer_id));
        return "beerProfile";
    }

    @RequestMapping("/add/dranklist/{beer_id}")
    public String addBeerToDrankList(Model model, @PathVariable int beer_id, Principal principal) {

        User user = userService.getByUsernameFromUser(principal.getName());
        userService.deleteBeerFromWishList(beer_id, user.getUserDetails().getId());
        userService.addToList("dranklist", user.getUserDetails().getId(), beer_id);
        model.addAttribute("beer", beerService.getById(beer_id));

        return "beerProfile";
    }


    @GetMapping("/wishlist")
    public String showWishlist(Model model,
                               Principal principal) {
        User user = userService.getByUsernameFromUser(principal.getName());

        model.addAttribute("beers",
                userService.showList("wishlist", user.getUserDetails().getId()));
        return "show-wishlist";
    }

    @GetMapping("/dranklist")
    public String showDrankList(Model model,
                                Principal principal) {
        User user = userService.getByUsernameFromUser(principal.getName());

        model.addAttribute("beers",
                userService.showList("dranklist", user.getUserDetails().getId()));
        return "show-dranklist";
    }

    @RequestMapping("/wishlist/remove/{beer_id}")
    public String removeBeerFromWishlist(Model model,
                                         Principal principal,
                                         @PathVariable int beer_id) {
        User user = userService.getByUsernameFromUser(principal.getName());
        userService.deleteBeerFromWishList(beer_id, user.getUserDetails().getId());

        model.addAttribute("beers",
                userService.showList("wishlist", user.getUserDetails().getId()));
        return "show-wishlist";
    }

    @RequestMapping("/dranklist/remove/{beer_id}")
    public String removeBeerFromDranklist(Model model,
                                          Principal principal,
                                          @PathVariable int beer_id) {
        User user = userService.getByUsernameFromUser(principal.getName());
        userService.deleteBeerFromDrankList(beer_id, user.getUserDetails().getId());

        model.addAttribute("beers",
                userService.showList("dranklist", user.getUserDetails().getId()));
        return "show-dranklist";
    }

    @RequestMapping("/rating/{rate}/{beer_id}")  //POST (in beers controller) /beers/{id}/rating    body (rating value)
    public String rateBeer(Model model,
                           @PathVariable int rate,
                           Principal principal,
                           @PathVariable int beer_id) {
        UserDetails user = userService.getByUsername(principal.getName());
        userService.rateBeer(user.getId(), beer_id, rate);

        model.addAttribute("beers",
                userService.showList("dranklist", user.getId()));
        return "show-dranklist";
    }
}

