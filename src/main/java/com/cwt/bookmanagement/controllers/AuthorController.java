package com.cwt.bookmanagement.controllers;

import com.cwt.bookmanagement.entities.Author;
import com.cwt.bookmanagement.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public Iterable<Author> findAuthors() {
        return authorService.findAll();
    }

    @RequestMapping(value = "/authors/{name}", method = RequestMethod.GET)
    public Author findAuthor(@PathVariable("name") String name) {
        return authorService.findAuthor(name).get();
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST) // you can use the PostMapping annotation
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody String name) {
        return authorService.createAuthor(name);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT) // you can use the PostMapping annotation
    public Author updateAuthor(@PathVariable("id") long id, @RequestBody String name) {
        return authorService.updateAuthor(id, name);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE) // you can use the DeleteMapping Annotation
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }



}

