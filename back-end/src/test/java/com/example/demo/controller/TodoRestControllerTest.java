package com.example.demo.controller;

import com.example.demo.entities.Todo;
import com.example.demo.services.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TodoRestControllerTest {
    @MockBean
    private TodoService todoService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /todo/{id} ")
    void testGetTodoById() throws Exception {
        Todo mockTodo = new Todo(1L, "Learing TDD", false);
        doReturn(mockTodo).when(todoService).getTodo(1L);
        mockMvc.perform(get("/todo/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.task").value("Learing TDD"))
                .andExpect(jsonPath("$.completed").value(false));

    }

    @Test
    @DisplayName("GET /todo/{id} ")
    void testGetTodoByIdNotFound() throws Exception {
        doReturn(null).when(todoService).getTodo(1L);
        mockMvc.perform(get("/todo/1"))
                .andExpect(status().isOk());
    }
}