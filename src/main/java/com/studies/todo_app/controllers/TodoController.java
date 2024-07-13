package com.studies.todo_app.controllers;

import com.studies.todo_app.model.TodoEntity;
import com.studies.todo_app.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public HttpStatus createTodo(@RequestBody TodoEntity todo) {
        this.todoService.createTodo(todo);
        return HttpStatus.OK;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoEntity>> getAllTodos() {
        return ResponseEntity.ok(this.todoService.getAllTodos());
    }

    @PutMapping("/todo/{id}")
    public HttpStatus updateTodo(@PathVariable Long id, @RequestBody TodoEntity todo) {
        this.todoService.updateTodo(id, todo);
        return HttpStatus.OK;
    }

    @DeleteMapping("todo/{id}")
    public HttpStatus deleteTodo(@PathVariable Long id){
        this.todoService.deleteTodo(id);
        return HttpStatus.OK;
    }
}
