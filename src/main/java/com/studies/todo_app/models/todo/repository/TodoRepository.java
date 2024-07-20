package com.studies.todo_app.models.todo.repository;

import com.studies.todo_app.models.todo.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long>{}
