package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {


    private UserService userService;

    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getViewForAdmins(Model model, Principal principal) {
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("admin", userService.getUserByUsername(principal.getName()));
        model.addAttribute("roleAdmin", roleService.getRoleById(1L));
        model.addAttribute("roleUser", roleService.getRoleById(2L));
        model.addAttribute("user", new User());
        return "viewForAdmins";
    }


    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";

    }

}
