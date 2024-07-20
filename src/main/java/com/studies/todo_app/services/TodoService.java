package com.studies.todo_app.services;

import com.studies.todo_app.models.todo.TodoEntity;
import com.studies.todo_app.models.translate.TranslateResponseEntity;

import java.util.List;

public interface TodoService {
    void createTodo(TodoEntity todo);

    List<TodoEntity> getTodos();

    TodoEntity updateTodo(TodoEntity todo);

    void deleteTodo(TodoEntity todo);

    TranslateResponseEntity translate(TodoEntity todo);
}
