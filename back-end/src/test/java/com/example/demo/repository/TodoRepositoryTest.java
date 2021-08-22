package com.example.demo.repository;

import com.example.demo.entities.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
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
        Todo todo = new Todo("Learing TDD", true);
        Todo savedTodo = repository.save(todo);

        assertThat(savedTodo.getId()).isGreaterThan(0L);
        assertThat(savedTodo).hasFieldOrPropertyWithValue("task", "Learing TDD");
        assertThat(savedTodo).hasFieldOrPropertyWithValue("completed", true);
    }

    @Test
    public void should_find_all_todos() {
        Todo tut1 = entityManager.persist(new Todo("Desc#1", false));
        Todo tut2 = entityManager.persist(new Todo("Desc#2", true));
        Todo tut3 = entityManager.persist(new Todo("Desc#3", false));
        Iterable<Todo> todos = repository.findAll();

        assertThat(todos).hasSize(3).contains(tut1, tut2, tut3);
    }

    @Test
    public void should_find_todo_by_id() {
        Todo tut1 = new Todo("Desc#1", true);
        entityManager.persist(tut1);
        Todo tut2 = new Todo("Desc#2", false);
        entityManager.persist(tut2);
        Todo foundTodo = repository.findById(tut2.getId()).get();

        assertThat(foundTodo).isEqualTo(tut2);
    }

    @Test
    public void should_update_todo_by_id() {
        Todo tut1 = new Todo("Desc#1", true);
        entityManager.persist(tut1);

        Todo tut2 = new Todo("Desc#2", false);
        entityManager.persist(tut2);

        Todo updatedTut = new Todo("updated Desc#2", true);

        Todo tut = repository.findById(tut2.getId()).get();

        tut.setTask(updatedTut.getTask());
        tut.setCompleted(updatedTut.isCompleted());
        repository.save(tut);

        Todo checkTut = repository.findById(tut2.getId()).get();

        assertThat(checkTut.getId()).isEqualTo(tut.getId());
        assertThat(checkTut.getTask()).isEqualTo(tut.getTask());
        assertThat(checkTut.isCompleted()).isEqualTo(tut.isCompleted());
    }

    @Test
    public void should_delete_todo_by_id() {
        Todo tut1 = entityManager.persist(new Todo("Desc#1", true));
        Todo tut2 = entityManager.persist(new Todo("Desc#2", false));
        Todo tut3 = entityManager.persist(new Todo("Desc#3", true));
        repository.deleteById(tut2.getId());
        Iterable<Todo> tutorials = repository.findAll();

        assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }

    @Test
    public void should_delete_all_todos() {
        entityManager.persist(new Todo("Desc#1", true));
        entityManager.persist(new Todo("Desc#2", false));
        repository.deleteAll();

        assertThat(repository.findAll()).isEmpty();
    }

}