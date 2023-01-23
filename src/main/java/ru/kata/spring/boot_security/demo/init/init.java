package ru.kata.spring.boot_security.demo.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class init {

    UserService userService;
    RoleService roleService;

    @Autowired
    public init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    void postConstruct() {
        if (userService.getUserById(1L) == null & userService.getUserById(2L) == null) {

            userService.saveUser(new User("admin", "admin", Set.of(roleService.getRoleById(1L))));
            userService.saveUser(new User("user", "user", Set.of(roleService.getRoleById(2L))));


        }
    }
}
