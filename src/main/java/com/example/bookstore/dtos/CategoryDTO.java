package com.example.bookstore.dtos;

import com.example.bookstore.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;
    @NotEmpty(message = "Name required.")
    @Length(min = 2, max = 100, message = "Name must have 3 - 100 characters")
    private String name;

    @NotEmpty
    @Length(min = 2, max = 100, message = "Description must have 2 - 100 characters")
    private String description;

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
