package com.tw.controller;

import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hgwang on 7/12/15.
 */

@Controller
@RequestMapping("/")
public class LogInController {
    private UserService userService;

    @Autowired
    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView getLoginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logIn");

        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView getLogInMessage(HttpServletRequest request,@RequestParam String name,
                                        @RequestParam String password){

        List<User> users = userService.getUsersByName(name);

        User currentUser = users.get(0);
        if(users.size() != 0){
            String logInMessage = userService.canLogIn(currentUser, password);

            if(logInMessage == "密码正确"){
                request.getSession().setAttribute("current_user", currentUser);
                return new ModelAndView("redirect:/user");
            }else {
                return new ModelAndView("redirect:/userError");
            }

        }else {
            return new ModelAndView("redirect:/userError");
        }
    }

    @RequestMapping("/userError")
    public ModelAndView getUserError(){
        return new ModelAndView("userError");
    }
}
