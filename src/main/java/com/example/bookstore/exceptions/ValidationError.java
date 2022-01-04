package com.example.bookstore.exceptions;

import java.util.List;
import java.util.ArrayList;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getFieldErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
