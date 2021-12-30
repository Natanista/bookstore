package com.example.bookstore.resources;

import com.example.bookstore.domain.Category;
import com.example.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/category")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(
            @PathVariable int id

    ) {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

}
