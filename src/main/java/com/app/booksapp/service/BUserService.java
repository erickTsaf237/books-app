package com.app.booksapp.service;

import com.app.booksapp.model.*;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
interface BUserRepository extends JpaRepository<BUser,Long>{

}

@Service
public class BUserService extends BService<BUserRepository,BUser>{
	@Autowired
    private BUserRepository r;

    protected BUserRepository getRepository(){
    	return r;
    }
}
