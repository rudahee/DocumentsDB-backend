package com.docdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.UserException;
import com.docdb.model.entity.User;
import com.docdb.model.entity.dto.LoginDataReceivedDTO;
import com.docdb.model.entity.dto.UserDTO;
import com.docdb.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends BaseController<User, UserDTO, UserService> {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody UserDTO dto) throws UserException {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(
					dtoConverter.fromEntity(
							userService.save(super.dtoConverter.fromDto(dto)))
					);
		} catch (UserException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(
					ex.getCode());
		} 
	}

	@PostMapping("/sign-in")
	public ResponseEntity<?> SignIn(@RequestBody LoginDataReceivedDTO loginDataDTO){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(
					userService.findOne(loginDataDTO.getUsername(), loginDataDTO.getPassword()));
		} catch(UserException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(
					ex.getCode());
		}
	}

}
