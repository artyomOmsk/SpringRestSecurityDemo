package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT roles FROM Role roles", Role.class).getResultList();
    }

    @Override

    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(Long id) {
        entityManager.remove(entityManager.find(Role.class, id));

    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.find(Role.class, name);
    }


}
