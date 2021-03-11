package com.docdb.service.util.dto;

import java.util.ArrayList;
import java.util.List;

import com.docdb.model.entity.base.BaseEntity;
import com.docdb.model.entity.dto.BaseDTO;


public abstract class DTOConverter<E extends BaseEntity, D extends BaseDTO> {

	//Each implement do same thing: collect all the attributes of the DTO and parse it to the entity
	public abstract E fromDto(D dto);
	
	//Each implement do same thing: collect all the attributes of the Entity and parse it to the DTO. Relations excludeds
	public abstract D fromEntity(E entity);
	
	// Do fromEntity for each entity in list.
	public List<D> fromEntities(List<E> entities) {
		List<D> dtos = new ArrayList<D>();
		entities.forEach(entity -> {
			dtos.add(this.fromEntity(entity));
		});
		
		return dtos;
	}
}
