package com.BookApp.BookApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookApp.BookApp.module.MyBooks;
import com.BookApp.BookApp.repository.MyBookRepository;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository myBookRepository;
    
    
    public void saveMyBook(MyBooks myBooks){
        myBookRepository.save(myBooks);
    }

    public List<MyBooks> getAllMyBooks(){
        return myBookRepository.findAll();
    }

    public void deleteBook(int id){
        myBookRepository.deleteById(id);;
    }
}
