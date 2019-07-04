package com.expense.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.demo.domain.Expense;
import com.expense.demo.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}

	@Override
	public List<Expense> findByMonthAndYear(String month, int year) {
		return expenseRepository.findByMonthAndYear(month, year);
	}

	@Override
	public void saveOrUpdateExpense(Expense expense) {
		expenseRepository.save(expense);
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);		
	}

	@Override
	public List<Expense> findByYear(int year) {
		return expenseRepository.findByYear(year);
	}

}
