package com.docdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.User;
import com.docdb.model.repository.UserRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class UserService extends BasePersistenceService<User, Integer> {
			
	@Autowired
	private UserRepository userRepository;
	
	public UserService(BaseRepository<User, Integer> baseRepository) {
		super(baseRepository);
	}

	public User findByUsernameAndPassword(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		user.generateLastLogin();
		
		baseRepository.save(user);
		
		return user;
	}
	
	public User find(String token) {
		return userRepository.findByToken(token);
	}
}
