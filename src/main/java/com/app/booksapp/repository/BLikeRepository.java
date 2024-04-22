package com.app.booksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.booksapp.model.BLike;

@Repository
public interface BLikeRepository extends JpaRepository<BLike,Long>{

}
