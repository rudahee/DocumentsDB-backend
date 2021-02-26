package com.docdb.model.entity.dto;

import java.sql.Blob;

public class DocumentDTO extends BaseDTO {

	private Blob data;
	private Long size;
	private String name;
	private String contentType;
	
	public DocumentDTO() {
		super();
	}
	
	public DocumentDTO(Blob data, Long size, String name, String contentType) {
		super();
		this.data = data;
		this.size = size;
		this.name = name;
		this.contentType = contentType;
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
}
