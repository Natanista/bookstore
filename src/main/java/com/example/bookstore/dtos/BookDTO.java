package com.example.bookstore.dtos;

import com.example.bookstore.domain.Book;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Title required.")
    @Length(min = 2, max = 100, message = "Title must have 2 - 100 characters")
    private String title;

    public BookDTO(Book obj) {
        this.id = obj.getId();
        this.title = obj.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
