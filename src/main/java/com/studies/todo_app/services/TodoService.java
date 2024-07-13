package com.studies.todo_app.services;

import com.studies.todo_app.model.TodoEntity;

import java.util.List;

public interface TodoService {

    void createTodo(TodoEntity todo);

    List<TodoEntity> getAllTodos();

    void updateTodo(Long id, TodoEntity todo);

    void deleteTodo(Long id);
}
