package com.expense.demo.service;

import java.util.List;

import com.expense.demo.domain.Expense;

public interface ExpenseService {


	void deleteExpense(Long id);

	List<Expense> findAllByUser(String username);

	List<Expense> findAll();

	void addExpense(Expense expense);
	
	List<?> getMonthAndYearAndAmount();

}
