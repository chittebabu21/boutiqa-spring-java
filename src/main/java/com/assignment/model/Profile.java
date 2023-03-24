package com.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_data")
public class Profile {
	// variables
	@Id
	@Column(name = "user_id")
	private Long userId;
	
	@OneToOne(mappedBy = "profile")
	private Login login;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;

	@JoinColumn(name = "email")
	private String email;

	// constructors
	public Profile() {
	}

	public Profile(Long userId, Login login, String name, String gender, String email) {
		this.userId = userId;
		this.login = login;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}

	// getters and setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
