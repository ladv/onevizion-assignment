package com.onevizion.assignment.controller;

import com.onevizion.assignment.dao.BookDao;
import com.onevizion.assignment.model.Book;
import com.onevizion.assignment.model.NewBook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookDao bookDao;

    @GetMapping
    public List<Book> getBooks() {
        log.trace("get /api/books");
        return bookDao.getBooks();
    }

    @GetMapping("/by-author")
    public Map<String, List<Book>> getBooksGroupedByAuthor() {
        log.trace("get /api/books/by-author");
        return bookDao.getBooksGroupedByAuthor();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody @Valid NewBook book) {
        log.trace("post /api/books");
        bookDao.createBook(book);
    }
}
