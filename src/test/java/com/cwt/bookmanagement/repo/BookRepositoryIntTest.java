package com.cwt.bookmanagement.repo;

import com.cwt.bookmanagement.BookmanagementApplication;
import com.cwt.bookmanagement.entities.Author;
import com.cwt.bookmanagement.entities.Book;
import com.cwt.bookmanagement.entities.Category;
import com.cwt.bookmanagement.repositories.AuthorRepository;
import com.cwt.bookmanagement.repositories.BookRepository;
import com.cwt.bookmanagement.repositories.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = BookmanagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts="classpath:drop.sql")})
public class BookRepositoryIntTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void ifNewBookSaved_thenSuccess() {
        Category category = new Category("Javascript");
        categoryRepository.save(category);

        Author author1 = new Author("Eric Freeman");
        Author author2 = new Author("Elisabeth Robson");
        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book  = new Book();
        book.setTitle("Head First Javascript Programming");
        book.setAuthors(Arrays.asList(author1, author2));
        book.setCategory(category);
        book.setDescription("A Brain-Friendly Guide to Javascript");
        book.setPrice(49.99);
        bookRepository.save(book);

        assertEquals(1, bookRepository.count());
    }
}
