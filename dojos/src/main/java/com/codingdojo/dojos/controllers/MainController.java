package com.codingdojo.dojos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.services.DojoService;
import com.codingdojo.dojos.services.NinjaService;

@Controller
public class MainController {

	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	
	@GetMapping("/dojos")
	public String createDojo(@ModelAttribute("dojoModel") Dojo dojoModel) {
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String processDojo(@ModelAttribute("dojoModel") Dojo dojoModel) {
		dService.create(dojoModel);
		return "redirect:/ninjas";
	}
	
	@GetMapping("/ninjas")
	public String createNinja(@ModelAttribute("ninjaModel") Ninja ninjaModel, Model model) {
		model.addAttribute("allDojos", dService.all());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String processNinja(@ModelAttribute("ninjaModel") Ninja ninjaModel) {
		nService.create(ninjaModel);
		return "redirect:/dojos/" + ninjaModel.getDojo().getId();
	}
	
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dService.find(id));
		return "show.jsp";
	}
}
