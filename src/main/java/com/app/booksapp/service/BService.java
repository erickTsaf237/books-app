package com.app.booksapp.service;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.booksapp.model.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



public abstract class BService<R extends JpaRepository<E,Long>,E extends BEntity> extends MyGenericService<R,E,Long>{

}


