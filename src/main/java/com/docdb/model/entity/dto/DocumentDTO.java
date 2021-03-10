package com.docdb.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DocumentDTO extends BaseDTO {

	private String path;
	
	private Long size;
	private String name;
	private String contentType;
	private String extension;
	private Boolean isBlob;
	
	public DocumentDTO() {
		super();
	}
	
	public DocumentDTO(Long size, String name) {
		super();
		this.size = size;
		this.name = name;
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

	public Boolean getIsBlob() {
		return isBlob;
	}

	public void setIsBlob(Boolean isBlob) {
		this.isBlob = isBlob;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
