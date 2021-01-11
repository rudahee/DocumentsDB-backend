package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Topic;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class TopicService extends BasePersistenceService<Topic, Integer> {
			
	public TopicService(BaseRepository<Topic, Integer> baseRepository) {
		super(baseRepository);
	}
}