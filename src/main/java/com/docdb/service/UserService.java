package com.docdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.docdb.exception.UserException;
import com.docdb.model.entity.User;
import com.docdb.model.entity.dto.UserDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.UserRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class UserService extends BasePersistenceService<User, UserDTO, Integer> implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(BaseRepository<User, Integer> baseRepository) {
		super(baseRepository);
	}
	
	@Override
	public User save(User entity) throws UserException {
		if (entity.getPassword().isBlank() 
				|| entity.getUsername().isBlank() 
				|| entity.getEmail().isBlank()) {
			throw new UserException(ErrorCode.FIELD_IS_MISSING);
		
		} else if (userRepository.existsByEmailIgnoreCase(entity.getEmail()) 
				|| userRepository.existsByUsernameIgnoreCase(entity.getUsername())) {
			throw new UserException(ErrorCode.USER_ALREADY_EXIST);
		} else {
			return baseRepository.save(entity);
		}
				
	}

	public User findOne(String username, String password) throws UserException {
		if (username.isBlank() || password.isBlank()) {
			throw new UserException(ErrorCode.FIELD_IS_MISSING);
		} else {
			
			Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
			
			if (user.isEmpty()) { 
				throw new UserException(ErrorCode.INCORRECT_LOGIN);
			} else {				
				return user.get();
			}
			
		}
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
		
	}

}
