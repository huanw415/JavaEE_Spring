package com.tw.controller;

import com.tw.Util.Md5Util;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by hgwang on 7/12/15.
 */

@Controller
@RequestMapping("/")
public class LogInController {

    @Autowired
    private UserService userService;

    private String getPreviousPageUrl(String previousUrl){
        String previousPageUrl = "users";
        if(!previousUrl.equals("")){
            previousPageUrl = previousUrl;
        }
        return previousPageUrl;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logIn");

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLogInMessage(@CookieValue(value = "previous_page", defaultValue = "") String previousUrl,
                                        @RequestParam String name,
                                        @RequestParam String password,
                                        HttpServletResponse response) throws NoSuchAlgorithmException {

        List<User> users = userService.getUsersByName(name);

        if (users.size() != 0) {
            User currentUser = users.get(0);
            String logInMessage = userService.canLogIn(currentUser, Md5Util.md5(password));

            if (logInMessage == "密码正确") {
                Cookie cookie = new Cookie("current_user", currentUser.getName());
                response.addCookie(cookie);

                return new ModelAndView("redirect:/" + getPreviousPageUrl(previousUrl));
            } else {
                return new ModelAndView("redirect:/userError");
            }

        } else {
            return new ModelAndView("redirect:/userError");
        }
    }

    @RequestMapping("/userError")
    public ModelAndView getUserError() {
        return new ModelAndView("userError");
    }
}
