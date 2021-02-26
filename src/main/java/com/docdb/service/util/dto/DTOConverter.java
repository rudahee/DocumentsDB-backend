package com.docdb.service.util.dto;

public abstract class DTOConverter<E, D> {

	public abstract E fromDto(D dto);
	
	public abstract D fromEntity(E entity);
}
