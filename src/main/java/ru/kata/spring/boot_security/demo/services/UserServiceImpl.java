package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private RoleDao roleDao;

    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        user.setRoles(user.getRoles());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.updateUser(user);

    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }


}
