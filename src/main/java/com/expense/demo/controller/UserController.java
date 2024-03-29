package com.expense.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.expense.demo.domain.User;
import com.expense.demo.service.ExpenseService;
import com.expense.demo.service.UserService;

@Controller
public class UserController {
		/**
		 * Global variable for saving userName value
		 * 
		 */
		public static String localUsername;
		
		@Autowired
		private ExpenseService expenseService;
	
	 	@Autowired
	    private UserService userService;
	 	
	 	/**
	 	 * This methods check the login username and password is correct or incorrect. If correct it call dashboard service,
	 	 * Otherwise, it will redirect to login with error;
	 	 * @param username
	 	 * @param password
	 	 * @param model
	 	 * @return
	 	 */
	 	@PostMapping("/login")
	    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
	 		System.out.println(username +"Hello "+ password);
	 		boolean flag=userService.autoLogin(username, password);
	        if(flag) {
	        	model.addAttribute("expense", expenseService.getMonthAndYearAndAmount());
	 	        model.addAttribute("username",username);
	 	        localUsername = username;
	 	        return "redirect:/dashboard";
	        }
	        model.addAttribute("error",true);
	        return "login";
	    }

	 	/**
	 	 * Create new registration form
	 	 * @param model
	 	 * @return
	 	 */
	    @GetMapping("/registration")
	    public String registration(Model model) {
	        model.addAttribute("userForm", new User());
	        return "registration";
	    }

	    /**
	     * Save registration of new user.
	     * @param userForm
	     * @param bindingResult
	     * @param model
	     * @return
	     */
	    @PostMapping("/registration")
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {if (bindingResult.hasErrors()) {
	            return "registration";
	        }
	        userService.save(userForm);
	        localUsername=userForm.getUsername();
	        boolean flag=userService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
	        model.addAttribute("expense", expenseService.getMonthAndYearAndAmount());
	        model.addAttribute("username",userForm.getUsername());
	        return "redirect:/dashboard";
	    }

	    /**
	     * Login/Logout
	     * @param model
	     * @param error
	     * @param logout
	     * @return
	     */
	    @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }

	    /**
	     * Landing Page Service.
	     * @param model
	     * @return
	     */
	    @GetMapping({"/","/dashboard"})
	    public String welcome(Model model) {
	    	model.addAttribute("expense", expenseService.getMonthAndYearAndAmount());
	        model.addAttribute("username",localUsername);
	        return "dashboard";
	    }
}
