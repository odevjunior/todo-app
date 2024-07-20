package com.studies.todo_app.services;

import com.studies.todo_app.models.todo.TodoEntity;
import com.studies.todo_app.models.exceptions.TodoNotFoundException;
import com.studies.todo_app.models.todo.repository.TodoRepository;
import com.studies.todo_app.models.translate.TranslateRequestEntity;
import com.studies.todo_app.models.translate.TranslateResponseEntity;
import com.studies.todo_app.models.translate.client.TranslateApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    private final TranslateApiClient client;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository, TranslateApiClient client) {
        this.todoRepository = todoRepository;
        this.client = client;
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

    @Override
    public TodoEntity updateTodo(TodoEntity todo) {
        TodoEntity savedTodo = this.todoRepository.findById(todo.getId())
                .orElseThrow(() -> new TodoNotFoundException("todo not found"));
        todo.setId(savedTodo.getId());
        return this.todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(TodoEntity todo) {
        try {
            this.todoRepository.deleteById(todo.getId());
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public TranslateResponseEntity translate(TodoEntity todo) {
        try {
            TranslateRequestEntity translateEntity = new TranslateRequestEntity();
            translateEntity.setFrom("pt");
            translateEntity.setTo("en");
            translateEntity.setHtml("Titulo: " + todo.getTitle() + " - Descrição: " + todo.getDescription());
            Map<String, String> headers = Map.of(
                    "x-rapidapi-host", "google-translate113.p.rapidapi.com",
                    "x-rapidapi-key", "",
                    "Content-Type","application/json"
            );
            return this.client.translate(translateEntity, headers);
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
            throw e;
        }
    }

}
