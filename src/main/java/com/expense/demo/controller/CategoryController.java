package com.expense.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.expense.demo.domain.Category;
import com.expense.demo.domain.Expense;
import com.expense.demo.domain.User;
import com.expense.demo.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("/category")
	public String dashboard(Model model) {
		model.addAttribute("category",new Category());
		return "category";
	}
	
	@PostMapping("/category")
	public String dashboard(Model model, @ModelAttribute("category") @Validated Category category, BindingResult result) {
		if (result.hasErrors()) {
	        return "category";
	    }
		try {
	    	  categoryService.addCategory(category);
	      }
	      catch (Exception e) {
	    	  model.addAttribute("errorMessage", "Error: " + e.getMessage());
	    	  return "category";
	      }
		model.addAttribute("expense",new Expense());
		model.addAttribute("category", categoryService.getCategories());
        model.addAttribute("username",UserController.localUsername);
		return "expense";
	}
}