package com.docdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Document;
import com.docdb.service.DocumentService;

@RestController
@RequestMapping(path = "/document")
public class DocumentController  extends BaseController<Document, DocumentService> {


}