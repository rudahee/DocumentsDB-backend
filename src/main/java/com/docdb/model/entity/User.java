package com.docdb.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class User extends BaseEntity {
	
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	
	private String token;
	private LocalDateTime lastLogin;	
	
	@OneToOne
    @JoinColumn(name="image_id")
	private Document image;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_course",
		joinColumns = @JoinColumn(name="course_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id"))
	private List<Course> courses;

	public User() {
		super();
		this.token = UUID.randomUUID().toString();
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Document getImage() {
		return image;
	}
	
	public void setImage(Document image) {
		this.image = image;
	}
	
	public void generateLastLogin() {
		this.lastLogin = LocalDateTime.now();
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	
	public String getToken() {
		return token;
	}
	
	@Override
	public String toString() {
		return "User [" + (super.getId() != null ? "id=" + super.getId() + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") 
				+ (super.getName() != null ? "name=" + super.getName() + ", " : "")
				+ (token != null ? "token=" + token + ", " : "")
				+ (lastLogin != null ? "lastLogin=" + lastLogin + ", " : "")
				+ (courses != null ? "course=" + courses : "") + "]";
	}


	
	
	
}
