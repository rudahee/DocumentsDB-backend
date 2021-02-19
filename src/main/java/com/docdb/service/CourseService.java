package com.docdb.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.Course;
import com.docdb.model.entity.Customer;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.DTOConverter;

@Service
public class CourseService extends BasePersistenceService<Course, Integer> {
			
	public CourseService(BaseRepository<Course, Integer> baseRepository) {
		super(baseRepository);
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DTOConverter dtoConverter;
	
	
	public Course addCourse(Integer id, CourseDTO dto) {
		Customer customer = this.userService.getUserById(id).getCustomer();
		
		Course course = dtoConverter.fromCourseDTOToCourse(dto);
		
		course.setLastModification(LocalDateTime.now());
		course.setCustomer(customer);
		
		customer.addCourse(course);
		
		customerService.save(customer);
		return baseRepository.save(course);
	}
}