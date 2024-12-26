package com.todohateoas.todohateoas.utils;

import com.todohateoas.todohateoas.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityUtils {
    @PersistenceContext private EntityManager manager;

    public User findUserByEmail(String email){
        TypedQuery<User> query = manager.createNamedQuery("select p from User p where p.email=:email", User.class).setParameter("email", email);
        return query.getSingleResult();
    }
}
