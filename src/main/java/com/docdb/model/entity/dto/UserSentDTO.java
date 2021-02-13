package com.docdb.model.entity.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.docdb.model.enumerated.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserSentDTO {

	private String name;
	private String surname;
	private Integer age;
	
	private String username;
	private String password;
	private String email;
		
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
		
	private LocalDateTime lastPasswordChange;
	private LocalDateTime nextPasswordChange;
	
	private Set<UserRole> roles;
	
	public UserSentDTO() {
		super();
	}

	public UserSentDTO(String name, String surname, Integer age, String username, String password, String email,
			LocalDateTime createTime, LocalDateTime updateTime, LocalDateTime lastPasswordChange,
			LocalDateTime nextPasswordChange, Set<UserRole> roles) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.lastPasswordChange = lastPasswordChange;
		this.nextPasswordChange = nextPasswordChange;
		this.roles = roles;
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

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public LocalDateTime getNextPasswordChange() {
		return nextPasswordChange;
	}

	public void setNextPasswordChange(LocalDateTime nextPasswordChange) {
		this.nextPasswordChange = nextPasswordChange;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
}
