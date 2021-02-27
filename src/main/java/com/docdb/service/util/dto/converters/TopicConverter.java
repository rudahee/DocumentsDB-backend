package com.docdb.service.util.dto.converters;

import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.TopicDTO;
import com.docdb.service.util.dto.DTOConverter;

public class TopicConverter extends DTOConverter<Topic, TopicDTO> {


	@Override
	public Topic fromDto(TopicDTO dto) {
		Topic topic= new Topic();
		
		topic.setDescription(dto.getDescription());
		topic.setName(dto.getName());
		
		return topic;
	}
	
	@Override
	public TopicDTO fromEntity(Topic topic) {
		TopicDTO dto = new TopicDTO();
		
		dto.setName(topic.getName());
		dto.setDescription(topic.getDescription());
		
		return dto;
	}

}
