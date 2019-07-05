package com.expense.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.demo.domain.Expense;
import com.expense.demo.domain.User;
import com.expense.demo.repository.ExpenseRepository;

@Service
@Transactional
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
		// TODO Auto-generated method stub
		return expenseRepository.findAll();
	}

}
