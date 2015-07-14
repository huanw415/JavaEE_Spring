package com.tw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hgwang on 7/13/15.
 */

@Controller
@RequestMapping("/")
public class LogOutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response) {
        Cookie usercookie = new Cookie("current_user", null);
        usercookie.setMaxAge(0);
        response.addCookie(usercookie);

        Cookie pageCookie = new Cookie("previous_page", null);
        pageCookie.setMaxAge(0);
        response.addCookie(pageCookie);

        return new ModelAndView("redirect:/login");
    }
}