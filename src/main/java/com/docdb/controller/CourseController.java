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
import com.docdb.service.security.JWTTokenProvider;

@RestController
@RequestMapping(path = "/course")
public class CourseController  extends BaseController<Course, CourseService> {
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(HttpServletRequest request, @RequestBody CourseDTO dto) {
		
		
		Integer id = JWTTokenProvider.getIdFromToken(request.getHeader("Authorization").split(" ")[1]); 
				/*
				 * Integer.parseInt(request.getUserPrincipal().getName());
		*/
		
		System.out.println(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(super.dtoConverter.fromCourseToCourseDTO(service.addCourse(id, dto)));
	}
}