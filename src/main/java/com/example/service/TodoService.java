package com.example.service;

import com.example.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createToDo(Todo todo);
    void deleteById(Long id) throws Exception;

}
