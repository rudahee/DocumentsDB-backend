package com.docdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.User;
import com.docdb.model.repository.UserRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class UserService extends BasePersistenceService<User, Integer> implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(BaseRepository<User, Integer> baseRepository) {
		super(baseRepository);
	}

	public User getUserById(Integer idUser) {
		return baseRepository.findById(idUser).get();
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

}
