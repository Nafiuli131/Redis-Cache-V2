package com.example.ControllerAdvice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ControllerAdviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerAdviceApplication.class, args);
	}

}
