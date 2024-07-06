package com.studies.todo_app.services;

import com.studies.todo_app.models.TodoEntity;

import java.util.List;

public interface TodoService {
    void createTodo(TodoEntity todo);

    List<TodoEntity> getTodos();
}
