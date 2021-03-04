package com.docdb.model.entity.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CourseDTO extends BaseDTO {
	private Boolean open;
	private String name;
	private String description;
	private String acronym;
	
	private List<SubjectDTO> subjectsDTO;
	
	private LocalDateTime lastModification;
	

	public CourseDTO(Integer id, Boolean open, String acronym, String name, String description, LocalDateTime lastModification) {
		super(id);
		this.open = open;
		this.name = name;
		this.acronym = acronym;
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public List<SubjectDTO> getSubjectsDTO() {
		return subjectsDTO;
	}

	public void setSubjectDTO(List<SubjectDTO> subjectsDTO) {
		this.subjectsDTO = subjectsDTO;
	}
	
	
}
