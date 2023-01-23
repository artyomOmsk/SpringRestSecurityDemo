package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> getAllRoles();

    Role getRoleById(Long id);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

    Role getRoleByName(String name);

}
