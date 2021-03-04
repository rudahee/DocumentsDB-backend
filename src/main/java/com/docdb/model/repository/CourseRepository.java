package com.docdb.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.docdb.model.entity.Course;
import com.docdb.model.entity.Customer;
import com.docdb.model.repository.base.BaseRepository;

@Repository
public interface CourseRepository extends BaseRepository<Course, Integer>{

	List<Course> findByCustomer(Customer customer);
}
