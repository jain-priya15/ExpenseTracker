package com.expense.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.expense.demo.domain.Expense;
import com.expense.demo.domain.User;
import com.expense.demo.dto.DashboardExpense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	List<Expense> findAllByUser(User user);
	
	Page<Expense> findAllByUser(User user, Pageable pageable);
	
	@Query("select e from Expense e where year(e.date) = ?1 and month(e.date) = ?2")
	List<Expense> getByYearAndMonth(int year, int month);
	
	@Query("select new com.expense.demo.dto.DashboardExpense(Date_Format(e.date,'%m-%Y'),sum(e.amount)) from Expense e group by date_format(e.date,'%m-%Y')")
	List<DashboardExpense> getGroupByMonthAndYear();

}
