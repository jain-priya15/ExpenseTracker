package com.expense.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.demo.domain.Category;
import com.expense.demo.domain.Expense;
import com.expense.demo.domain.User;
import com.expense.demo.service.CategoryService;
import com.expense.demo.service.ExpenseService;
import com.expense.demo.service.UserService;


@Controller
public class ExpenseController {
	
	/**
	 * 
	 */

	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
    private UserService userService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/expense")
	public String expense(Model model) {
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("category", categories);
		model.addAttribute("expense",new Expense());
		return "expense";
	}
	
	/**
	 * 
	 * @param expense
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/expense")
	public String expense(@ModelAttribute("expense")Expense expense, BindingResult result,Model model) {
		User user = null;
		if (result.hasErrors()) {
			List<Category> categories = categoryService.getCategories();
			model.addAttribute("category", categories);
	        return "expense";
	    }
		try {
			System.out.println(expense);
			user = userService.findByUsername(UserController.localUsername);
			expense.setUser(user);
	    	expenseService.addExpense(expense);
	    	System.out.println("Try");
	    }catch (Exception e) {
	    	System.out.println("Catch");
	    	List<Category> categories = categoryService.getCategories();
	    	model.addAttribute("category", categories);
	    	model.addAttribute("errorMessage", "Error: " + e.getMessage());
	    	return "expense";
	      }
		model.addAttribute("expense", expenseService.getMonthAndYearAndAmount());
        model.addAttribute("username",UserController.localUsername);
		return "dashboard";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping({"/listexpense"})
    public String expenseList(@RequestParam(value="page", defaultValue="0", required=false) int number, Model model) {
		PageRequest pageable;
		if(number>0)
			pageable = PageRequest.of(number - 1, 2);
		else
			pageable = PageRequest.of(number, 2);
		System.out.println("pageable"+pageable);
    	Page<Expense> page = expenseService.findAllByUser(UserController.localUsername, pageable);
    	int totalPages = page.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    	model.addAttribute("expenses", page.getContent());
    	model.addAttribute("username",UserController.localUsername);
        return "expenseList";
    }               
}
