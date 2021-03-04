package com.docdb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.exception.AddException;
import com.docdb.model.entity.Course;
import com.docdb.model.entity.Customer;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.CustomerRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class CourseService extends BasePersistenceService<Course, CourseDTO, Integer> {
			
	public CourseService(BaseRepository<Course, Integer> baseRepository, DTOConverter<Course, CourseDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Transactional
	public Course save(String token, CourseDTO dto) throws AddException {
		Customer customer = jwtService.getUserFromToken(token).getCustomer();
		
		Course course = dtoConverter.fromDto(dto);

		if (dto.getDescription() == null || dto.getName().isBlank() || dto.getAcronym().isBlank()) {
			throw new AddException(ErrorCode.FIELD_IS_MISSING); 
		} else {
			if (customer == null) {
				throw new AddException(ErrorCode.INDETERMINATE_ERROR);
			} else {
				
				course.setCustomer(customer);
				customer.addCourse(course);
				baseRepository.save(course);
				customerRepository.save(customer);
			}
		}
		
		return course;
	}
	
	public List<Course> findAll(String token) {
		Customer customer = jwtService.getUserFromToken(token).getCustomer();
		
		return customer.getCourses();
	}
}