package com.docdb.model.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;

public class NoteDTO extends BaseDTO {

	@Override
	public String toString() {
		return "NoteDTO [description=" + description + ", text=" + text + ", name=" + name + ", documents=" + documents
				+ "]";
	}

	private String description;
	
	private List<String> text;
	private String name;
	private List<DocumentDTO> documents;
	
	public NoteDTO(String description, String text, String name) {
		super();
		this.description = description;
		this.text = new ArrayList<String>();
		this.name = name;
	}

	public NoteDTO() {
		super();
		this.text = new ArrayList<String>();

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTexts() {
		return text;
	}

	public void setTexts(List<String> text) {
		this.text = text;
	}
	
	public void addText(String text) {
		this.text.add(text);
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
}
