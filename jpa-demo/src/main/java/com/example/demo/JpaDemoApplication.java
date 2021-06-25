package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
public class JpaDemoApplication {

	@Autowired
	private StudentRepository studentRepository;

	private final static Logger LOGGER = LoggerFactory.getLogger(JpaDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@EventListener
	public void handleApplicationReady(ApplicationReadyEvent event) {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Student student = studentRepository.findById(1)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
			LOGGER.info("Get student {}",student.toString());
		}

	}

}
