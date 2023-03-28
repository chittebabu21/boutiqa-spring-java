package com.assignment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Profile;
import com.assignment.repository.ProfileRepository;

@Service
@Transactional
public class ProfileService {
	// access the methods in the repository
	@Autowired
	private ProfileRepository profileRepository;
	
	// get all profiles
	public List<Profile> getAllProfiles() {
		return (List<Profile>) profileRepository.findAll();
	}
	
	// get profile by email
	public Profile getProfileByEmail(String email) {
		return profileRepository.findByEmail(email);
	}
	
	// insert new profile
	public void insert(Profile profile) {
		profileRepository.save(profile);
	}
	
	// delete profile
	public void delete(String email) {
		Profile profile = profileRepository.findByEmail(email);
		profileRepository.delete(profile);
	}
}
