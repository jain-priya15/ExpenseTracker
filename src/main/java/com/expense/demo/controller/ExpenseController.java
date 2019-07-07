package com.expense.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/expense")
	public String dashboard(Model model) {
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("category", categories);
		model.addAttribute("expense",new Expense());
		return "expense";
	}
	
	@PostMapping("/expense")
	public String dashboard(Model model, @ModelAttribute("expense")Expense expense, BindingResult result) {
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
	      }
	      catch (Exception e) {
	    	  System.out.println("Catch");
	    	  List<Category> categories = categoryService.getCategories();
	    	  model.addAttribute("category", categories);
	    	  model.addAttribute("errorMessage", "Error: " + e.getMessage());
	    	  return "expense";
	      }
		//System.out.println("Expense:"+user.getExpense());
		model.addAttribute("expense", expenseService.getMonthAndYearAndAmount());
        model.addAttribute("username",UserController.localUsername);
		return "dashboard";
	}
	
	@GetMapping({"/listexpense"})
    public String expenseList(Model model) {
    	System.out.println(userService.findByUsername(UserController.localUsername));
    	model.addAttribute("expenses", expenseService.findAllByUser(UserController.localUsername));
    	model.addAttribute("username",UserController.localUsername);
        return "expenseList";
    }
	
	/*
	 * @RequestMapping(value = "/addCategories", method = RequestMethod.POST) public
	 * String addCategories(@RequestBody Category newCategory) { Category category =
	 * newCategory; categoryService.addCategory(category);
	 * 
	 * return "redirect:/expense"; }
	 * 
	 * @GetMapping("/{year}/{month}") public ResponseEntity<?>
	 * getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String
	 * month) { List<Expense> result = new ArrayList<>(); if("All".equals(month)) {
	 * result = expenseService.findByYear(year); } else { result =
	 * expenseService.findByMonthAndYear(month, year); } return new
	 * ResponseEntity(result, HttpStatus.OK); }
	 * 
	 * @PostMapping public ResponseEntity<?> addorUpdateExpense(@RequestBody Expense
	 * expense) { expenseService.saveOrUpdateExpense(expense); return new
	 * ResponseEntity("Expense added succcessfully", HttpStatus.OK); }
	 * 
	 * @DeleteMapping public void deleteExpense(@RequestParam("id") Long id) {
	 * expenseService.deleteExpense(id); }
	 */
}
