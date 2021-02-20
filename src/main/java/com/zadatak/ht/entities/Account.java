package com.zadatak.ht.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    private String username;
    private String password;

    @OneToMany(mappedBy = "account")
    Set<Bookmark> listOfBookmarks = new HashSet<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
