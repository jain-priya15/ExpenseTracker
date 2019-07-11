package com.expense.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.demo.domain.User;
import com.expense.demo.domain.Expense;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String passwordConfirm);

}
