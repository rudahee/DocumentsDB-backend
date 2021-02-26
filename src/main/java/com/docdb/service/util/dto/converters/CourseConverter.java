package com.docdb.service.util.dto.converters;

import com.docdb.model.entity.Course;
import com.docdb.model.entity.dto.CourseDTO;
import com.docdb.service.util.dto.DTOConverter;

public class CourseConverter extends DTOConverter<Course, CourseDTO> {

	@Override
	public CourseDTO fromEntity(Course course) {
		return new CourseDTO(course.getOpen(), course.getName(), course.getDescription(), course.getLastModification());
	}
	
	@Override
	public Course fromDto(CourseDTO dto) {
		Course course = new Course();
		
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		course.setOpen(dto.getOpen());
		
		return course;
	}

}
