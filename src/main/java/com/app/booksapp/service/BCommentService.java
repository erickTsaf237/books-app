package com.app.booksapp.service;

import com.app.booksapp.model.*;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
interface BCommentRepository extends JpaRepository<BComment,Long>{

}

@Service
public class BCommentService extends BService<BCommentRepository,BComment>{
	@Autowired
    private BCommentRepository r;

    protected BCommentRepository getRepository(){
    	return r;
    }
}
