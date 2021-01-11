package com.docdb.model.repository.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.docdb.model.entity.base.BaseEntity;


@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> 
	extends JpaRepository<T, ID> {
		
}

