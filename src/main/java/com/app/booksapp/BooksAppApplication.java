package com.app.booksapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksAppApplication {

	public static void main(String[] args) {
		System.out.println("master");
		SpringApplication.run(BooksAppApplication.class, args);
	}

}
