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
        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        Role roleUser = new Role(2L, "ROLE_USER");
        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);

        User adminUser = new User("admin", "admin", new HashSet<>(Set.of(roleAdmin)));
        User userUser = new User("user", "user", new HashSet<>(Set.of(roleUser)));

        userService.saveUser(adminUser);
        userService.saveUser(userUser);


    }
}
