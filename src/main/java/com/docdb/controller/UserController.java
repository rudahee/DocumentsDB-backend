package com.docdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.User;
import com.docdb.model.entity.dto.LoginDataReceivedDTO;
import com.docdb.model.entity.dto.UserReceivedDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends BaseController<User, UserService> {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody UserReceivedDTO userDTO) {
		try {
			ResponseEntity<?> response;
			if (super.dtoChecker.checkUserReceivedDTO(userDTO)) {
				if (super.validator.CheckUserOrEmailDoesntExists(userDTO.getUsername(), userDTO.getEmail())) {
					response =  ResponseEntity.status(HttpStatus.CREATED).body(
							super.dtoConverter.fromUserToUserSentDTO(
									userService.save(
											super.dtoConverter.fromUserReceivedDTOToUser(userDTO))));									
				} else {
					response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ErrorCode.USER_ALREADY_EXIST);
				}
			} else {
				response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ErrorCode.FIELD_IS_MISSING);
			}
			
			return response;
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/sign-in")
	public ResponseEntity<?> SignIn(@RequestBody LoginDataReceivedDTO loginDataDTO){
		try {
			ResponseEntity<?> response;
			if (super.dtoChecker.checkLoginDataDTO(loginDataDTO)) {
				if (super.validator.CheckUserExists(loginDataDTO.getUsername())) {
					super.dtoConverter.fromUserToUserSentDTO(
							userService.findByUsernameAndPassword(
									loginDataDTO.getUsername(), loginDataDTO.getPassword()));
					response =  ResponseEntity.ok().build();
				} else {
					response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorCode.INCORRECT_LOGIN);
				}
			} else {
				response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ErrorCode.FIELD_IS_MISSING);
			}
			
			return response;
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

}
