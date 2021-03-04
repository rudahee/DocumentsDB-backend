package com.docdb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.exception.AddException;
import com.docdb.model.entity.Note;
import com.docdb.model.entity.Topic;
import com.docdb.model.entity.dto.NoteDTO;
import com.docdb.model.enumerated.ErrorCode;
import com.docdb.model.repository.TopicRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class NoteService extends BasePersistenceService<Note, NoteDTO, Integer> {
			
	public NoteService(BaseRepository<Note, Integer> baseRepository, DTOConverter<Note, NoteDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Transactional
	public Note save(Integer id, NoteDTO dto) throws AddException {
		
		Topic topic = topicRepository.findById(id).get();
		Note note;
		
		if (dto.getName().isBlank()) {
			throw new AddException(ErrorCode.FIELD_IS_MISSING); 
		} else {
			if (topic == null) {
				throw new AddException(ErrorCode.INDETERMINATE_ERROR);
			} else {
				note = dtoConverter.fromDto(dto);			
				
				note.setTopic(topic);
				topic.addNote(note);
				
				baseRepository.save(note);
				topicRepository.save(topic);
			}
		}
		
		return note;
	}


}
