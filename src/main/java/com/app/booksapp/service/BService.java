package com.app.booksapp.service;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.booksapp.model.*;



public abstract class BService<R extends JpaRepository<E,Long>,E extends BEntity> extends MyGenericService<R,E,Long>{

}


