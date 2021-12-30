package com.example.bookstore.service;

import com.example.bookstore.domain.Category;
import com.example.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class      CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Category findById(int id){
        return categoryRepository.findById(id).orElse(null);
    }
}
