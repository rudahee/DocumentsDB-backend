package com.docdb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.AddException;
import com.docdb.exception.JwtException;
import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.TopicDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.service.TopicService;
import com.docdb.service.util.dto.converters.TopicConverter;

@RestController
@RequestMapping(path = "/topic")
public class TopicController  extends BaseController<Topic, TopicDTO, TopicService> {

	@Autowired
	private TopicConverter topicConverter;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTopic(@RequestParam Integer subject, @RequestBody TopicDTO dto) {
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.fromEntity(service.save(subject, dto)));
		} catch (AddException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> find(HttpServletRequest request, @RequestParam String id) {
		
		try {
			Integer idInteger = Integer.parseInt(id);
			if (request.getHeader("Authorization") == null) {
				throw new JwtException(ErrorCode.JWT_ERROR);
			}			
			TopicDTO topicDto = topicConverter.fromEntityWithNote(service.find(idInteger));
			return ResponseEntity.status(HttpStatus.CREATED).body(topicDto);
		
		} catch (JwtException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCode());
		}
	}
}
