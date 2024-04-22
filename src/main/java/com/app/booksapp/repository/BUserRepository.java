package com.app.booksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.booksapp.model.BUser;

@Repository
public interface BUserRepository extends JpaRepository<BUser,Long>{

}