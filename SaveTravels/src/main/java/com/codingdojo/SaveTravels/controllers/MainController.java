package com.codingdojo.SaveTravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.SaveTravels.models.Expense;
import com.codingdojo.SaveTravels.services.ExpensesService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	ExpensesService expensesService;
	
	@GetMapping("/") 
		public String dashboard() {
			return "redirect:/expenses";
		}
// adding an expense through form
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expensesService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String index(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expensesService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}else {
			expensesService.createExpense(expense);
			System.out.println(expense);
			return "redirect:/expenses";
		}
	}
	
//	editing an expense
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expensesService.findExpense(id));
		return "edit.jsp";
	}
	
	@PostMapping("/expenses/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expensesService.findExpense(id));
			return "redirect:/edit/{id}";
		} else {
			expensesService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
//	viewing an expense
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expensesService.findExpense(id));
		return "show.jsp";
	}
	
//	deleting an expense
	@RequestMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		Expense expense = expensesService.findExpense(id);
		expensesService.deleteExpense(expense);
		return "redirect:/expenses";
	}
}


