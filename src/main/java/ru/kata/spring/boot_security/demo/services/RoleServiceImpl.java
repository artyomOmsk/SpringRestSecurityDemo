package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.entities.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleDao.updateRole(role);

    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleDao.deleteRole(id);

    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }


}
