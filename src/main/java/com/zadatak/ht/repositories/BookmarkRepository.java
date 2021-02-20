package com.zadatak.ht.repositories;

import com.zadatak.ht.entities.Bookmark;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByDescription(String description);
}
