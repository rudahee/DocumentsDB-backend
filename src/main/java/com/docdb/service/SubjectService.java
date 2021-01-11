package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Subject;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class SubjectService extends BasePersistenceService<Subject, Integer> {
			
	public SubjectService(BaseRepository<Subject, Integer> baseRepository) {
		super(baseRepository);
	}
}