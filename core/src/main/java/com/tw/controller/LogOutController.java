package com.tw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hgwang on 7/13/15.
 */

@Controller
@RequestMapping("/")
public class LogOutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().removeAttribute("current_user");
        return new ModelAndView("redirect:/login");
    }
}