package com.docdb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Subject;
import com.docdb.model.entity.dto.SubjectDTO;
import com.docdb.service.SubjectService;
import com.docdb.service.security.JWTTokenProvider;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController extends BaseController<Subject, SubjectService> {

	@PostMapping("/add")
	public ResponseEntity<?> addCourse(HttpServletRequest request, @RequestBody SubjectDTO dto) {
		
		
		Integer id = JWTTokenProvider.getIdFromToken(request.getHeader("Authorization").split(" ")[1]); 
		
		System.out.println(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(super.dtoConverter.fromSubjectToSubjectDTO(service.addSubject(id, dto)));
	}
}