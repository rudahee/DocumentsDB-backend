package com.docdb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.exception.AddException;
import com.docdb.model.entity.Subject;
import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.TopicDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class TopicService extends BasePersistenceService<Topic, TopicDTO, Integer> {
			
	public TopicService(BaseRepository<Topic, Integer> baseRepository) {
		super(baseRepository);
	}
	
	@Autowired
	private SubjectService subjectService;
	
	@Transactional
	public Topic save(Integer id, TopicDTO dto) throws AddException {
		
		Subject subject = subjectService.find(id);
		Topic topic;
		
		if (dto.getName().isBlank()) {
			throw new AddException(ErrorCode.FIELD_IS_MISSING); 
		} else {
			if (subject == null) {
				throw new AddException(ErrorCode.INDETERMINATE_ERROR);
			} else {
				topic = dtoConverter.fromEntity(dto);			
				
				topic.addSubject(subject);
				subject.addTopic(topic);
			}
		}
		
		return topic;
	}
}