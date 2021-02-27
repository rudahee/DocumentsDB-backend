package com.docdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Event;
import com.docdb.model.entity.dto.EventDTO;
import com.docdb.service.EventService;

@RestController
@RequestMapping(path = "/event")
public class EventController  extends BaseController<Event, EventDTO, EventService> {


}

