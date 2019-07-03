package com.expense.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.demo.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
