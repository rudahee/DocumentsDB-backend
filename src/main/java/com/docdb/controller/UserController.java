package com.docdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdb.controller.base.BaseController;
import com.docdb.model.entity.User;
import com.docdb.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends BaseController<User, UserService> {


}
