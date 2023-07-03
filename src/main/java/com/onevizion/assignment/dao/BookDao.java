package com.onevizion.assignment.dao;

import com.onevizion.assignment.model.Book;
import com.onevizion.assignment.model.NewBook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookDao {

    private static final String SELECT_BOOK = "select id, title, description, author from book";
    private static final String insert_BOOK = "insert into book(title, description, author) values(?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public List<Book> getBooks() {
        return jdbcTemplate.query(SELECT_BOOK, this::rsExtractor);
    }

    public void createBook(NewBook newBook) {
        jdbcTemplate.execute(insert_BOOK, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1, newBook.getTitle());
            ps.setString(2, newBook.getDescription());
            ps.setString(3, newBook.getAuthor());
            return ps.execute();
        });
    }

    public Map<String, List<Book>> getBooksGroupedByAuthor() {
        return getBooks().stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    private Book rsExtractor(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("description")
        );
    }

}
