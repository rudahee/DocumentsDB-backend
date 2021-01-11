package com.docdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Course;
import com.docdb.service.CourseService;

@RestController
@RequestMapping(path = "/course")
public class CourseController  extends BaseController<Course, CourseService> {


}