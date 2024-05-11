package com.app.booksapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booksapp.model.BComment;
import com.app.booksapp.service.BCommentService;

@RestController
@RequestMapping("/comment")
public class BCommentContronller extends MyGenericRestController<BCommentService, BComment, Long> {
    
}
