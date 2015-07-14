package com.tw.controller;

import com.tw.Util.Md5Util;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hgwang on 7/9/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController() {
    }

    private ModelAndView createModelAndView(String viewName, String objectName, Object objectValue){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(viewName);
        modelAndView.addObject(objectName, objectValue);

        return modelAndView;
    }

    private Cookie deletePreviousPageCookie(){
        Cookie pageCookie = new Cookie("previous_page", null);
        pageCookie.setMaxAge(0);
        return pageCookie;
    }

    private Cookie createPreviousPageCookie(String cookieValue){
        Cookie cookie = new Cookie("previous_page", cookieValue);
        cookie.setPath("/");

        return cookie;
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Boolean isLogIn(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        for(int i=0; i<cookies.length; i++){
            if(cookies[i].getName().equals("current_user")){
                return true;
            }
        }

        return false;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(HttpServletRequest request, HttpServletResponse response) {

        if (isLogIn(request)) {

            return createModelAndView("users", "users", userService.getAllUsers());
        } else {

            response.addCookie(deletePreviousPageCookie());
            response.addCookie(createPreviousPageCookie("users"));

            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/creation", method = RequestMethod.GET)
    public ModelAndView getCreateUserPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (isLogIn(request)) {

            return new ModelAndView("createUser");
        } else {

            response.addCookie(deletePreviousPageCookie());
            response.addCookie(createPreviousPageCookie("users/creation"));

            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam int age) throws Exception {

        User user = new User(name, gender, email, age, Md5Util.md5(password));
        userService.createUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {

        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserAge(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {

        if (isLogIn(request)) {

            User user = userService.getUserById(id);

            return createModelAndView("updateUser", "user", user);
        } else {

            response.addCookie(deletePreviousPageCookie());
            response.addCookie(createPreviousPageCookie("users/update/"+id));

            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@PathVariable int id,
                                   @RequestParam String name,
                                   @RequestParam String gender,
                                   @RequestParam String email,
                                   @RequestParam int age,
                                   @RequestParam String password) throws NoSuchAlgorithmException {
        User user = new User(id, name, gender, email, age, Md5Util.md5(password));
        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }
}