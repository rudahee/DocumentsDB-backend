package com.docdb.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.Course;
import com.docdb.model.entity.Customer;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.security.JWTTokenProvider;

@Service
public class CourseService extends BasePersistenceService<Course, CourseDTO, Integer> {
			
	public CourseService(BaseRepository<Course, Integer> baseRepository) {
		super(baseRepository);
	}
	

	
	@Transactional
	public Course save(String token, CourseDTO dto) {
		
		Customer customer = jwtService.getUserFromToken(token).getCustomer();
		
		Course course = dtoConverter.fromEntity(dto);
		
		course.setLastModification(LocalDateTime.now());
		
		course.setCustomer(customer);
		
		customer.addCourse(course);
		
		return course;
	}
}