package com.docdb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.AddException;
import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.TopicDTO;
import com.docdb.service.TopicService;

@RestController
@RequestMapping(path = "/topic")
public class TopicController  extends BaseController<Topic, TopicDTO, TopicService> {

	@PostMapping("/add")
	public ResponseEntity<?> addTopic(Integer id, @RequestBody TopicDTO dto) {
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.fromEntity(service.save(id, dto)));
		} catch (AddException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		}
	}
}
