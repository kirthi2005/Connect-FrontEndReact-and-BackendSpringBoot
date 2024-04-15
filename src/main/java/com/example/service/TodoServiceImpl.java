package com.example.service;

import com.example.model.Todo;
import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }


    @Override
    public Todo createToDo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new Exception("Todo does not exist"));
        todoRepository.delete(todo);
    }
}
