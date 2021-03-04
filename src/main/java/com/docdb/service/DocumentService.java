package com.docdb.service;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Document;
import com.docdb.model.entity.dto.DocumentDTO;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class DocumentService extends BasePersistenceService<Document, DocumentDTO, Integer> {
			
	public DocumentService(BaseRepository<Document, Integer> baseRepository, DTOConverter<Document, DocumentDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
}