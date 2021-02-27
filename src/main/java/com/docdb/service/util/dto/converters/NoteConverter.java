package com.docdb.service.util.dto.converters;

import com.docdb.model.entity.Note;
import com.docdb.model.entity.dto.NoteDTO;
import com.docdb.service.util.dto.DTOConverter;

public class NoteConverter extends DTOConverter<Note, NoteDTO> {

	@Override
	public Note fromDto(NoteDTO dto) {
		Note note = new Note();
		
		note.setDescription(dto.getDescription());
		note.setName(dto.getName());
		note.setText(dto.getText());
		
		return note;
	}

	@Override
	public NoteDTO fromEntity(Note entity) {
		NoteDTO dto = new NoteDTO();
		
		dto.setDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setText(entity.getText());
		
		return dto;
	}

}
