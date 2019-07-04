package com.expense.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.demo.domain.Category;
import com.expense.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
		
	}

}