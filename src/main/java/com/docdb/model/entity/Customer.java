package com.docdb.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.docdb.model.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
public class Customer extends BaseEntity {
	
	@OneToOne(mappedBy = "customer")
	private User user;
	
	@OneToOne
    @JoinColumn(name="image_id")
	private Document image;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_course",
		joinColumns = @JoinColumn(name="course_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="customer_id", referencedColumnName="id"))
	private List<Course> courses;
	
	public Customer() {
		super();
		this.courses = new ArrayList<Course>();
	}

	public Customer(User user) {
		super();
		this.user = user;
		this.courses = new ArrayList<Course>();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Document getImage() {
		return image;
	}

	public void setImage(Document image) {
		this.image = image;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}	
}
