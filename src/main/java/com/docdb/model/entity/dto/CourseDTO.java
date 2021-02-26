package com.docdb.model.entity.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CourseDTO extends BaseDTO {
	private Boolean open;
	private String name;
	private String description;
	
	private LocalDateTime lastModification;
	
	public CourseDTO() {
		super();
	}

	public CourseDTO(Boolean open, String name, String description, LocalDateTime lastModification) {
		super();
		this.open = open;
		this.name = name;
		this.description = description;
		this.lastModification = lastModification;
	}

	public Boolean getOpen() {
		return open;
	}

	@Override
	public String toString() {
		return "CourseDTO [open=" + open + ", name=" + name + ", description=" + description + ", lastModification="
				+ lastModification + "]";
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
