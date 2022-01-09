package com.viktor.beer.controlers;

import com.viktor.beer.exceptions.EntityNotFoundException;
import com.viktor.beer.models.User;
import com.viktor.beer.models.UserDetails;
import com.viktor.beer.models.UserRegistrationDTO;
import com.viktor.beer.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class RegistrationController {
    private UserDetailsManager userDetailsManager;
    private UserService userService;

    @Autowired
    public RegistrationController(UserDetailsManager userDetailsManager, UserService userService) {
        this.userDetailsManager = userDetailsManager;
        this.userService = userService;

    }

    @GetMapping("/register_page")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserRegistrationDTO());
        return "register_page";
    }

    @PostMapping("/register_page")
    public String registerUser(@Valid @ModelAttribute UserRegistrationDTO userDto, BindingResult bindingResult, Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            model.addAttribute("error", "Username/password can't be empty!");
            return "register_page";
        }

        if (userDetailsManager.userExists(userDto.getUsername())) {
            model.addAttribute("user", userDto);
            model.addAttribute("error", "User with the same username already exists!");
            return "register_page";
        }
        if (!userDto.getPassword().equals(userDto.getPasswordConfirmation())) {
            model.addAttribute("user", userDto);
            model.addAttribute("error", "Password confirmation doesn't match password!");
            return "register_page";
        }

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        org.springframework.security.core.userdetails.User newUser =
                new org.springframework.security.core.userdetails.User(
                        userDto.getUsername(), "{noop}" + userDto.getPassword(), authorities);

        userDetailsManager.createUser(newUser);

        User user = userService.getByUsernameFromUser(userDto.getUsername());
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(userDto.getUsername());
        userDetails.setEmail(userDto.getEmail());
        userDetails.setFirstName(userDto.getFirstName());
        userDetails.setLastName(userDto.getLastName());
        userService.create(userDetails);

        user.setUserDetails(userDetails);
        userService.update(user);
        return "register-confirmation";
    }

    @GetMapping("/edit-user/{username}")
    public String showEditUserPage(Model model,
                                   @PathVariable String username){
        User user = userService.getByUsernameFromUser(username);
        UserRegistrationDTO userDTO = new UserRegistrationDTO();
        userDTO.setUsername(user.getUsername());

        model.addAttribute("userDto", new UserRegistrationDTO());
        return "edit-user";
    }

    @PostMapping("/edit-user/{username}")
    public String editUser(@PathVariable("username") String username,
                           @ModelAttribute ("userDto") UserRegistrationDTO userDto) {
        User updatedUser = userService.getByUsernameFromUser(username);
        UserDetails userDetails = userService.getByUsername(username);
        userDetails.setFirstName(userDto.getFirstName());
        userDetails.setLastName(userDto.getLastName());
        userDetails.setEmail(userDto.getEmail());
        updatedUser.setUserDetails(userDetails);


        // TODO: 9/28/2020 Fix edit user functionality
//        userDetails.setUsername();
//        updatedUser.setEmail(userDto.getEmail());
//        updatedUser.setFirstName(userDto.getFirstName());
//        updatedUser.setLastName(userDto.getLastName());
//        updatedUser.setUsername(userDto.getUsername());

        try {
            userService.update(userDetails);
            return "redirect:/";
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}

