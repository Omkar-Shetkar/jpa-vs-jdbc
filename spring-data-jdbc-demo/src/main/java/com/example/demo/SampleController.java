package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;


@RestController
@RequestMapping("/api/student")
public class SampleController {

    @Autowired
    private StudentRepository studentRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @GetMapping
    public void getStudent() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Student student = studentRepository.findById(0).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            LOGGER.info("Get student {}",student.toString());
        }
    }

    @PostMapping
    public ResponseEntity<Student> updateStudent(@RequestParam("score") int score) {
        Student updated = update(score);
        LOGGER.info("Updating student... {}", updated);
        return ResponseEntity.ok(updated);
    }

    @Transactional
    private Student update(int score) {
        Student student = studentRepository.findById(0).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        student.setScore(60);
        Student updated = studentRepository.save(student);
        return updated;
    }

    @PutMapping
    public ResponseEntity<Student> createStudent(Student student) {
        Student saved = studentRepository.save(student);
        LOGGER.info("Created student... {}", saved);
        return ResponseEntity.created(URI.create("/api/student/" + saved.getId())).body(saved);
    }

}