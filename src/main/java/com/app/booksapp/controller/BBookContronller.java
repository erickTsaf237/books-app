package com.app.booksapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booksapp.model.BBook;
import com.app.booksapp.service.BBookService;

@RestController
@RequestMapping("book")
class BBookContronller extends MyGenericRestController<BBookService, BBook, Long>{
    
}
