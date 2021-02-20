package com.zadatak.ht.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Bookmark {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String uri;

    @ManyToOne
    @JsonIgnore
    private Account account;

    public Bookmark(Account account, String uri, String description) {
        this.description = description;
        this.uri = uri;
        this.account = account;
    }
}
