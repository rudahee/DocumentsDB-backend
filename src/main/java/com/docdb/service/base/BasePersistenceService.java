package com.docdb.service.base;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.docdb.exception.UserException;
import com.docdb.model.entity.base.BaseEntity;
import com.docdb.model.entity.dto.BaseDTO;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.interfaces.IBasePersistenceService;
import com.docdb.service.security.JWTTokenProvider;
import com.docdb.service.util.dto.DTOConverter;


@Transactional
public abstract class BasePersistenceService<T extends BaseEntity, D extends BaseDTO, ID extends Serializable> implements IBasePersistenceService<T, ID> {
	
	protected BaseRepository<T, ID> baseRepository;
	
	protected DTOConverter<T, D> dtoConverter;
	
	@Autowired
	protected JWTTokenProvider jwtService;
	
	public BasePersistenceService(BaseRepository<T, ID> baseRepository,
			DTOConverter<T, D> dtoConverter) {
		this.baseRepository = baseRepository;
		this.dtoConverter = dtoConverter;
	}
	
	@Override
	public T find(ID entityId) {
		return baseRepository.findById(entityId).get();
	}

	@Override
	public List<T> findAll() {
		return (List<T>) baseRepository.findAll();
	}

	@Override
	public T save(T entity) throws UserException {
		return baseRepository.save(entity);
	}

	@Override
	public T update(T entity, ID entityId) {
		// Save and update do the same thing
		return baseRepository.save(entity);
	}

	@Override
	public void delete(ID entityId) {
		baseRepository.deleteById(entityId);
	}
}
