package com.tw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hgwang on 7/9/15.
 */
@Controller
public class SampleController {

    @RequestMapping("home")
    public ModelAndView loadHomePage() {

        return new ModelAndView("home");
    }
}
