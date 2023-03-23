package com.assignment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Login;
import com.assignment.repository.LoginRepository;

@Service
@Transactional
public class LoginService {
	// get access to repository
	@Autowired
	private LoginRepository loginRepository;
	
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
		loginRepository.deleteById(email);
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
