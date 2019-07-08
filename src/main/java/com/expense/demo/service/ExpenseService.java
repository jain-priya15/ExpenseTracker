package com.expense.demo.service;

import java.util.List;

import com.expense.demo.domain.Expense;

public interface ExpenseService {

	/**
	 * 
	 * @param id
	 */
	void deleteExpense(Long id);

	/**
	 * 
	 * @param username
	 * @return
	 */
	List<Expense> findAllByUser(String username);

	/**
	 * 
	 * @return
	 */
	List<Expense> findAll();

	/**
	 * 
	 * @param expense
	 */
	void addExpense(Expense expense);
	
	/**
	 * 
	 * @return
	 */
	List<?> getMonthAndYearAndAmount();

}
