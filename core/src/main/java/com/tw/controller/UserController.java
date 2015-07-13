package com.tw.controller;

import com.tw.Util.Md5Util;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hgwang on 7/9/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Boolean isLogIn(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(HttpServletRequest request){

        if(isLogIn(request)){
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.setViewName("users");
            modelAndView.addObject("users", userService.getAllUsers());

            return modelAndView;
        }else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/userCreation", method = RequestMethod.GET)
    public ModelAndView getCreateUserPage(HttpServletRequest request){

        if(isLogIn(request)){
            return new ModelAndView("createUser");
        }else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/userCreation", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam int age){

        User user = new User(name, gender, email, age, Md5Util.md5(password));
        userService.createUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/userDeletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id){

        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserAge(HttpServletRequest request, @PathVariable int id){

        if(isLogIn(request)){
            User user = userService.getUserById(id);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("updateUser");
            modelAndView.addObject("user", user);

            return modelAndView;
        }else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@RequestParam String name,
                                @PathVariable int id,
                                @RequestParam String gender,
                                @RequestParam String email,
                                @RequestParam int age,
                                @RequestParam String password){
        User user = new User(id, name, gender, email, age, Md5Util.md5(password));
        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }
}