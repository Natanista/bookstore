package com.example.bookstore.service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.exceptions.ObjectNotFoundException;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, ID: " + id + ", type: " + Book.class.getName()));
    }

    public List<Book> findAll(Integer id_category) {
        categoryService.findById(id_category);
        return bookRepository.findAllByCategory_Id(id_category);

    }

    public Book update(Integer id, Book obj) {
        Book newObj = findById(id);
        updateData(newObj, obj);
        return bookRepository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setAuthor(obj.getAuthor());
        newObj.setContent(obj.getContent());

    }

    public Book create(Integer id_category, Book obj) {
        obj.setId(null);
        Category category = categoryService.findById(id_category);
        obj.setCategory(category);
        return bookRepository.save(obj);
    }

    public void delete(Integer id) {
        Book obj = findById(id);
        bookRepository.deleteById(id);
    }
}
