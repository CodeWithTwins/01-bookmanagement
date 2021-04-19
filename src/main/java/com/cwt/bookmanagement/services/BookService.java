package com.cwt.bookmanagement.services;

import com.cwt.bookmanagement.entities.Book;
import com.cwt.bookmanagement.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(long id, Book book) {
        Optional<Book> foundedBook = bookRepository.findById(id);
        if(foundedBook.isPresent()) {
            if(!book.getAuthors().isEmpty()) {
                foundedBook.get().setAuthors(book.getAuthors());
            }
            if(book.getCategory() != null) {
                foundedBook.get().setCategory(book.getCategory());
            }
            if(book.getDescription() != null) {
                foundedBook.get().setDescription(book.getDescription());
            }
            if(book.getPrice() != null) {
                foundedBook.get().setPrice(book.getPrice());
            }
            if(book.getTitle() != null) {
                foundedBook.get().setTitle(book.getTitle());
            }
            bookRepository.save(foundedBook.get());
            return foundedBook.get();
        }
        throw new NoSuchElementException("Book not found!");
    }

    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public void deleteBook(long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            bookRepository.delete(book.get());
        } else {
            throw new NoSuchElementException("Book not found");
        }
    }
}
