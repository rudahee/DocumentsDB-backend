package com.docdb.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SubjectDTO extends BaseDTO {

	private String name;
	private String acronym;
	
	public SubjectDTO() {
		super();
	}
	
	public SubjectDTO(String name, String acronym) {
		super();
		this.name = name;
		this.acronym = acronym;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAcronym() {
		return acronym;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
}
