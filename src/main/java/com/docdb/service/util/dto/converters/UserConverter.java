package com.docdb.service.util.dto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.docdb.model.entity.User;
import com.docdb.model.entity.dto.UserDTO;
import com.docdb.service.util.dto.DTOConverter;

public class UserConverter extends DTOConverter<User, UserDTO>{


	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User fromDto(UserDTO dto) {
		User user  = new User();
		
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setAge(dto.getAge());
		
		return user;
	}
	
	public UserDTO fromEntity(User user) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setAge(user.getAge());
		dto.setName(user.getName());
		dto.setSurname(user.getSurname());
		dto.setRoles(user.getRoles());
		dto.setLastPasswordChange(user.getLastPasswordChange());
		dto.setNextPasswordChange(user.getNextPasswordChange());
		dto.setCreateTime(user.getCreateTime());
		dto.setUpdateTime(user.getUpdateTime());
		
		return dto;
	}
	

	
}
