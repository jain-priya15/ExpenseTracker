package com.expense.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expense.demo.domain.User;
import com.expense.demo.repository.UserRepository;

@Service
@Transactional
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

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
