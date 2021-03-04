package com.docdb.service.util.dto.converters;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Event;
import com.docdb.model.entity.dto.EventDTO;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class EventConverter extends DTOConverter<Event, EventDTO> {

	@Override
	public Event fromDto(EventDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventDTO fromEntity(Event entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
