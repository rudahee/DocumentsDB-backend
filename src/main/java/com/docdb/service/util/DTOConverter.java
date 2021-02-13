package com.docdb.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.docdb.model.entity.User;
import com.docdb.model.entity.dto.UserReceivedDTO;
import com.docdb.model.entity.dto.UserSentDTO;

@Component
public class DTOConverter {


	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User fromUserReceivedDTOToUser(UserReceivedDTO dto) {
		User user  = new User();
		
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setAge(dto.getAge());
		
		return user;
	}
	
	public UserSentDTO fromUserToUserSentDTO(User user) {
		UserSentDTO dto = new UserSentDTO();
		
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
