package com.BookApp.BookApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookApp.BookApp.module.Book;
import com.BookApp.BookApp.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    public void save(Book book){
        bookRepository.save(book);
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    
    public void deletBookById(int id){
        bookRepository.deleteById(id);
    }
}
