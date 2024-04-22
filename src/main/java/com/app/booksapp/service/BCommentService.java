package com.app.booksapp.service;

import com.app.booksapp.model.*;
import com.app.booksapp.repository.BCommentRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class BCommentService extends BService<BCommentRepository,BComment>{
	@Autowired
    private BCommentRepository r;

    protected BCommentRepository getRepository(){
    	return r;
    }
}
