package com.expense.demo.service;

import java.util.List;

import com.expense.demo.domain.Expense;

public interface ExpenseService {

	List<Expense> findAll();

	List<Expense> findByYear(int year);

	List<Expense> findByMonthAndYear(String month, int year);

	void saveOrUpdateExpense(Expense expense);

	void deleteExpense(Long id);

}
