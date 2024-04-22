package com.app.booksapp.service;

import com.app.booksapp.model.*;
import com.app.booksapp.repository.BLikeRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BLikeService extends BService<BLikeRepository,BLike>{
	@Autowired
    private BLikeRepository r;

    protected BLikeRepository getRepository(){
    	return r;
    }
}
