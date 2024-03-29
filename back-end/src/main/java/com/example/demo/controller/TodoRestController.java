package com.example.demo.controller;

import com.example.demo.entities.Todo;
import com.example.demo.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TodoRestController {
    private final TodoService todoService;


    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/listTodos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable("id") Long id) {
        return todoService.getTodo(id).isPresent() ? todoService.getTodo(id).get() : null;
    }

    @PutMapping("/updateTodo/{id}")
    public Todo UpdateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        todo.setId(id);
        return todoService.UpdateTodo(id, todo);
    }

    @PostMapping("/addTodo")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
    }

}