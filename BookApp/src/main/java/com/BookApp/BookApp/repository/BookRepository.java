package com.BookApp.BookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookApp.BookApp.module.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
    
}
