package com.viktor.beer.controlers;


import com.viktor.beer.models.Beer;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.services.common.BeerService;
import com.viktor.beer.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    private UserService userService;
    private UserDetailsManager userDetailsManager;
    private BeerService beersService;

    @Autowired
    public AdminController(UserService userService, UserDetailsManager userDetailsManager, BeerService beersService) {
        this.userService = userService;
        this.userDetailsManager = userDetailsManager;
        this.beersService = beersService;
    }

    @GetMapping("/admin")
    public String adminPortal(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin";
    }

    @PostMapping("/{userName}/enable")
    public String enableUser(@PathVariable String userName) {
        userService.enable(userName);
        return "index";
    }
    @PostMapping("/{userName}/disable")
    public String disableUser(@PathVariable String userName) {
        userService.disable(userName);
        return "index";
    }

    @PostMapping("/admin/{id}/delete")
    public String deleteUser(@PathVariable int id) {
        UserDetails userDetails = userService.getById(id);
        List<Beer> beerList = beersService.getAll();
        for (Beer beer: beerList) {

            if (userService.checkIfBeerExistInDrankList(userDetails.getId(), beer.getId())) {
                userService.deleteBeerFromDrankList(beer.getId(), (userDetails.getId()));
            }

            if (userService.checkIfBeerExistInWishList((userDetails.getId()), beer.getId())) {
                userService.deleteBeerFromWishList(beer.getId(), (userDetails.getId()));
            }
            beersService.delete(beer.getId());

        }
        userService.delete(id);
        userDetailsManager.deleteUser(userDetails.getUsername());

        return "redirect:/admin";
    }
}
