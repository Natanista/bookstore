package com.example.bookstore.service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;


    public void initializeDataBase(){
        bookRepository.deleteAll();
        categoryRepository.deleteAll();
        Category category1 = new Category(null, "IT", "information technology books");
;
        Book book1 = new Book(null, "Clean Code", "Robert Martin", "Lorem", category1);
        Book book2 = new Book(null, "Clean Architecture", "Robert Martin", "Lorem", category1);
        Book book3 = new Book(null, "Pragmatic Programmer", "Uncle Bob", "Lorem", category1);
        category1.getBooks().addAll(Arrays.asList(book1, book2, book3));

        categoryRepository.saveAll(Arrays.asList(category1));
        bookRepository.saveAll(Arrays.asList(book1, book2, book3));
    }
}
