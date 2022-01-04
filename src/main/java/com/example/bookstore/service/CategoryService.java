package com.example.bookstore.service;

import com.example.bookstore.domain.Category;
import com.example.bookstore.dtos.CategoryDTO;
import com.example.bookstore.exceptions.ObjectNotFoundException;
import com.example.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category obj) {
        obj.setId(null);
        return categoryRepository.save(obj);
    }


    public Category update(Integer id, CategoryDTO objDto) {
        Category obj = findById(id);
        obj.setName(obj.getName());
        obj.setDescription(objDto.getDescription());
        return categoryRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoryRepository.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new com.example.bookstore.exceptions.DataIntegrityViolationException("Category cannot be deleted as it has books assigned");
        }
    }
}
