package com.docdb.service.util.dto.converters;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Document;
import com.docdb.model.entity.dto.DocumentDTO;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class DocumentConverter extends DTOConverter<Document, DocumentDTO> {

	@Override
	public Document fromDto(DocumentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDTO fromEntity(Document entity) {
		DocumentDTO dto = new DocumentDTO();
		dto.setContentType(entity.getContentType());
		dto.setName(entity.getName());
		dto.setPath(entity.getPath());
		dto.setSize(entity.getSize());
		
		return dto;
	}

}
