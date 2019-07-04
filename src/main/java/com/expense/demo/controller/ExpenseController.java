package com.expense.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.demo.domain.Category;
import com.expense.demo.domain.Expense;
import com.expense.demo.service.CategoryService;
import com.expense.demo.service.ExpenseService;


@Controller
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Expense> result = expenseService.findAll();
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@GetMapping("/expense")
	public String dashboard(Model model) {
		String address ="http://localhost:8080/";
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		String addressAddEmployee = address+"trackEmployee";
		String addressTracker = address+"tracker";
		model.addAttribute("empaddress", addressAddEmployee);
		model.addAttribute("address", addressTracker);
		return "dashboard";
	}
	
	@RequestMapping(value = "/addCategories", method = RequestMethod.POST)
	public String addCategories(@RequestBody Category newCategory) {
		Category category = newCategory;
		categoryService.addCategory(category);

		return "redirect:/expense";
	}
	
	@GetMapping("/{year}/{month}")
	public ResponseEntity<?> getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String month) {
		List<Expense> result = new ArrayList<>();
		if("All".equals(month)) {
			result = expenseService.findByYear(year);
		} else {
			result = expenseService.findByMonthAndYear(month, year);			
		}
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addorUpdateExpense(@RequestBody Expense expense) {
		expenseService.saveOrUpdateExpense(expense);
		return new ResponseEntity("Expense added succcessfully", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteExpense(@RequestParam("id") Long id) {
		expenseService.deleteExpense(id);
	}
	
}
