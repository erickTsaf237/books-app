package com.app.booksapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booksapp.model.BUser;
import com.app.booksapp.service.BUserService;

@RestController
@RequestMapping("/user")
public class BUserContronller extends MyGenericRestController<BUserService,  BUser, Long>  {   
}