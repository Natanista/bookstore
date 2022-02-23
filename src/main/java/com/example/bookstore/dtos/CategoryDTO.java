package com.example.bookstore.dtos;

import com.example.bookstore.domain.Category;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
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

    public CategoryDTO(){}

}
