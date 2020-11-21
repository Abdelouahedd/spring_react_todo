package com.example.controller;

import com.example.entities.Todo;
import com.example.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TodoRestController {
    private final TodoRepository todoRepository;

    public TodoRestController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/listTodos")
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable("id") Long id) {
        return todoRepository.findById(id).get();
    }

    @PutMapping("/updateTodo/{id}")
    public Todo UpdateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        todo.setId(id);
        return todoRepository.save(todo);
    }

    @PostMapping("/addTodo")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoRepository.deleteById(id);
    }

}