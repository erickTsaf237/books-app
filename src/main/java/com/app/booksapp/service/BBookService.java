package com.app.booksapp.service;

import com.app.booksapp.model.*;
import com.app.booksapp.repository.BBookRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BBookService extends BService<BBookRepository,BBook>{
	@Autowired
    private BBookRepository r;

    protected BBookRepository getRepository(){
    	return r;
    }

}
