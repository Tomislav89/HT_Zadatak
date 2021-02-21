package com.zadatak.ht.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    private String username;
    private String password;
    private boolean loggedIn;

    @OneToMany(mappedBy = "account")
    Set<Bookmark> listOfBookmarks = new HashSet<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
