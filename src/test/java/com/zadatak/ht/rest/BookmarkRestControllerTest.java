package com.zadatak.ht.rest;

import com.zadatak.ht.entities.Bookmark;
import com.zadatak.ht.repositories.BookmarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class BookmarkRestControllerTest {

    @Mock
    BookmarkRepository bookmarkRepository;

    @Mock
    Model model;

    List<Bookmark> bookmarks;

    MockMvc mockMvc;

    BookmarkRestController bookmarkRestController;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        bookmarkRestController = new BookmarkRestController(bookmarkRepository);
    }

    @Test
    void testMockMVC() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookmarkRestController).build();

        mockMvc.perform(get("/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookmarks"));
    }

    @Test
    void getAllBookmarks() throws Exception {

        when(bookmarkRepository.findAll()).thenReturn(bookmarks);

        mockMvc.perform(get("/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookmarks"));
    }

    @Test
    void getTBookmarkById() throws Exception {
        when(bookmarkRepository.findAll()).thenReturn(bookmarks);

        mockMvc.perform(get("/bookmarks/id"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookmarks/id"));

    }

    @Test
    void createBookmark() throws Exception {
        when(bookmarkRepository.findAll()).thenReturn(bookmarks);

        mockMvc.perform(get("/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookmarks"));
    }

    @Test
    void updateBookmark() throws Exception {
        when(bookmarkRepository.findAll()).thenReturn(bookmarks);

        mockMvc.perform(get("/bookmarks/id"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookmarks/id"));
    }

    @Test
    void deleteBookmark() throws Exception {
        when(bookmarkRepository.findAll()).thenReturn(bookmarks);

        mockMvc.perform(get("/bookmarks/id"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookmarks/id"));
    }

    @Test
    void deleteAllBookmarks() throws Exception {
        when(bookmarkRepository.findAll()).thenReturn(bookmarks);

        mockMvc.perform(get("/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookmarks"));
    }
}