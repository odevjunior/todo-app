package com.studies.todo_app.services;

import com.studies.todo_app.models.TodoEntity;
import com.studies.todo_app.models.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {

    private TodoEntity todo = new TodoEntity();

    @Mock
    private TodoRepository repository;

    @InjectMocks
    private TodoServiceImpl target;

    @BeforeEach
    public void setup() {
        this.todo.setId(1L);
        this.todo.setDescription("Sample description");
        this.todo.setTitle("Sample todo");
    }

    @Test
    public void givenATodoEntityWhenCallsTheTodoServiceThenCallRepositoryToSaveTodo() {
        when(this.repository.save(any())).thenReturn(todo);

        target.createTodo(todo);

        verify(this.repository, times(1)).save(any());
    }

    @Test
    public void whenCallsThegetTodosThenReturnATodoList() {
        List<TodoEntity> expected = Collections.singletonList(todo);
        when(this.repository.findAll()).thenReturn(expected);

        List<TodoEntity> actual = target.getTodos();
        assertEquals(expected, actual);
    }
}