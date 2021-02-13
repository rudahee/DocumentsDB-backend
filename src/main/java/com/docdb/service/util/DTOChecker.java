package com.docdb.service.util;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.dto.LoginDataReceivedDTO;
import com.docdb.model.entity.dto.UserReceivedDTO;

@Service
public class DTOChecker {

	public Boolean checkUserReceivedDTO(UserReceivedDTO dto) {
		Boolean valid;
		if (dto.getUsername() == null || dto.getUsername().isBlank()) {
			valid = false;
		} else if (dto.getPassword() == null || dto.getPassword().isBlank()) {
			valid = false;
		} else if (dto.getEmail() == null || dto.getEmail().isBlank()) {
			valid = false;
		} else if (dto.getName() == null || dto.getName().isBlank()) {
			valid = false;
		} else if (dto.getSurname() == null || dto.getSurname().isBlank()) {
			valid = false;
		} else {
			valid = true;
		}
		
		return valid;
	}
	
	public Boolean checkLoginDataDTO(LoginDataReceivedDTO loginDataDTO) {
		Boolean valid;
		
		if (loginDataDTO.getUsername() == null || loginDataDTO.getUsername().isBlank()) {
			valid = false;
		} else if (loginDataDTO.getPassword()  == null || loginDataDTO.getPassword().isBlank()) {
			valid = false;
		} else {
			valid = true;
		}
		
		return valid;
	}
}
