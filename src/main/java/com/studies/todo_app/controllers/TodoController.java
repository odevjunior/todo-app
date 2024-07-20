package com.studies.todo_app.controllers;

import com.studies.todo_app.models.todo.TodoEntity;
import com.studies.todo_app.models.translate.TranslateResponseEntity;
import com.studies.todo_app.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<TodoEntity>> getTodos() {
        return ResponseEntity.ok(this.todoService.getTodos());
    }

    @PostMapping("/translate/todo")
    public ResponseEntity<TranslateResponseEntity> translateTodo(@RequestBody TodoEntity todo) {
        return ResponseEntity.ok(this.todoService.translate(todo));
    }
}
