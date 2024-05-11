package com.app.booksapp.repository;


import com.app.booksapp.model.*;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BBookRepository extends JpaRepository<BBook,Long>{
    
}
