package com.tw.controller;

import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
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
                                   @RequestParam int age,
                                   @RequestParam String password){

        User user = new User(name, gender, email, age, password);

        userService.createUser(user);

        return new ModelAndView("redirect:/user");
    }

    @RequestMapping(value = "/userDelete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int id){

        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return new ModelAndView("redirect:/user");
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
    public ModelAndView getUpdateUserAge(@RequestParam int id){
        User user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@RequestParam String name,
                                @RequestParam int id,
                                @RequestParam String gender,
                                @RequestParam String email,
                                @RequestParam int age,
                                @RequestParam String password){
        User user = new User(id, name, gender, email, age, password);
        userService.updateUser(user);

        return new ModelAndView("redirect:/user");
    }
}