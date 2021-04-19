package com.cwt.bookmanagement.services;

import com.cwt.bookmanagement.entities.Author;
import com.cwt.bookmanagement.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String name) {
        return authorRepository.findByName(name).orElse(authorRepository.save(new Author(name)));
    }

    public Author updateAuthor(long id, String name) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()) {
            author.get().setName(name);
            authorRepository.save(author.get());
            return author.get();
        }
        throw new NoSuchElementException("Author not found");
    }

    public Optional<Author> findAuthor(String name) {
        return authorRepository.findByName(name);
    }

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()) {
            authorRepository.delete(author.get());
        } else {
            throw new NoSuchElementException("Author not found");
        }
    }
}
