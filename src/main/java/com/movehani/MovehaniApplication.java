package com.movehani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MovehaniApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovehaniApplication.class, args);
	}

}
