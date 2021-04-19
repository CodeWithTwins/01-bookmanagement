package com.cwt.bookmanagement.services;

import com.cwt.bookmanagement.entities.Category;
import com.cwt.bookmanagement.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category createCategory(String name) {
        return categoryRepository.findByName(name).orElse(categoryRepository.save(new Category(name)));
    }

    public Category updateCategory(long id, String name) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            category.get().setName(name);
            categoryRepository.save(category.get());
            return category.get();
        }
        throw new NoSuchElementException("Category not found");
    }

    public Optional<Category> findCategory(String name) {
        return categoryRepository.findByName(name);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            categoryRepository.delete(category.get());
        } else {
            throw new NoSuchElementException("Category not found");
        }
    }


}
