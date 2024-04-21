package com.app.booksapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.app.booksapp.service.*;
import com.app.booksapp.model.*;

@SpringBootApplication
public class BooksAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BooksAppApplication.class, args);

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
	}

}
