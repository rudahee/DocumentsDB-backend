package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Event;
import com.docdb.model.entity.dto.EventDTO;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class EventService extends BasePersistenceService<Event, EventDTO, Integer> {
			
	public EventService(BaseRepository<Event, Integer> baseRepository, DTOConverter<Event, EventDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
}
