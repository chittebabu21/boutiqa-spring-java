package com.assignment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.model.Profile;
import com.assignment.service.ProfileService;

@Controller
@DependsOn("loginController")
public class ProfileController {
	// get access to service methods
	@Autowired
	private ProfileService profileService;
	
	// define bean profile
	@GetMapping("/update-profile")
	public String showUpdateProfile(
				@ModelAttribute("profile") Profile profile, 
				Model model, 
				HttpSession session
		) {
		// get email from session
		String userEmail = (String) session.getAttribute("email");
		
		// check if user is logged in
		if (userEmail == null) {
			return "redirect:/login";
		} else {
			// get the user profile
			Profile userProfile = profileService.getProfileByEmail(userEmail);
			
			// add the profile object to the model
			model.addAttribute("profile", userProfile);
			
			// redirect to update profile
			return "update-profile";
		}
	}
	
	// process the update of profile
	@PostMapping("/process-profile-update")
	public String processProfileUpdate(
				@ModelAttribute("profile") Profile profile,
				@RequestParam("name") String name,
				@RequestParam("gender") String gender,
				HttpSession session,
				Model model
			) {
		// retrieve the email in the session
		Long userId = (Long) session.getAttribute("id");
		String userEmail = (String) session.getAttribute("email");
		
		// set profile
		profile.setUserId(userId);
		profile.setName(name);
		profile.setEmail(userEmail);
		profile.setGender(gender);
		
		// insert into database
		profileService.insert(profile);
		
		// set session attributes
		session.setAttribute("name", name);
		session.setAttribute("email", userEmail);
		session.setAttribute("gender", gender);
		
		// redirect to user profile page
		return "user-profile";
		
	}
}
