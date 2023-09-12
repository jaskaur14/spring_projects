package com.codingdojo.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class mainController {
	
//	route that redirects to what we want as homepage url
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
//	route that renders home page
	@GetMapping("/omikuji")
	public String main() {
		return "main.jsp";
	}
	
//	POST route to process the form when user hits send
	@PostMapping("/submit")
	public String submit(
		@RequestParam("number") int number,
		@RequestParam("city") String city,
		@RequestParam("name") String name,
		@RequestParam("hobby") String hobby,
		@RequestParam("living") String living,
		@RequestParam("message") String message,
		HttpSession session
		) {
		String results = String.format("In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s", number, city, name, hobby, living, message);
		session.setAttribute("results", results);
		return "redirect:/show";
	}
	
//	route to render the fortune
	@GetMapping("/show")
	public String show(HttpSession session, Model model) {
		String result = (String) session.getAttribute("results");
		model.addAttribute("result", result);
		return "show.jsp";
	}	
}
