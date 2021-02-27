package com.docdb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.AddException;
import com.docdb.model.entity.Subject;
import com.docdb.model.entity.dto.SubjectDTO;
import com.docdb.service.SubjectService;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController extends BaseController<Subject, SubjectDTO, SubjectService> {

	@PostMapping("/add")
	public ResponseEntity<?> addSubject(Integer id, @RequestBody SubjectDTO dto) {
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.fromEntity(service.save(id, dto)));
		} catch (AddException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		}
	}
}