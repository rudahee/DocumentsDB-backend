package com.docdb.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Note extends BaseEntity {
	
	private String description;
	private String text;
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="topic_id")
	private Topic topic;
	
    @OneToMany(mappedBy="note")
	private List<Document> documents;
	
    @OneToMany(mappedBy="note")
	private List<Document> images;
	
	public Note() {
		super();
		documents = new ArrayList<Document>();
		images = new ArrayList<Document>();
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

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<Document> getImages() {
		return images;
	}

	public void setImages(List<Document> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Note [" + (super.getId() != null ? "id=" + super.getId() + ", " : "") 
				+ (super.getName() != null ? "name=" + super.getName() + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (text != null ? "text=" + text + ", " : "")
				+ (documents != null ? "documents=" + documents + ", " : "")
				+ (images != null ? "images=" + images : "") + "]";
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	
	
}
