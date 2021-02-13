package com.docdb.controller.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.docdb.controller.interfaces.IBaseController;
import com.docdb.model.entity.base.BaseEntity;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.DTOChecker;
import com.docdb.service.util.DTOConverter;
import com.docdb.service.util.Validators;

public abstract class BaseController <T extends BaseEntity, S extends BasePersistenceService<T, Integer>> implements
IBaseController<T, Integer> {

	@Autowired
	protected S service;
	
	@Autowired
	protected DTOConverter dtoConverter;
	
	@Autowired
	protected DTOChecker dtoChecker;
	
	@Autowired
	protected Validators validator;
	
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<T> entities = service.findAll();
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entities);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		T entity = service.find(id);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entity);
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody T entity) {
		service.save(entity);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody T entity) {
		T newEntity = service.update(entity, id);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(newEntity);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		T entity = service.find(id);
		service.delete(id);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(entity);
	}
	
}
