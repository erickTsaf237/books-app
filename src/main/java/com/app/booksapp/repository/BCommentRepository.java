package com.app.booksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.booksapp.model.BComment;

@Repository
public  interface BCommentRepository extends JpaRepository<BComment,Long>{

}