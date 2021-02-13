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
import com.docdb.model.entity.dto.LoginDataDTO;
import com.docdb.model.entity.dto.UserReceivedDTO;
import com.docdb.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends BaseController<User, UserService> {
	
	@Autowired
	private UserService userService;

	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody UserReceivedDTO userDTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body("");
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/sign-in")
	public ResponseEntity<?> login(@RequestBody LoginDataDTO loginDataDTO){
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

}
