package com.example.m6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example*")
public class M6Application {

	public static void main(String[] args) {
		SpringApplication.run(M6Application.class, args);
	}

}
