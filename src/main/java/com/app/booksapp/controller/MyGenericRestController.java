package com.app.booksapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.booksapp.model.MyEntity;
import com.app.booksapp.service.MyGenericService;

import java.util.List;

public abstract class MyGenericRestController<T extends MyGenericService<?, E, ID>,E extends MyEntity<ID>, ID> {

    @Autowired
    private T service;

    @GetMapping("/")
    public ResponseEntity<List<E>> getAll() {
        List<E> entities = service.getAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getById(@PathVariable ID id) {
        E entity = service.getById(id);
        if (entity != null) {
            return new ResponseEntity<>(entity,  HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<E> create(@RequestBody E entity) {
        E createdEntity = service.create(entity);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> update(@PathVariable ID id, @RequestBody E entity) {
        E updatedEntite = service.update(id, entity);
        if (updatedEntite != null) {
            return new ResponseEntity<>(updatedEntite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (service.deleteById(id) != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
