package com.cwt.bookmanagement.repositories;

import com.cwt.bookmanagement.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByTitle(String title);
}

