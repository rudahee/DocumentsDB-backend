package com.docdb.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.docdb.model.entity.base.BaseEntity;

public interface IBasePersistenceService<T extends BaseEntity, ID extends Serializable> {

	public abstract T find(ID entityId);
	public abstract List<T> findAll();
	public abstract T save(T entity);
    public abstract T update(T entity, ID entityId);
    public abstract void delete(ID entityId);
}

