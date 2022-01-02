package com.example.demo;

import com.example.demo.Core.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Admin admin = new Admin();
		SpringApplication.run(DemoApplication.class, args);
	}

}
