package com.expense.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.demo.domain.Expense;
import com.expense.demo.domain.User;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	List<Expense> findAllByUser(User user);

}
