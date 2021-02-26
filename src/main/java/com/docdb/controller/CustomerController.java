package com.docdb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.docdb.controller.base.BaseController;
import com.docdb.exception.UserException;
import com.docdb.model.entity.Customer;
import com.docdb.model.entity.dto.CustomerDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController extends BaseController<Customer, CustomerDTO, CustomerService> {



	@PostMapping("/image")
	public ResponseEntity<?> addImageProfile(HttpServletRequest request, @RequestParam MultipartFile image) throws UserException {
		
		if (service.addDocument(image, request.getUserPrincipal().getName()) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ErrorCode.NO_ERROR);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorCode.INDETERMINATE_ERROR);
		}
			
					
		
		
	}
}
