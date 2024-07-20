package com.studies.todo_app.models.exceptions;


public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String msg) {
        super(msg);
    }
}
