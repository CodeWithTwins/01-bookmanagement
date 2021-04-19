package com.cwt.bookmanagement;

import com.cwt.bookmanagement.entities.Author;
import com.cwt.bookmanagement.entities.Book;
import com.cwt.bookmanagement.entities.Category;
import com.cwt.bookmanagement.repositories.AuthorRepository;
import com.cwt.bookmanagement.repositories.BookRepository;
import com.cwt.bookmanagement.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BookmanagementApplication {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookmanagementApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner() {
		return args -> {
			Category category1 = new Category("Java");
			Category category2 = new Category("Architecture");
			Category category3 = new Category("Networks");
			Category category4 = new Category("Databases");

			Author author1 = new Author("Erich Gamma");
			Author author2 = new Author("Robert Martin");
			Author author3 = new Author("Martin Flower");
			Author author4 = new Author("Eric Evans");


			Book book1 = new Book();
			book1.setTitle("Clean Code");
			book1.setPrice(47.99);
			book1.setDescription("How to code like a professional");
			book1.setCategory(category1);
			book1.addAuthor(author2);

			Book book2 = new Book();
			book2.setTitle("Design Pattern");
			book2.setPrice(69.99);
			book2.setDescription("How to implement design pattern");
			book2.setCategory(category2);
			book2.setAuthors(Arrays.asList(author1, author3));

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);

			authorRepository.save(author1);
			authorRepository.save(author2);
			authorRepository.save(author3);
			authorRepository.save(author4);

			bookRepository.save(book1);
			bookRepository.save(book2);

		};
	}*/

}
