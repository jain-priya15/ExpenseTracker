package com.expense.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.expense.demo.domain.Expense;
import com.expense.demo.dto.DashboardExpense;
import com.expense.demo.dto.ExpenseResponse;

public interface ExpenseService {

	void deleteExpense(Long id);
	List<Expense> findAllByUser(String username);
	List<Expense> findAll();
	void addExpense(ExpenseResponse expenseResponse);
	List<DashboardExpense> getMonthAndYearAndAmount();
	Page<Expense> findAllByUser(String username, Pageable page);

}
