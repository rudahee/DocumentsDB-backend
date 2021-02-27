package com.docdb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.exception.AddException;
import com.docdb.model.entity.Course;
import com.docdb.model.entity.Subject;
import com.docdb.model.entity.dto.SubjectDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class SubjectService extends BasePersistenceService<Subject, SubjectDTO, Integer> {
			
	public SubjectService(BaseRepository<Subject, Integer> baseRepository) {
		super(baseRepository);
	}
	
	@Autowired
	CourseService courseService;
	
	@Transactional
	public Subject save(Integer id, SubjectDTO dto) throws AddException {
		
		Course course = courseService.find(id);
		Subject subject;
		
		if (dto.getAcronym().isBlank() || dto.getName().isBlank()) {
			throw new AddException(ErrorCode.FIELD_IS_MISSING); 
		} else {
			if (course == null) {
				throw new AddException(ErrorCode.INDETERMINATE_ERROR);
			} else {
				subject = dtoConverter.fromEntity(dto);			
				
				course.addSubject(subject);
				subject.setCourse(course);
			}
		}
		
		return subject;
	}
	
}