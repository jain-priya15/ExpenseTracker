package com.expense.demo.service;

import com.expense.demo.domain.User;

public interface UserService {
	
	void save(User userForm);
	boolean autoLogin(String username, String passwordConfirm);
	User findByUsername(String username);
}
