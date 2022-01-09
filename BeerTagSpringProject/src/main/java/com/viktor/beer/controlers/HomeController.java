package com.viktor.beer.controlers;

import com.viktor.beer.models.UserDetails;
import com.viktor.beer.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller

public class HomeController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/profile")
    public String showUserProfile(Model model,
                                  Principal principal) {
        UserDetails user = userService.getByUsername(principal.getName());

        model.addAttribute("show-information", user.getUsername());
        model.addAttribute("user",user);

        return "user-profile";
    }




}
