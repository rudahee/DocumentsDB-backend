package com.docdb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.AddException;
import com.docdb.model.entity.Note;
import com.docdb.model.entity.dto.NoteDTO;
import com.docdb.service.NoteService;

@RestController
@RequestMapping(path = "/note")
public class NoteController  extends BaseController<Note, NoteDTO, NoteService> {

	@PostMapping("/add")
	public ResponseEntity<?> addTopic(@RequestParam Integer topic, @RequestBody NoteDTO dto) {
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.fromEntity(service.save(topic, dto)));
		} catch (AddException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		}
	}

}