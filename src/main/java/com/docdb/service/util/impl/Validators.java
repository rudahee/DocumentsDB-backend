package com.docdb.service.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.repository.UserRepository;

@Service
public class Validators {

	@Autowired
	private UserRepository userRepo;
	
	public Boolean CheckUserOrEmailDoesntExists(String username, String email) {		
		return (!userRepo.existsByEmailIgnoreCase(email) && 
				!userRepo.existsByUsernameIgnoreCase(username)) ? true : false;
	}
	
	public Boolean CheckUserExists(String username) {
		return userRepo.existsByUsernameIgnoreCase(username);
	}
}
