package com.expense.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.expense.demo.domain.Expense;
import com.expense.demo.domain.User;
import com.expense.demo.repository.ExpenseRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	UserService userService;

	@Override
	public List<Expense> findAllByUser(String username) {
		User user = userService.findByUsername(username);
		return expenseRepository.findAllByUser(user);
	}
	
	@Override
	public Page<Expense> findAllByUser(String username, Pageable page) {
		User user = userService.findByUsername(username);
		return expenseRepository.findAllByUser(user, page);
	}
	
	@Override
	public void addExpense(Expense expense) {
		System.out.println("Expense: "+expense);
		expenseRepository.save(expense);
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);		
	}

	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}
	@Override
	public List<?> getMonthAndYearAndAmount() {
		return expenseRepository.getGroupByMonthAndYear();
	}

}
