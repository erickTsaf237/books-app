package com.app.booksapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.booksapp.model.MyEntity;


public abstract class MyGenericService<T extends JpaRepository<E, ID>, E extends MyEntity<ID>, ID> {
    
    protected abstract T getRepository();


    public List<E> getAll(){
        return getRepository().findAll();
    }

    public E getById(ID id){
        Optional<E> result = getRepository().findById(id);
        return result.isPresent()?result.get():null;
    }

    public E create(E entity){
        if(getById(entity.getId())!=null)
            return null;
        return getRepository().save(entity);
    }

    public E update(ID id, E entity){
        if(getById(id)!=null){
            entity.setId(id);
            return getRepository().save(entity);
        }
        return null;
    }

    public E deleteById(ID id){
        E entity = getById(id);
        if(entity == null)
            return null;
        getRepository().deleteById(id);
        return entity;
    }

}






