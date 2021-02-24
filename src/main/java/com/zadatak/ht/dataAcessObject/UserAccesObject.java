package com.zadatak.ht.dataAcessObject;

import com.zadatak.ht.entities.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserAccesObject {

    @PersistenceContext
    private EntityManager em;

    public void persist(User user) {
        System.out.println("persist:" + user);
        em.persist(user);
    }

    public List<User> findAllUsers() {
        return em.createQuery("SELECT user FROM User user")
                .getResultList();
    }

}
