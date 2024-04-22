package com.app.booksapp.service;

import com.app.booksapp.model.*;
import com.app.booksapp.repository.BUserRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;




@Service
public class BUserService extends BService<BUserRepository,BUser>{
	@Autowired
    private BUserRepository r;

    protected BUserRepository getRepository(){
    	return r;
    }
}
