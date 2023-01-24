package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(Long id);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

    Role getRoleByName(String name);

}
