package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Note;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;

@Service
public class NoteService extends BasePersistenceService<Note, Integer> {
			
	public NoteService(BaseRepository<Note, Integer> baseRepository) {
		super(baseRepository);
	}
}