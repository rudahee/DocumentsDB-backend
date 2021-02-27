package com.docdb.model.entity.dto;

public class NoteDTO extends BaseDTO {

	private String description;
	private String text;
	private String name;
	
	public NoteDTO(String description, String text, String name) {
		super();
		this.description = description;
		this.text = text;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
