package com.example.bookstore.service;

import com.example.bookstore.domain.Category;
import com.example.bookstore.exceptions.ObjectNotFoundException;
import com.example.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Category findById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Object not founded! id: " + id + ", type: " + Category.class.getName()
        ));
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

 
}
