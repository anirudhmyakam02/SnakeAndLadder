package com.project.snakeandladder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class SnakeandladderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakeandladderApplication.class, args);
	}

}
