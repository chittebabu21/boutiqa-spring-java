package com.assignment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Login;
import com.assignment.model.Profile;
import com.assignment.repository.LoginRepository;
import com.assignment.repository.ProfileRepository;

@Service
@Transactional
public class LoginService {
	// get access to repository
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired 
	private ProfileService profileService;
	
	// get all login credentials 
	public List<Login> getAllLogins() {
		return (List<Login>) loginRepository.findAll();
	}
	
	// insert new row
	public void insert(Login login) {
		loginRepository.save(login);
	}
	
	// delete login credentials
	public void delete(String email) {
		// get profile object by user and delete
		Profile profile = profileService.getProfileByEmail(email);
		if (profile != null) {
			profileRepository.delete(profile);
		}
				
		// get login object by user and delete
		Login login = loginRepository.findByEmail(email);
		if (login != null) {
			loginRepository.delete(login);
		}
	}
	
	// get user by email
	public Login getUserByEmail(String email) {
		return loginRepository.findByEmail(email);
	}
	
	// update password
	public boolean updatePassword(String email, String password) {
		// find user by email
		Login login = loginRepository.findByEmail(email);
		
		// check if user exists
		if (login != null) {
			login.setPassword(password);
			loginRepository.save(login);
			return true;
		} else {
			return false;
		}
	}
}
