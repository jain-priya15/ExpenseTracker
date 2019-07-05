package com.expense.demo.service;

import java.util.List;

import com.expense.demo.domain.Category;

public interface CategoryService {

	List<Category> getCategories();

	void addCategory(Category category);
	
	Category findById(Long id);

}
