package com.example.bookstore.resources;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dtos.BookDTO;
import com.example.bookstore.service.BookService;
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
@RequestMapping("/bookstore/books")
@CrossOrigin
public class BookResource {

    @Autowired
    private BookService bookService;


    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(
            @RequestParam(value = "category", defaultValue = "0") Integer id_category
    ) {
        List<Book> list = bookService.findAll(id_category);
        List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(
            @PathVariable Integer id,
            @Valid @RequestBody Book obj
    ) {
        Book newObj = bookService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }


    @PostMapping
    public ResponseEntity<Book> create(
            @RequestParam(value = "category", defaultValue = "0") Integer id_category,
            @Valid @RequestBody Book obj
    ) {
        Book newObj = bookService.create(id_category, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/bookstore/books/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id
    ) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
