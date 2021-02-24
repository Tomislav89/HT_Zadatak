package com.zadatak.ht.services;

import com.zadatak.ht.dataAcessObject.BookmarkAccessObject;
import com.zadatak.ht.entities.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.List;

public class BookmarkService {

    @Autowired
    private BookmarkAccessObject bookmarkAccessObject;

    public void add(Bookmark bookmark) {
        bookmarkAccessObject.persistBookmark(bookmark);
    }

    public void addAll(Collection<Bookmark> bookmarks) {
        for (Bookmark bookmark : bookmarks) {
            bookmarkAccessObject.persistBookmark(bookmark);
        }
    }

    public List<Bookmark> listAll() {
        return bookmarkAccessObject.findAllBookmarks();
    }
}
