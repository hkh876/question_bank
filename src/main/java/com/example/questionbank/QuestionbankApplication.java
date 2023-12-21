package com.example.questionbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class QuestionbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionbankApplication.class, args);
	}

}
