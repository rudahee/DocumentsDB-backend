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
	private List<Customer> customers;
	
    @OneToMany(mappedBy="course")
    private List<Subject> subjects;
	
	
	public Course() {
		super();
		customers = new ArrayList<Customer>();
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

	public List<Customer> getUsers() {
		return customers;
	}

	public void setUsers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}

	
