package com.tw.controller;

import org.springframework.ui.Model;
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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody
    String showHomePage(Model m) {
        m.addAttribute("name", "Hello");
        return "hello";
    }
}
