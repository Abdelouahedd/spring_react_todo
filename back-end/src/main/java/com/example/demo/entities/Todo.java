package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;

@Entity()
@Data()
@NoArgsConstructor()
@AllArgsConstructor()
@ToString()
public class Todo {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean isCompleted;

    public Todo(String task, boolean isCompleted) {
        this.task = task;
        this.isCompleted = isCompleted;
    }
}
