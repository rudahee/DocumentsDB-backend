package com.docdb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.User;
import com.docdb.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends BaseController<User, UserService> {

	@GetMapping("/get")
	public ResponseEntity<?> findByToken(@RequestParam String token) {
		User entity = service.find(token);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entity);
	}
	@GetMapping("")
	public ResponseEntity<?> findByUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
		User entity = service.findByUsernameAndPassword(username, password);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entity.getToken());
	}
	

}
