package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.RoleServiceImp;
import ru.kata.spring.boot_security.demo.services.UserService;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private UserService userService;

    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getViewForAdmins(Model model) {
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
        model.addAttribute("adminRole", roleService.getRole("ADMIN"));
        model.addAttribute("userRole", roleService.getRole("USER"));
        return "newUserFormView";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String getUpdateUserFormView(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUserFormView";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/";

    }


}