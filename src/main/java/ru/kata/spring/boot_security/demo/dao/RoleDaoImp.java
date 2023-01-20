package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Role getRole(String roleName) {
        return entityManager.createQuery("select role from Role role  where role.name = :roleName", Role.class)
                .setParameter("roleName", roleName)
                .getSingleResult();
    }
}
