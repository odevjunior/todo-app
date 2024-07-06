package com.studies.todo_app.services;

import com.studies.todo_app.models.TodoEntity;
import com.studies.todo_app.models.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void createTodo(TodoEntity todo) {
        try {
            this.todoRepository.save(todo);
        } catch(Exception e) {
            System.out.println(String.format("ERROR on CREATE_TODO: {0}", e.getMessage()));
        }
    }

    @Override
    public List<TodoEntity> getTodos() {
        try {
            return this.todoRepository.findAll();
        } catch(Exception e) {
            System.out.println(String.format("ERROR on GET_TODOS: {0}", e.getMessage()));
            return Collections.emptyList();
        }
    }
}
