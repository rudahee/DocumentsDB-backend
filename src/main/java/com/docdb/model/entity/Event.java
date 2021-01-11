package com.docdb.model.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Event extends BaseEntity {
	
	private String description;
	private Boolean done;
	private LocalDateTime time;
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Subject subject;

	public Event() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Event [" + (super.getId() != null ? "id=" + super.getId() + ", " : "") 
				+ (super.getName() != null ? "name=" + super.getName() + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (done != null ? "done=" + done + ", " : "") 
				+ (subject != null ? "subject=" + subject : "") + "]";
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	

}
