package com.example.springtest.Controller;


import com.example.springtest.Entity.Book;
import com.example.springtest.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBookRecords() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "{bookId}")
    public Book getBookById(@PathVariable(value = "bookId") Long bookId) {

        Book books = bookRepository.findById(bookId).get();
        return books;
    }



    @PostMapping
    public Book createBookRecord(@RequestBody @Validated Book bookRecord) {
        return bookRepository.save(bookRecord);
    }
//|| bookRecord.getBookId() == null
    @PutMapping
    public Book updateBookRecord(@RequestBody Book bookRecord) throws Exception {
        if (bookRecord == null ) {
            throw new RuntimeException("bookrecord or bookid is not found id");
        }

        Optional<Book> optionalBook = bookRepository.findById(bookRecord.getBookId());

        if (!optionalBook.isPresent()) {
            throw new Exception("BOOK ID IS NOT FOUND");
        }

        Book existedBook = optionalBook.get();
        existedBook.setName(bookRecord.getName());
        existedBook.setSummary(bookRecord.getSummary());
        existedBook.setRating(bookRecord.getRating());

        return bookRepository.save(existedBook);
    }






}
