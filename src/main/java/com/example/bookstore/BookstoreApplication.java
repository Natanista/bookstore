package com.example.bookstore;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}




}
