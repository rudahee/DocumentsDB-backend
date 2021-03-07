package com.docdb.service.util.dto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdb.model.entity.Note;
import com.docdb.model.entity.dto.NoteDTO;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class NoteConverter extends DTOConverter<Note, NoteDTO> {

	@Autowired
	private DocumentConverter documentConverter;
	
	@Override
	public Note fromDto(NoteDTO dto) {
		Note note = new Note();
		
		note.setDescription(dto.getDescription());
		note.setName(dto.getName());
		note.setTexts(dto.getTexts());
		
		return note;
	}

	@Override
	public NoteDTO fromEntity(Note entity) {
		NoteDTO dto = new NoteDTO();
		
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setTexts(entity.getTexts());
		dto.setDocuments(documentConverter.fromEntities(entity.getDocuments()));
		
		return dto;
	}

}
