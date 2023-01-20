package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUerById(int id);

    User getUserByUsername(String username);


}