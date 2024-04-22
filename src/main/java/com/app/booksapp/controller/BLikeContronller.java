package com.app.booksapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booksapp.model.BLike;
import com.app.booksapp.service.BLikeService;

@RestController
@RequestMapping("like")
public class BLikeContronller extends MyGenericRestController<BLikeService, BLike, Long>{
    
}