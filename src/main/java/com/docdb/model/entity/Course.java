package com.docdb.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Course extends BaseEntity {

	private Boolean open;
	private String name;
	private String description;
	
	private LocalDateTime lastModification;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
    @OneToMany(mappedBy="course")
    private List<Subject> subjects;
    
	public Course() {
		super();
	}

	public Course(Customer customer) {
		super();
		this.customer = customer ;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

	
