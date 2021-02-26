package com.docdb.service.util.dto.converters;

import com.docdb.model.entity.Subject;
import com.docdb.model.entity.dto.SubjectDTO;
import com.docdb.service.util.dto.DTOConverter;

public class SubjectConverter extends DTOConverter<Subject, SubjectDTO> {
	
	@Override
	public Subject fromDto(SubjectDTO dto) {
		Subject subject = new Subject();
		
		subject.setAcronym(dto.getAcronym());
		subject.setName(dto.getName());
		
		return subject;
	}
	
	@Override
	public SubjectDTO fromEntity(Subject subject) {
		SubjectDTO dto = new SubjectDTO();
		
		dto.setAcronym(subject.getAcronym());
		dto.setName(subject.getName());
		
		return dto;
	}
}
