package com.docdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Note;
import com.docdb.service.NoteService;

@RestController
@RequestMapping(path = "/note")
public class NoteController  extends BaseController<Note, NoteService> {


}