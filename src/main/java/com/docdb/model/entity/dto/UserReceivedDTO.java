package com.docdb.model.entity.dto;

import java.util.Set;

import com.docdb.model.enumerated.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserReceivedDTO {

	private String name;
	private String surname;
	private Integer age;
	
	private String username;
	private String password;
	private String email;
	
	public UserReceivedDTO() {
		super();
	}

	public UserReceivedDTO(String name, String surname, Integer age, String username, String password, String email,
			Set<UserRole> roles) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
