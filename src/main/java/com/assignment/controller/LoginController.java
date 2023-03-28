package com.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.model.Login;
import com.assignment.model.Product;
import com.assignment.model.Profile;
import com.assignment.service.LoginService;
import com.assignment.service.ProductService;
import com.assignment.service.ProfileService;
import com.oracle.wls.shaded.org.apache.bcel.generic.NEW;

@Controller
public class LoginController {
	// get login service
	@Autowired
	private LoginService loginService;
	
	// list all users
	@RequestMapping("/")
	public ModelAndView homeView(Model model) {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	// admin panel view
	@RequestMapping("/admin")
	public ModelAndView listUsersAdminView(Model model) {
		List<Login> logins = loginService.getAllLogins();
		ModelAndView modelAndView = new ModelAndView("admin");
		modelAndView.addObject("logins", logins);
		return modelAndView;
	}
	
	// registration form
	@RequestMapping("/registration")
	public String showRegistrationFrom(@ModelAttribute("login") Login login) {
		return "registration";
	}
	
	// method for submitting registration form
	@RequestMapping(value = "/process-registration", method = RequestMethod.POST)
	public String processRegistrationForm(@ModelAttribute("login") Login login,
											@RequestParam("email") String email,
											@RequestParam("password") String password,
											@RequestParam("userType") String userType,
											@RequestParam("confirmPassword") String confirmPassword,
											Model model) {
		// check if passwords match
		if (!login.getPassword().equals(confirmPassword)) {
			// redirect to error page
			System.out.println("Passwords failed to match...");
			model.addAttribute("error", "Passwords do not match");
			return "registration";
		}
		
		// create new login model
		login.setEmail(email);
		login.setPassword(password);
		login.setUserType(userType);
		
		// if passwords match, insert data
		loginService.insert(login);
		
		// clear error messages if any
		model.addAttribute("error", null);
		
		// redirect to thank you page
		return "thank-you";
	}
	
	// redirect to home from thank you page
	@GetMapping("/return-home")
	public String returnHome() {
		return "redirect:/";
	}
	
	// login form
	@GetMapping("/login")
	public String showLoginForm(@ModelAttribute("login") Login login) {
		return "login";
	}
	
	// login validation method
	@PostMapping("/process-login")
	public String processLoginValidation(
				@ModelAttribute("login") Login login,
				@RequestParam("email") String email,
				@RequestParam("password") String password,
				HttpSession session,
				Model model
			) {
		// get service method to get email
		Login loginWtihEmail = loginService.getUserByEmail(email);
				
		// compare password and validate email
		if (loginWtihEmail == null || !loginWtihEmail.getPassword().equals(password)) {
			model.addAttribute("error", "Invalid email or password...");
			return "login";
		}
		
		// admin login
		if (loginWtihEmail.getEmail().equals("admin@boutiqa.com") && loginWtihEmail.getPassword().equals("admin123")) {
			return "redirect:/admin";
		}
		
		// save login details as hidden
		session.setAttribute("id", loginService.getUserByEmail(email).getUserId());
		session.setAttribute("email", email);
		
		// set profile attribute
		model.addAttribute("profile", new Profile());
		
		// go to update profile page if successful login
		return "update-profile";
	}
	
	// direct to reset password
	@GetMapping("/reset-password") 
	public String resetPassword(@ModelAttribute("login") Login login) {
		return "reset-password";
	}
	
	// path to verify email
	@PostMapping("/verify-email")
	public String verifyEmail(
				@ModelAttribute("login") Login login,
				@RequestParam("email") String email,
				Model model
			) {
		
		// get user by email
		Login userEmailLogin = loginService.getUserByEmail(email);
		
		// validate email with database
		if (userEmailLogin == null) {
			model.addAttribute("error", "Invalid email entered...");
			return "reset-password";
		} else {
			model.addAttribute("email", email);
			return "redirect:/reset-password-confirmation";
		}
	}
	
	// redirect to reset password confirmation
	@GetMapping("/reset-password-confirmation")
	public String resetPasswordConfirmation(@ModelAttribute("login") Login login) {
		return "reset-password-confirmation";
	}
	
	// reset password method
	@PostMapping("/reset-password-confirmation")
	public String processPasswordForm(
				@ModelAttribute("login") Login login,
				@RequestParam("email") String email,
				@RequestParam("password") String password,
				@RequestParam("confirmPassword") String confirmPassword,
				HttpSession session,
				Model model
			) {
		// check if passwords match
		if (!login.getPassword().equals(confirmPassword)) {
			System.out.println("Passwords do not match...");
			model.addAttribute("error", "Passwords do not match...");
			return "reset-password-confirmation";
		}
		
		// save to the database
		boolean resetStatus = loginService.updatePassword(email, password);
		
		// clear error messages
		model.addAttribute("error", null);
		
		// save session email
		session.setAttribute("id", loginService.getUserByEmail(email).getUserId());
		session.setAttribute("email", email);
		
		// return to home page
		if (resetStatus == false) {
			model.addAttribute("error", "Error in resetting your password...");
			return "reset-password-confirmation";
		} else {
			model.addAttribute("profile", new Profile());
			return "login";
		}
	}
	
	// admin function to delete user
	@PostMapping("/delete-user")
	public String deleteUser(@RequestParam("email") String email) {
		loginService.delete(email);
		return "redirect:/admin";
	}
	
	// direct to product search page
	@GetMapping("/products-list")
	public String showSearchProducts(@ModelAttribute("product") Product product) {
		return "products-list";
	}
}
