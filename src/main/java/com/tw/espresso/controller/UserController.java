package com.tw.espresso.controller;

import com.tw.espresso.model.User;
import com.tw.espresso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToHomePage() {
        //userService.createUser(new User());
        return "index";
    }
}
