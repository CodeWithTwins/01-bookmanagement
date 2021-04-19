package com.cwt.bookmanagement.repositories;

import com.cwt.bookmanagement.entities.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByName(String name);
}
