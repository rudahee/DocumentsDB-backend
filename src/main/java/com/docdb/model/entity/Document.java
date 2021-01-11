package com.docdb.model.entity;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Document extends BaseEntity {

	private Blob image;
	private Integer size;
	
	@ManyToOne(optional=true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="note_id")
	private Note note;
	
    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
	private User user;
	
	public Document() {
		super();
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Integer getFileSize() {
		return size;
	}

	public void setFileSize(Integer fileSize) {
		this.size = fileSize;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}
}
