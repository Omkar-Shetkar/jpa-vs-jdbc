package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @PostMapping
    public ResponseEntity<Student> updateStudent(@RequestParam("score") int score) {
        Student updated = update(score);
        LOGGER.info("Updating student... {}", updated);
        return ResponseEntity.ok(updated);
    }

    private Student update(int score) {
        Student student = studentRepository.findById(1).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        student.setScore(score);
        Student updated = studentRepository.save(student);
        return updated;
    }

}