package com.docdb.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Course extends BaseEntity {

	private Boolean open;
	private String description;
	
	private LocalDateTime lastModification;

	@ManyToMany(mappedBy="courses")
	private List<User> users;
	
    @OneToMany(mappedBy="course")
    private List<Subject> subjects;
	
	
	public Course() {
		super();
		users = new ArrayList<User>();
		subjects = new ArrayList<Subject>();
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getLastModification() {
		return lastModification;
	}

	public void setLastModification(LocalDateTime lastModification) {
		this.lastModification = lastModification;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Course [" + (super.getId() != null ? "id=" + super.getId() + ", " : "")
				+ (open != null ? "open=" + open + ", " : "")
				+ (super.getName() != null ? "name=" + super.getName() + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (lastModification != null ? "lastModification=" + lastModification + ", " : "")
				+ (users != null ? "users=" + users + ", " : "") 
				+ (subjects != null ? "subjects=" + subjects : "")
				+ "]";
	}
	
	
}

	
