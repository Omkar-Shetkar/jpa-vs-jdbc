package com.example.demo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
public class Student {

    @Id
    @With
    private final Integer id;

    private String name;

    private int score;

    public Student(String name, int score) {
        this.id = null;
        this.name = name;
        this.score = score;
    }


}
