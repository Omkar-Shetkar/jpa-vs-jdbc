package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
public class SpringDataJdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcDemoApplication.class, args);
	}

}
