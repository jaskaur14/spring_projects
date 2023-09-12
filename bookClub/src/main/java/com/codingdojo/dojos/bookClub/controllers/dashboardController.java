package com.codingdojo.dojos.bookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.dojos.bookClub.services.BookService;
import com.codingdojo.dojos.bookClub.services.UserService;

@Controller
public class dashboardController {

	@Autowired
	private BookService books;
	@Autowired
	private UserService users;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("allUsers", users.all());
		model.addAttribute("allBooks", books.all());
		return "dashboard.jsp";
	}
}
