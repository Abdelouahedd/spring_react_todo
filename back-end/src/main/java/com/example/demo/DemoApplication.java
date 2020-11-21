package com.example.demo;

import com.example.controller.TodoRestController;
import com.example.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EntityScan("com.example.entities")
@EnableJpaRepositories("com.example.repository")
@ComponentScan(basePackageClasses = TodoRestController.class)
public class DemoApplication implements CommandLineRunner {

    private final TodoRepository todoRepository;

    public DemoApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.findAll().forEach(System.out::println);
    }
}
