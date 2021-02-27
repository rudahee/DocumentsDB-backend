package com.docdb.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Subject extends BaseEntity {
	
	private LocalDateTime lastModification;
	private String name;
	private String acronym;
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;
	
    @OneToMany(mappedBy="subject")
	private List<Event> events;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "subject_topic",
		joinColumns = @JoinColumn(name="subject_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="topic_id", referencedColumnName="id"))
	private List<Topic> topics;
	
	public Subject() {
		super();
		this.events = new ArrayList<Event>();
		this.topics = new ArrayList<Topic>();
	}

	public LocalDateTime getLastModification() {
		return lastModification;
	}

	public void setLastModification(LocalDateTime lastModification) {
		this.lastModification = lastModification;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public void addTopic(Topic topic) {
		this.topics.add(topic);
	}
	
	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
