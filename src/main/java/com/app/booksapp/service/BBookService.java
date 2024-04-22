package com.app.booksapp.service;

import com.app.booksapp.model.*;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
interface BBookRepository extends JpaRepository<BBook,Long>{

}

@Service
public class BBookService extends BService<BBookRepository,BBook>{
	@Autowired
    private BBookRepository r;

    protected BBookRepository getRepository(){
    	return r;
    }

}
