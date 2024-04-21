package com.app.booksapp.service;

import com.app.booksapp.model.*;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
interface BLikeRepository extends JpaRepository<BLike,Long>{

}

@Service
public class BLikeService extends BService<BLikeRepository,BLike>{
	@Autowired
    private BLikeRepository r;

    protected BLikeRepository getRepository(){
    	return r;
    }
}
