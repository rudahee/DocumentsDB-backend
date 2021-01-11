package com.docdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Subject;
import com.docdb.service.SubjectService;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController extends BaseController<Subject, SubjectService> {


}