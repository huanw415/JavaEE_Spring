package com.tw.controller;

import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hgwang on 7/9/15.
 */
@RestController
@RequestMapping("/")

public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getAllUsers(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user");
        modelAndView.addObject("users", userService.getAllUsers());

        return modelAndView;
    }

    @RequestMapping(value = "/userCreation", method = RequestMethod.GET)
    public ModelAndView getCreateUserPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createUser");

        return modelAndView;
    }

    @RequestMapping(value = "/userCreation", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam String email,
                                   @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setGender(gender);
        user.setEmail(email);
        user.setAge(age);

        userService.createUser(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("users", userService.getAllUsers());

        return modelAndView;
    }
}