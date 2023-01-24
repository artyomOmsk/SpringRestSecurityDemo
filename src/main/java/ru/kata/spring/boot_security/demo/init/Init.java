package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Set;

@Component
public class Init {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    void postConstruct() {
        if (roleService.getRoleById(1L) == null & roleService.getRoleById(2L) == null) {
            roleService.updateRole(new Role(1L, "ROLE_ADMIN"));
            roleService.updateRole(new Role(2L,"ROLE_USER"));
        }
        if (userService.getUserById(1L) == null & userService.getUserById(2L) == null) {
            userService.updateUser(new User("admin", "admin", Set.of(roleService.getRoleById(1L))));
            userService.updateUser(new User("user", "user", Set.of(roleService.getRoleById(2L))));
        }
    }
}


