package com.BookApp.BookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.BookApp.BookApp.module.Book;
import com.BookApp.BookApp.module.MyBooks;
import com.BookApp.BookApp.service.BookService;
import com.BookApp.BookApp.service.MyBookService;

import jakarta.websocket.server.PathParam;


@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	@Autowired
	private MyBookService myBookService;

	@GetMapping("")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister(){
		return "bookRegister";
	}


	@GetMapping("/available_book")
	public ModelAndView getAllBooks(){
		List<Book> books = bookService.getAllBooks();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("allBooks");
		modelAndView.addObject("book", books);
		return modelAndView;
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book){
		bookService.save(book);
		return "redirect:/available_book";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model){
		List<MyBooks> ls = myBookService.getAllMyBooks();
		model.addAttribute("book",ls);
		return "myBooks";
	}

	@RequestMapping("/deleteBook/{id}")
	public String delete(@PathVariable("id") int id){
		bookService.deletBookById(id);
		return "redirect:/available_book";
	}
	
	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookService.getBookById(id);
		MyBooks myBooks = new MyBooks(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBook(myBooks);
		return "redirect:/my_books";
	}
	
}
