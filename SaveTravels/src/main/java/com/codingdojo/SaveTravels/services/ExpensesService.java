package com.codingdojo.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.SaveTravels.models.Expense;
import com.codingdojo.SaveTravels.repositories.ExpenseRepository;

@Service
public class ExpensesService {
	// adding the expense repository as a dependency
    private final ExpenseRepository expenseRepository;
    
    public ExpensesService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates an expense
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    // retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
//    update and delete
    public Expense updateExpense(Expense expense) {
    	return expenseRepository.save(expense);
    }
    
    public void deleteExpense(Expense expense) {
    	expenseRepository.delete(expense);
    }
}
