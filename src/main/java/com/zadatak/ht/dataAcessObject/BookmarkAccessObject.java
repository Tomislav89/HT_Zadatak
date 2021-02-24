package com.zadatak.ht.dataAcessObject;

import com.zadatak.ht.entities.Bookmark;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class BookmarkAccessObject {

    @PersistenceContext
    private EntityManager em;

    public void persistBookmark(Bookmark bookmark) {
        System.out.println("persist bookmark:" + bookmark);
        em.persist(bookmark);
    }

    public List<Bookmark> findAllBookmarks() {
        return em.createQuery("SELECT bookmark FROM Bookmark bookmark")
                .getResultList();
    }
}
