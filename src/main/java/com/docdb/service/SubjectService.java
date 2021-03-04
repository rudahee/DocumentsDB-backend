package com.docdb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.exception.AddException;
import com.docdb.model.entity.Course;
import com.docdb.model.entity.Subject;
import com.docdb.model.entity.dto.SubjectDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.CourseRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class SubjectService extends BasePersistenceService<Subject, SubjectDTO, Integer> {
			
	public SubjectService(BaseRepository<Subject, Integer> baseRepository, DTOConverter<Subject, SubjectDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
	
	@Autowired
	CourseRepository courseRepository;
	
	@Transactional
	public Subject save(Integer id, SubjectDTO dto) throws AddException {
		
		Course course = courseRepository.findById(id).get();
		Subject subject;
		
		if (dto.getAcronym().isBlank() || dto.getName().isBlank()) {
			throw new AddException(ErrorCode.FIELD_IS_MISSING); 
		} else {
			if (course == null) {
				throw new AddException(ErrorCode.INDETERMINATE_ERROR);
			} else {
				subject = dtoConverter.fromDto(dto);			
				
				course.addSubject(subject);
				subject.setCourse(course);
				
				baseRepository.save(subject);
				courseRepository.save(course);
			}
		}
		
		return subject;
	}
	
}