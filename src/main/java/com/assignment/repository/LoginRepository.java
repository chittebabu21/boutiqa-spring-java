package com.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, String> {
	// get method to retrieve login by email
	Login findByEmail(String email);
}
