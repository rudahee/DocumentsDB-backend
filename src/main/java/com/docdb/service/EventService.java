package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Event;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class EventService extends BasePersistenceService<Event, Integer> {
			
	public EventService(BaseRepository<Event, Integer> baseRepository) {
		super(baseRepository);
	}
}
