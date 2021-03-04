package com.docdb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.exception.AddException;
import com.docdb.model.entity.Subject;
import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.TopicDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.SubjectRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class TopicService extends BasePersistenceService<Topic, TopicDTO, Integer> {
			
	public TopicService(BaseRepository<Topic, Integer> baseRepository, DTOConverter<Topic, TopicDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Transactional
	public Topic save(Integer id, TopicDTO dto) throws AddException {
		
		Subject subject = subjectRepository.findById(id).get();
		Topic topic;
		
		if (dto.getName().isBlank()) {
			throw new AddException(ErrorCode.FIELD_IS_MISSING); 
		} else {
			if (subject == null) {
				throw new AddException(ErrorCode.INDETERMINATE_ERROR);
			} else {
				topic = dtoConverter.fromDto(dto);			
				
				topic.addSubject(subject);
				subject.addTopic(topic);
				
				baseRepository.save(topic);
				subjectRepository.save(subject);
			}
		}
		
		return topic;
	}

}