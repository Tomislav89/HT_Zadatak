package com.zadatak.ht.repositories;

import com.zadatak.ht.entities.Bookmark;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByAccountUsername(String userName);
}
