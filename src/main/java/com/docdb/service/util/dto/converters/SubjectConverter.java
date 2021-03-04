package com.docdb.service.util.dto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.Subject;
import com.docdb.model.entity.dto.SubjectDTO;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class SubjectConverter extends DTOConverter<Subject, SubjectDTO> {
	
	@Autowired
	private TopicConverter topicConverter;
	
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
		
		dto.setId(subject.getId());
		dto.setAcronym(subject.getAcronym());
		dto.setName(subject.getName());

		dto.setTopics(topicConverter.fromEntities(subject.getTopics()));
		
		return dto;
	}
}
