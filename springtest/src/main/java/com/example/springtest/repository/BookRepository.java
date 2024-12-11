package com.example.springtest.repository;

import com.example.springtest.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
