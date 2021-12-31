package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	static AppSystem appSystem = new AppSystem();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
