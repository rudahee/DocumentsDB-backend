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

	private Blob data;
	private Long size;
	private String name;
	private String contentType;

	
	@ManyToOne(optional=true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="note_id")
	private Note note;
	
    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
	private Customer customer;
	
	public Document() {
		super();
	}

	public Blob getData() {
		return data;
	}

	public void setData(Blob data) {
		this.data = data;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
