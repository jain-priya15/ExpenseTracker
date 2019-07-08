package com.expense.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.expense.demo.domain.Expense;
import com.expense.demo.domain.User;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	/**
	 * 
	 * @param user
	 * @return
	 */
	List<Expense> findAllByUser(User user);
	
	/**
	 * 
	 * @param user
	 * @param pageable
	 * @return
	 */
	List<Expense> findAllByUser(User user, Pageable pageable);
	
	/**
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	@Query("select e from Expense e where year(e.date) = ?1 and month(e.date) = ?2")
	List<Expense> getByYearAndMonth(int year, int month);
	
	/**
	 * 
	 * @return
	 */
	@Query("select Date_Format(e.date,'%m-%Y'),sum(e.amount) from Expense e group by date_format(e.date,'%m-%Y')")
	List<?> getGroupByMonthAndYear();

}
