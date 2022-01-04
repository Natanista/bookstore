package com.example.bookstore.resources;

import com.example.bookstore.domain.Category;
import com.example.bookstore.dtos.CategoryDTO;
import com.example.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookstore/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(
            @PathVariable int id

    ) {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> list = categoryService.findAll();
        List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Category> create(
            @Valid @RequestBody Category obj
    ) {
        obj = categoryService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody CategoryDTO objDTO
    ) {
        Category newObj = categoryService.update(id, objDTO);
        return ResponseEntity.ok(new CategoryDTO(newObj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id
    ) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
