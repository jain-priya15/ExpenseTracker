package com.expense.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.demo.domain.User;
import com.expense.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User userForm) {
		userRepository.save(userForm);
	}

	@Override
	public boolean autoLogin(String username, String passwordConfirm) {
		User user = userRepository.findByUsernameAndPassword(username,passwordConfirm);
		if(user!=null) {
			return true;
		}
		return false;
	}

}
