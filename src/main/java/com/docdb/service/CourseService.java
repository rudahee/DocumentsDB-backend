package com.docdb.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.docdb.exception.AddException;
import com.docdb.model.entity.Course;
import com.docdb.model.entity.Customer;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class CourseService extends BasePersistenceService<Course, CourseDTO, Integer> {
			
	public CourseService(BaseRepository<Course, Integer> baseRepository) {
		super(baseRepository);
	}
	

	
	@Transactional
	public Course save(String token, CourseDTO dto) throws AddException {
		Customer customer = jwtService.getUserFromToken(token).getCustomer();
		
		Course course = dtoConverter.fromEntity(dto);

		if (dto.getDescription() == null || dto.getName().isBlank()) {
			throw new AddException(ErrorCode.FIELD_IS_MISSING); 
		} else {
			if (customer == null) {
				throw new AddException(ErrorCode.INDETERMINATE_ERROR);
			} else {
				
				course.setCustomer(customer);
				customer.addCourse(course);
			}
		}
		
		

		
		course.setLastModification(LocalDateTime.now());
		
		course.setCustomer(customer);
		
		customer.addCourse(course);
		
		return course;
	}
}