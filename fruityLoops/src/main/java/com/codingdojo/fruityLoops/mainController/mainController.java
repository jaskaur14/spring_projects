package com.codingdojo.fruityLoops.mainController;

import java.util.ArrayList;
import com.codingdojo.fruityLoops.models.Item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	@RequestMapping("/")
	public String index(Model model) {
		
		ArrayList<Item> fruits = new ArrayList<Item>();
	     fruits.add(new Item("Kiwi", 1.5));
	     fruits.add(new Item("Mango", 2.0));
	     fruits.add(new Item("Goji Berries", 4.0));
	     fruits.add(new Item("Guava", .75));
	     
	     // Add fruits your view model here
	     model.addAttribute("fruits", fruits);
	     
	     return "fruity.jsp";
	}
}
