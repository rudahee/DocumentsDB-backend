package com.docdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.Topic;
import com.docdb.service.TopicService;

@RestController
@RequestMapping(path = "/topic")
public class TopicController  extends BaseController<Topic, TopicService> {


}
