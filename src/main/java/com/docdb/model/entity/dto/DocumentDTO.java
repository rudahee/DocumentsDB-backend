package com.docdb.model.entity.dto;

import java.sql.Blob;

public class DocumentDTO extends BaseDTO {

	private String path;
	
	private Long size;
	private String name;
	private String contentType;
	
	public DocumentDTO() {
		super();
	}
	
	public DocumentDTO(Long size, String name, String contentType) {
		super();
		this.size = size;
		this.name = name;
		this.contentType = contentType;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
