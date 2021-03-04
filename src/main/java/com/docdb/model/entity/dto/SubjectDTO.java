package com.docdb.model.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SubjectDTO extends BaseDTO {

	private String name;
	private String acronym;
	private List<TopicDTO> topicsDTO;
	
	public SubjectDTO() {
		super();
		this.topicsDTO = new ArrayList<TopicDTO>();
	}
	
	public SubjectDTO(String name, String acronym) {
		super();
		this.topicsDTO = new ArrayList<TopicDTO>();
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

	public List<TopicDTO> getTopics() {
		return topicsDTO;
	}

	public void setTopics(List<TopicDTO> topics) {
		this.topicsDTO = topics;
	}
	
	public void addTopic(TopicDTO topic) {
		this.topicsDTO.add(topic);
	}
	
}
