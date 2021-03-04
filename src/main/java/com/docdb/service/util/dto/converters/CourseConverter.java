package com.docdb.service.util.dto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.Course;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class CourseConverter extends DTOConverter<Course, CourseDTO> {

	@Autowired
	private SubjectConverter subjectConverter;
	
	@Override
	public CourseDTO fromEntity(Course course) {
		CourseDTO courseDto = new CourseDTO(course.getId(), course.getOpen(), course.getAcronym(), course.getName(), course.getDescription(), course.getLastModification());
		
		courseDto.setSubjectDTO(subjectConverter.fromEntities(course.getSubjects()));

		return courseDto;
	}
	
	@Override
	public Course fromDto(CourseDTO dto) {
		Course course = new Course();
		
		course.setAcronym(dto.getAcronym());
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		course.setOpen(dto.getOpen());
		
		return course;
	}

}
