package com.example.demo.services;

import com.example.demo.entities.Todo;
import com.example.demo.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)//the annotation used to init all Mock
class TodoServiceTest {
    @InjectMocks
    //create the mock impl and additionally injects the dependent mocks that
    //are marked with the annotations @Mock into it
    private TodoService service;
    @Mock
    //create the mock impl
    private TodoRepository repository;

    @Test
    @DisplayName("test find todo - Success ")
    void testGetTodoById() throws Exception {
        Todo mockTodo = new Todo(1L, "Learing TDD", false);
        doReturn(Optional.of(mockTodo)).when(repository).findById(1L);

        Optional<Todo> todo = service.getTodo(1L);

        Assertions.assertTrue(todo.isPresent(), "Todo not found");
        Assertions.assertSame(todo.get(), mockTodo, "Todo should be the same");
    }

    @Test
    @DisplayName("test find todo - Not Found ")
    void testGetTodoByIdNotFound() throws Exception {
        doReturn(Optional.empty()).when(repository).findById(1L);

        Optional<Todo> todo = service.getTodo(1L);

        Assertions.assertFalse(todo.isPresent(), "Todo was found, when it shoulden't be");
    }

    @Test
    @DisplayName("test find all todo - Success ")
    void testGetTodos() throws Exception {
        Todo todo = new Todo(1L, "Learing TDD", false);
        Todo mockTodo = new Todo(2L, "Learing Spring", false);
        doReturn(Arrays.asList(todo, mockTodo)).when(repository).findAll();

        List<Todo> todos = service.getAllTodos();

        Assertions.assertEquals(todos.size(), 2, "Should return 2 todos");
    }

    @Test
    @DisplayName("test save todo - Success ")
    void testSaveTodo() throws Exception {

        Todo mockTodo = new Todo(1L, "Learing Spring", false);
        doReturn(mockTodo).when(repository).save(any());
        Todo todo = service.addTodo(mockTodo);

        Assertions.assertNotNull(todo, "Saved todo shouldn't be null");
        Assertions.assertSame(mockTodo, todo);
    }

}