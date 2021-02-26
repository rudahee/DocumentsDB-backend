package com.docdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.Course;
import com.docdb.model.entity.Subject;
import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.SubjectDTO;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class TopicService extends BasePersistenceService<Topic, Integer> {
			
	public TopicService(BaseRepository<Topic, Integer> baseRepository) {
		super(baseRepository);
	}
	
	@Autowired
	private SubjectService subjectService;
	/*
	public Topic addTopic (Integer idCourse, Topic dto) {
		Subject subject = this.subjectService.find(idCourse);
		
		Topic topic = dtoConverter.fromSubjectDTOToSubject(dto);
		
		topic.addSubject(subject);
		
		subject.addTopic(topic);
		
		subjectService.save(course);
		return baseRepository.save(subject);
	}
	 */
}