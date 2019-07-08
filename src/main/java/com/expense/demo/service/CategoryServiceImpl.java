package com.expense.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expense.demo.domain.Category;
import com.expense.demo.repository.CategoryRepository;

@Service
@Transactional
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

	@Override
	public Category findById(Long id) {
		return categoryRepository.getOne(id);
	}

}
