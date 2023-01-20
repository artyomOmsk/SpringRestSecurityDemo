package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getViewForAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "viewForAdmins";
    }

    @GetMapping("/{id}")
    public String getUserView(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "userView";
    }

    @GetMapping("/new")
    public String getNewUserFormView(Model model) {
        model.addAttribute("user", new User());
        return "newUserFormView";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String getUpdateUserFormView(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUserFormView";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/";

    }


}