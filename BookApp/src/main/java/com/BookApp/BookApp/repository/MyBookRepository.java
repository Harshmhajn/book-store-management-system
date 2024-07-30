package com.BookApp.BookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookApp.BookApp.module.MyBooks;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooks,Integer> {
    
}
