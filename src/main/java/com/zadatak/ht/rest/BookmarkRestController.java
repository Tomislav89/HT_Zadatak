package com.zadatak.ht.rest;

import com.zadatak.ht.entities.Bookmark;
import com.zadatak.ht.repositories.BookmarkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/bookmarks")
public class BookmarkRestController {

    private BookmarkRepository bookmarkRepository;

    public BookmarkRestController(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @GetMapping("/bookmarks")
    public ResponseEntity<List<Bookmark>> getAllBookmarks(@RequestParam(required = false) String description) {
        try {
            List<Bookmark> bookmarks = new ArrayList<Bookmark>();

            if (description == null)
                bookmarkRepository.findAll().forEach(bookmarks::add);

            if (bookmarks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(bookmarks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bookmarks/{id}")
    public ResponseEntity<Bookmark> getTBookmarkById(@PathVariable("id") long id) {
        Optional<Bookmark> bookmarkData = bookmarkRepository.findById(id);

        if (bookmarkData.isPresent()) {
            return new ResponseEntity<>(bookmarkData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/bookmarks")
    public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
        try {
            Bookmark newBookmark = bookmarkRepository
                    .save(new Bookmark(bookmark.getAccount(),bookmark.getUri(),bookmark.getDescription()));
            return new ResponseEntity<>(newBookmark, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/bookmarks/{id}")
    public ResponseEntity<Bookmark> updateBookmark(@PathVariable("id") long id, @RequestBody Bookmark bookmark) {
        Optional<Bookmark> bookmarkData = bookmarkRepository.findById(id);

        if (bookmarkData.isPresent()) {
            Bookmark existingBookmark = bookmarkData.get();
            existingBookmark.setAccount(bookmark.getAccount());
            existingBookmark.setDescription(bookmark.getDescription());
            existingBookmark.setUri(bookmark.getUri());
            return new ResponseEntity<>(bookmarkRepository.save(existingBookmark), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/bookmarks/{id}")
    public ResponseEntity<HttpStatus> deleteBookmark(@PathVariable("id") long id) {
        try {
            bookmarkRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bookmarks")
    public ResponseEntity<HttpStatus> deleteAllBookmarks() {
        try {
            bookmarkRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
