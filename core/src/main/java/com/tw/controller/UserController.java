package com.tw.controller;

import com.tw.Util.Md5Util;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hgwang on 7/9/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private ModelAndView createModelAndView(String viewName, String objectName, Object objectValue){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(viewName);
        modelAndView.addObject(objectName, objectValue);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers() {

            return createModelAndView("users", "users", userService.getAllUsers());
    }

    @RequestMapping(value = "/creation", method = RequestMethod.GET)
    public ModelAndView getCreateUserPage() {

            return new ModelAndView("createUser");
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam int age){

        User user = new User(name, gender, email, age, Md5Util.md5(password));
        userService.createUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/deletion/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {

        User user = userService.getUserById(id);
        userService.deleteUser(user);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserAge(@PathVariable int id) {

            User user = userService.getUserById(id);
            return createModelAndView("updateUser", "user", user);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@PathVariable int id,
                                   @RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam String email,
                                   @RequestParam int age,
                                   @RequestParam String password){
        User user = new User(id, name, gender, email, age, Md5Util.md5(password));
        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }
}