package com.zadatak.ht.services;

import com.zadatak.ht.dataAcessObject.UserAccesObject;
import com.zadatak.ht.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class UserService {

    @Autowired
    private UserAccesObject userAccesObject;

    public void add(User user) {
        userAccesObject.persist(user);
    }

    public void addAll(Collection<User> users) {
        for (User user : users) {
            userAccesObject.persist(user);
        }
    }

    public List<User> listAll() {
        return userAccesObject.findAllUsers();
    }
}
