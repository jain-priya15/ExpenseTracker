package com.expense.demo.service;

import com.expense.demo.domain.User;

public interface UserService {
	
	/**
	 * 
	 * @param userForm
	 */
	void save(User userForm);

	/**
	 * 
	 * @param username
	 * @param passwordConfirm
	 * @return
	 */
	boolean autoLogin(String username, String passwordConfirm);

	/**
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
}
