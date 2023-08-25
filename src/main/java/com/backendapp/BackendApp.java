package com.backendapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.backendapp"})
public class BackendApp {

	public static void main(String[] args) {
		SpringApplication.run(BackendApp.class, args);
	}
}
