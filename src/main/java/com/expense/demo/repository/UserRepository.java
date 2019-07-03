package com.expense.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
