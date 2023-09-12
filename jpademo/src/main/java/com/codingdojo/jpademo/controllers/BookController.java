package com.codingdojo.jpademo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.jpademo.models.Book;
import com.codingdojo.jpademo.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("book", book);
		model.addAttribute("books", books);
		
		return "index.jsp";
	}

	 @GetMapping("/books/new")
	    public String newBook(@ModelAttribute("book") Book book) {
	        return "new.jsp";
	    }
	 @PostMapping("/books")
	    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "new.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/books";
	        }
	    }
}
