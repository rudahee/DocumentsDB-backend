package com.docdb.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Topic  extends BaseEntity {
	

	private String description;
	
	@ManyToMany(mappedBy = "topics")
	private List<Subject> subjects;

	@OneToMany(mappedBy="topic")
	private List<Note> notes;
	
	public Topic() {
		super();
		this.subjects = new ArrayList<Subject>();
		this.notes = new ArrayList<Note>(); 

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Topic [" + (super.getId() != null ? "id=" + super.getId() + ", " : "") 
				+ (super.getName() != null ? "name=" + super.getName() + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (subjects != null ? "subjects=" + subjects + ", " : "") 
				+ (notes != null ? "notes=" + notes : "")
				+ "]";
	}
	
	
}
