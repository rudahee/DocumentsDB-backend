package com.docdb.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.zip.DataFormatException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
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
					@RequestParam String extension, @RequestParam String type) throws UserException, IOException, InterruptedException {
		
		ResponseEntity<?> response;
		
		try {
			if (mpf.getSize() > 4278190080L) {
				response = ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(ErrorCode.FILE_TOO_BIG);
			}
			
			String user = jwtToken.getUserFromToken(request.getHeader("Authorization").split(" ")[1]).getId().toString();			
			service.saveDocument(mpf, user, note, extension, type);
			
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
	
	@GetMapping("/get/data/{id}")
	public ResponseEntity<?> getData(HttpServletResponse response, @PathVariable Integer id) throws SQLException, IOException, DataFormatException {
		
		Document doc = service.getDocument(id);
		
		Blob blob = doc.getData();
		
		IOUtils.copy(blob.getBinaryStream(), response.getOutputStream());
		
		response.addHeader("Content-Type", doc.getContentType());
		response.addHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", doc.getName()));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtoConverter.fromEntity(doc));
	}
	
	@GetMapping("/get/json/{id}")
	public ResponseEntity<?> getJson(@PathVariable Integer id) throws SQLException, IOException, DataFormatException {
		
		Document doc = service.getDocument(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtoConverter.fromEntity(doc));
	}
}


