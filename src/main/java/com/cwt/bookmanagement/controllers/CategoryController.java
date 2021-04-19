package com.cwt.bookmanagement.controllers;

import com.cwt.bookmanagement.entities.Category;
import com.cwt.bookmanagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public Iterable<Category> findCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/{name}")
    public Category findCategory(@PathVariable String name) {
        return categoryService.findCategory(name).get();
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody String name) {
        return categoryService.createCategory(name);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable long id, @RequestBody String name) {
        return categoryService.updateCategory(id, name);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteAuthor(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }
}

