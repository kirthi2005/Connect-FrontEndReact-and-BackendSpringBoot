package com.example.controller;

import com.example.model.ApiResponse;
import com.example.model.Todo;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/api")
    public ApiResponse homeController(){
        ApiResponse response = new ApiResponse();
        response.setMessage("Welcome to todo Api");
        response.setStatus(true);
        return response;
    }

    @GetMapping("/api/todos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
    @PostMapping("/api/todos")
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createToDo(todo);
    }

    @DeleteMapping("/api/todos/{id}")
    public ApiResponse deleteTodo(@PathVariable Long id) throws Exception{
        todoService.deleteById(id);
        ApiResponse res = new ApiResponse();
        res.setMessage("todo deleted successfully");
        res.setStatus(true);
        return res;
    }

}
