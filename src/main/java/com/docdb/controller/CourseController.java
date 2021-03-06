package com.docdb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.AddException;
import com.docdb.exception.JwtException;
import com.docdb.model.entity.Course;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.service.CourseService;
import com.docdb.service.util.dto.converters.CourseConverter;

@RestController
@RequestMapping(path = "/course")
public class CourseController  extends BaseController<Course, CourseDTO, CourseService> {
	
	@Autowired
	private CourseConverter courseConverter;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(HttpServletRequest request, @RequestBody CourseDTO dto) {
		String token;
		
		try {
			// If doesnt exists JWT, throw a JWTException, with customize error code
			if (request.getHeader("Authorization") != null) {
				token = request.getHeader("Authorization").split(" ")[1]; 
			} else {
				throw new JwtException(ErrorCode.JWT_ERROR);
			}
			
			return ResponseEntity.status(HttpStatus.CREATED).body(courseConverter.fromEntityWithoutSubject(service.save(token, dto)));
		
		} catch (AddException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		} catch (JwtException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> findAll(HttpServletRequest request) {
		String token;
		
		try {
			// If doesnt exists JWT, throw a JWTException, with customize error code
			if (request.getHeader("Authorization") != null) {
				token = request.getHeader("Authorization").split(" ")[1]; 
			} else {
				throw new JwtException(ErrorCode.JWT_ERROR);
			}
			
			return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.fromEntities(service.findAll(token)));
		
		} catch (JwtException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		}
	}
	
}