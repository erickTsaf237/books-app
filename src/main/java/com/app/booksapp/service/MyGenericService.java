package com.app.booksapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.booksapp.model.MyEntity;

public class MyGenericService<T extends JpaRepository<E, ID>, E extends MyEntity<ID>, ID> {
    
    @Autowired
    public T repository;

    public List<E> getAll(){
        return repository.findAll();
    }

    public E getById(ID id){
        Optional<E> result = repository.findById(id);
        return result.isPresent()?result.get():null;
    }

    public E create(E entity){
        if(getById(entity.getId())!=null)
            return null;
        return repository.save(entity);
    }

    public E update(ID id, E entity){
        if(getById(id)!=null){
            entity.setId(id);
            return repository.save(entity);
        }
        return null;
    }

    public E deleteById(ID id){
        E entity = getById(id);
        if(entity == null)
            return null;
        repository.deleteById(id);
        return entity;
    }

}
