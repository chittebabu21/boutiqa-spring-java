package com.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, String> {
	// get profile by email
	Profile findByEmail(String email);
}
