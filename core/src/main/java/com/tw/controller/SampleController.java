package com.tw.controller;

import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hgwang on 7/9/15.
 */
@RestController
@RequestMapping("/")
public class SampleController {

    private UserService userService;

    public SampleController() {
    }

    @Autowired
    public SampleController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody
    String showHomePage() {

//        m.addAttribute("name", userService.getUserById(1).getAge());
        return userService.getUserById(1).getEmail();
    }
}
