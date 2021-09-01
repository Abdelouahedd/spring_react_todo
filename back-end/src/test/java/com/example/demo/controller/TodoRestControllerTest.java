package com.example.demo.controller;

import com.example.demo.entities.Todo;
import com.example.demo.services.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TodoRestControllerTest {
    @MockBean
    private TodoService todoService;
    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("GET /todo/{id} ")
    void testGetTodoById() throws Exception {
        Todo mockTodo = new Todo(1L, "Learing TDD", false);
        doReturn(Optional.of(mockTodo)).when(todoService).getTodo(1L);
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
        doReturn(Optional.empty()).when(todoService).getTodo(1L);
        mockMvc.perform(get("/todo/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Post /addTodo ")
    void testAddTodo() throws Exception {
        Todo todo = new Todo(1L, "Learing TDD", false);
        Todo mockTodo = new Todo(1L, "Learing TDD", false);
        doReturn(mockTodo).when(todoService).addTodo(todo);
        mockMvc.perform(post("/addTodo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(todo)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.task").value("Learing TDD"))
                .andExpect(jsonPath("$.completed").value(false));
    }

    @Test
    @DisplayName("Put /updateTodo/{id} - SUCCESS")
    void testUpdateTodo() throws Exception {
        Todo todo = new Todo(1L, "Learing TDD", false);
        Todo mockTodo = new Todo(1L, "Learing TDD", true);
        doReturn(mockTodo).when(todoService).UpdateTodo(1L, todo);
        mockMvc.perform(put("/updateTodo/" + 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(todo)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.task").value("Learing TDD"))
                .andExpect(jsonPath("$.completed").value(true));

    }

    @Test
    @DisplayName("Put /updateTodo/{id} - FAILURE")
    void testUpdateTodoFailure() throws Exception {
        Todo todo = new Todo(1L, "Learing TDD", false);
        doReturn(null).when(todoService).getTodo(1L);
        mockMvc.perform(put("/updateTodo/" + 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(todo)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete /deleteTodo/{id} - SUCCESS")
    void testDeleteTodo() throws Exception {
        Todo todo = new Todo(1L, "Learing TDD", false);
        doReturn(Optional.of(todo)).when(todoService).getTodo(1L);
        mockMvc.perform(delete("/deleteTodo/" + 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Delete /deleteTodo/{id} - Not Found")
    void testDeleteTodoNotFound() throws Exception {
        doReturn(null).when(todoService).getTodo(1L);
        mockMvc.perform(delete("/deleteTodo/" + 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}