package com.studies.todo_app.services;

import com.studies.todo_app.model.TodoEntity;
import com.studies.todo_app.model.reporsitory.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImp implements TodoService {

    private TodoRepository todoRepository;

    // Melhor colocar aqui em vez da variavel
    @Autowired
    public TodoServiceImp(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public void createTodo(TodoEntity todo) {
        try{
            this.todoRepository.save(todo);
        } catch (Exception e){
            System.out.println(String.format("ERROR on CREATE_TODO {0}%n", e.getMessage()));
        }
    }

    @Override
    public List<TodoEntity> getAllTodos() {
        try {
            return this.todoRepository.findAll();
        } catch (Exception n){
            System.out.println(String.format("ERROR on GET_ALL_TODOS {0}%n", n.getMessage()));
            return Collections.emptyList();
        }
    }

    @Override
    public void updateTodo(Long id, TodoEntity todo) {
        try {
            Optional<TodoEntity> newTodo = this.todoRepository.findById(id);
            if (newTodo.isPresent()) {
                todo.setId(id);
                this.todoRepository.save(todo);
            } else {
                throw new Exception(String.format("Not Found ID on UPDATE_TODO {0}%n", id));
            }
        } catch (Exception n) {
            System.out.println(String.format("ERROR on UPDATE_TODO {0}%n", n.getMessage()));
        }
    }

    @Override
    public void deleteTodo(Long id) {
        try {
            this.todoRepository.deleteById(id);
        } catch (Exception n){
            System.out.println(String.format("ERROR on DELETE_TODO {0}%n", n.getMessage()));
        }
    }
}
