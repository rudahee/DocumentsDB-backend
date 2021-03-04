package com.docdb.service.util.dto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.TopicDTO;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class TopicConverter extends DTOConverter<Topic, TopicDTO> {	
	
	@Autowired
	private NoteConverter noteConverter;
	
	@Override
	public Topic fromDto(TopicDTO dto) {
		Topic topic= new Topic();
		
		topic.setDescription(dto.getDescription());
		topic.setName(dto.getName());
		
		return topic;
	}
	
	public TopicDTO fromEntityWithNote(Topic topic) {
		TopicDTO dto = new TopicDTO();
		
		dto.setId(topic.getId());
		dto.setName(topic.getName());
		dto.setDescription(topic.getDescription());
		dto.setNotes(noteConverter.fromEntities(topic.getNotes()));
		return dto;
	}
	
	@Override
	public TopicDTO fromEntity(Topic topic) {
		TopicDTO dto = new TopicDTO();
		
		dto.setId(topic.getId());
		dto.setName(topic.getName());
		dto.setDescription(topic.getDescription());
		
		return dto;
	}

}
