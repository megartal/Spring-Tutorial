package com.test.demo.api.v1.controllers;

import com.test.demo.domain.Book;
import com.test.demo.service.interf.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Akbar
 * @since 4/15/2018
 */
@Profile("v1")
@RestController
@Slf4j
@RequestMapping({"/api/v1"})
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/book", params = {"title"})
    public Optional<Book> getBook(String title) {
        log.debug("this just for test.");
        return bookService.findBookByTitle(title);
    }

    @GetMapping(value = {"/books"})
    public Iterable<Book> getBooks(){
        return bookService.findAllBooks();
    }


    @GetMapping(value = "/book/add", params = {"title", "genre"})
    public String add(String title, String genre){
        return bookService.addBook(title, genre);
    }

    @GetMapping(value = "/book/like", params = {"title"})
    public List<Book> getBookUsingCustomQuery(String title) {
        return bookService.findBookInCustomQuery(title);
    }
}
