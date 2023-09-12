package com.codingdojo.dojos.bookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojos.bookClub.models.Book;
import com.codingdojo.dojos.bookClub.services.BookService;
import com.codingdojo.dojos.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService books;
	@Autowired
	private UserService users;
	
	
	
	@GetMapping("/new")
	public String bookForm(@ModelAttribute("newBook") Book book, BindingResult result, Model model) {
//		model.addAttribute("allUsers", users.all());
		return "createBook.jsp";
	}
	
	@PostMapping("/new")
	public String processBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result, Object b, Model model, HttpSession session) {
		
		
		if(result.hasErrors()) {
//			model.addAttribute("allUsers", users.all());
			return "createBook.jsp";
		}
		books.create(book);
		session.setAttribute("createdBook", book.getId());
		return "redirect:/books";
	}
	
	
	@GetMapping("/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("loggedIn") == null) {
			return "redirect:/";
		}
		Book bookToDisplay = books.find(id);
		model.addAttribute("user" , users.find((Long)session.getAttribute("loggedIn")));
		model.addAttribute("book", bookToDisplay);
		return "viewBook.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model, @ModelAttribute("book") Book book, HttpSession session) {
		System.out.println(book.getId());
		Book bookToEdit = books.find(id);
//		System.out.println(bookToEdit.getId());
		model.addAttribute("user", users.find((Long)session.getAttribute("loggedIn")));
		model.addAttribute("book", bookToEdit);
		return "editBook.jsp";
	}
	
	@PutMapping("/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id")Long id, Model model, Object e, HttpSession session, RedirectAttributes flashAttributes) {
		if(session.getAttribute("loggedIn") == null) {
//			flashAttributes.addFlashAttribute("loginError", "You must be logged in as user to edit");
			return "redirect:/";
		}

		if(result.hasErrors()) {
			System.out.println(id);
			return "editBook.jsp";
		}
		books.update(book);
		session.setAttribute("updatedBook", book.getId());
		return "redirect:/books";
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		System.out.println("==================");
		if(session.getAttribute("loggedIn") == null) {
			return "redirect:/";
		}
		books.destroy(id);
		return "redirect:/books";
	}
}
