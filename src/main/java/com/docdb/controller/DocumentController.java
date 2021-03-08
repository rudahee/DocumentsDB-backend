package com.docdb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.UserException;
import com.docdb.model.entity.Document;
import com.docdb.model.entity.dto.DocumentDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.service.DocumentService;
import com.docdb.service.NoteService;
import com.docdb.service.security.JWTTokenProvider;

@RestController
@RequestMapping(path = "/document")
public class DocumentController  extends BaseController<Document, DocumentDTO, DocumentService> {

	@Autowired
	private JWTTokenProvider jwtToken;
	
	@Autowired
	private NoteService noteService;

	@PostMapping("/{note}")
	public ResponseEntity<?> save(HttpServletRequest request, @PathVariable String note, @RequestParam MultipartFile mpf, 
					@RequestParam String extension) throws UserException, IOException, InterruptedException {
		
		ResponseEntity<?> response;
		
		try {
			if (mpf.getSize() > 4278190080L) {
				response = ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(ErrorCode.FILE_TOO_BIG);
			}
			
			String user = jwtToken.getUserFromToken(request.getHeader("Authorization").split(" ")[1]).getId().toString();			
			service.saveDocument(mpf, user, note, extension);
			
			response = ResponseEntity.status(HttpStatus.CREATED).body(ErrorCode.NO_ERROR);
		
			return response;
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorCode.INDETERMINATE_ERROR);
		}
	}
	
	@GetMapping("/get/{note}")
	public ResponseEntity<?> get(HttpServletRequest request, @PathVariable String note) throws UserException, IOException, InterruptedException {
		
		ResponseEntity<?> response;
		
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(
					dtoConverter.fromEntities(noteService.find(Integer.parseInt(note)).getDocuments())
					);
			return response;
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorCode.INDETERMINATE_ERROR);
		}
	}
}


