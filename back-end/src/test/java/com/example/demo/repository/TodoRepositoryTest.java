package com.example.demo.repository;

import com.example.demo.entities.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Transactional(propagation = Propagation.REQUIRES_NEW)
class TodoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private TodoRepository repository;


    @Test
    public void should_find_no_todos_if_repository_is_empty() {
        Iterable<Todo> todos = repository.findAll();
        assertThat(todos).isEmpty();
    }

    @Test
    public void should_store_a_todo() {
        Todo todo = new Todo(1L, "Learing TDD", true);
        Todo savedTodo = repository.save(todo);

        assertThat(savedTodo).hasFieldOrPropertyWithValue("id", 1L);
        assertThat(savedTodo).hasFieldOrPropertyWithValue("task", "Learing TDD");
        assertThat(savedTodo).hasFieldOrPropertyWithValue("completed", true);
    }

    @Test
    public void should_find_all_todos() {
        Todo tut1 = new Todo(1L,"Desc#1", false);
        entityManager.merge(tut1);

        Optional<Todo> todo = repository.findById(1L);
        Assertions.assertTrue(todo.isPresent(),"The todo 1L should be present");

        Todo tut2 = new Todo(2L, "Desc#2", true);
        entityManager.merge(tut2);

        Todo tut3 = new Todo( 3L,"Desc#3", false);
        entityManager.merge(tut3);

        Iterable<Todo> todos = repository.findAll();

        assertThat(todos).hasSize(3).contains(tut1, tut2, tut3);
    }


}