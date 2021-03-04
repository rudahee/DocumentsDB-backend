package com.docdb.service.util.dto;

import java.util.ArrayList;
import java.util.List;

import com.docdb.model.entity.base.BaseEntity;
import com.docdb.model.entity.dto.BaseDTO;


public abstract class DTOConverter<E extends BaseEntity, D extends BaseDTO> {

	public abstract E fromDto(D dto);
	
	public abstract D fromEntity(E entity);
	
	public List<D> fromEntities(List<E> entities) {
		List<D> dtos = new ArrayList<D>();
		entities.forEach(entity -> {
			dtos.add(this.fromEntity(entity));
		});
		
		return dtos;
	}
}
