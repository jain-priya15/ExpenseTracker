package com.expense.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.demo.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	List<Expense> findByMonthAndYear(String month, int year);

	List<Expense> findByYear(int year);

}
