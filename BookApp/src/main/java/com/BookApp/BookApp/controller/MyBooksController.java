package com.BookApp.BookApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookApp.BookApp.service.MyBookService;

@Controller
public class MyBooksController {

    @Autowired
    MyBookService myBookService;
    @RequestMapping("/deleteMyBook/{id}")
	public String deleteBook(@PathVariable("id") int id){
		myBookService.deleteBook(id);
        return "redirect:/my_books";
	}

}
