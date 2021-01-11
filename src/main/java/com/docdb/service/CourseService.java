package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Course;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class CourseService extends BasePersistenceService<Course, Integer> {
			
	public CourseService(BaseRepository<Course, Integer> baseRepository) {
		super(baseRepository);
	}
}