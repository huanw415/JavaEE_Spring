package com.tw.controller;

import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hgwang on 7/9/15.
 */
@RestController
@RequestMapping("/views/")

public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getAllUsers(){
System.out.println("==============");
        ModelAndView modelAndView = new ModelAndView();

//
        modelAndView.setViewName("hello");
        modelAndView.addObject("name", "i am chinese !");

        return modelAndView;
    }
}