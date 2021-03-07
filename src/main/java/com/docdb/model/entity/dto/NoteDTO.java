package com.docdb.model.entity.dto;

import java.util.List;

public class NoteDTO extends BaseDTO {

	private String description;
	
	private String text;
	private String name;
	private List<DocumentDTO> documents;
	
	public NoteDTO(String description, String text, String name) {
		super();
		this.description = description;
		this.name = name;
	}

	public NoteDTO() {
		super();

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentDTO> documents) {
		this.documents = documents;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	
}
