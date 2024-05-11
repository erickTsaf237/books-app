package com.app.booksapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.app.booksapp.model.BUser;
import com.app.booksapp.service.BUserService;



//import com.app.booksapp.service.*;
//import com.app.booksapp.model.*;
//@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class BooksAppApplication implements CommandLineRunner {

	@Autowired
	public BUserService userService;

	public static void main(String[] args) {
	
		/*/ApplicationContext ctx = SpringApplication.run(BooksAppApplication.class, args);

		System.out.println("\n\n\n======================================\n");

		BBookService bbook = ctx.getBean(BBookService.class);
		BUserService buser = ctx.getBean(BUserService.class);
		BLikeService blike = ctx.getBean(BLikeService.class);
		BCommentService bcomment = ctx.getBean(BCommentService.class);
		
		System.out.println(bbook.getAll());

		BBook book = new BBook();
		book.setTitre("Les Chroniques");
		System.out.println(bbook.create(book));
		book.setTitre("Les Chroniques II");
		System.out.println(bbook.create(book));
		System.out.println(bbook.getAll());

		BUser user = new BUser();
		user.setNom("Marc");
		System.out.println(buser.create(user));

		System.out.println(blike.create(new BLike(buser.getAll().get(0),bbook.getAll().get(0))));


		System.out.println(blike.getAll());

		System.out.println("Spring Boot");*/
		
		SpringApplication.run(BooksAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.userService.create(new BUser("dbuser", "$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.", "user", "user","654123254", "User"));
		//this.userService.create(new BUser("dbadmin", "$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC", "admin", "amdin","658475212", "ADMIN"));
	}

}
