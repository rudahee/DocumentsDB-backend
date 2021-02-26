package com.docdb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Course;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.service.CourseService;

@RestController
@RequestMapping(path = "/course")
public class CourseController  extends BaseController<Course, CourseDTO, CourseService> {
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(HttpServletRequest request, @RequestBody CourseDTO dto) {
		
		String token = request.getHeader("Authorization").split(" ")[1]; 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.fromEntity(service.save(token, dto)));
	}
}