package com.docdb.model.entity.dto;

import java.util.ArrayList;
import java.util.List;

public class TopicDTO extends BaseDTO{

	@Override
	public String toString() {
		return "TopicDTO [name=" + name + ", description=" + description + ", notes=" + notes + "]";
	}

	private String name;
	private String description;
	private List<NoteDTO> notes;
	
	public TopicDTO() {
		super();
		this.notes = new ArrayList<NoteDTO>();
	}
	
	public TopicDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.notes = new ArrayList<NoteDTO>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<NoteDTO> getNotesDTO() {
		return notes;
	}

	public void setNotes(List<NoteDTO> notes) {
		this.notes = notes;
	}
	
	
}
