package com.docdb.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docdb.model.entity.Course;
import com.docdb.model.entity.Customer;
import com.docdb.model.repository.base.BaseRepository;

@Repository
public interface CourseRepository extends BaseRepository<Course, Integer>{

	List<Course> findByCustomer(Customer customer);
	
	@Query(value = "SELECT `course`.* "
			 + "FROM `user`, `customer`, `course` "
			 + "WHERE `user`.customer_id = `customer`.id "
			 + "AND `course`.customer_id = `customer`.id "
			 + "AND `user`.id = ?1", nativeQuery = true)
	List<Course> getCoursesFromUser(Integer idUser);
}
