package com.zadatak.ht.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "bookmarks")
public class Bookmark {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String uri;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Bookmark(User user, String uri, String description) {
        this.description = description;
        this.uri = uri;
        this.user = user;
    }
}
