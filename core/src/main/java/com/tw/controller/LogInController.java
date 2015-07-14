package com.tw.controller;

import com.tw.Util.Md5Util;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(HttpServletRequest request) {
//        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^");
//        Cookie[] cookies = request.getCookies();
//
//        for(int i=0; i<cookies.length; i++){
//            if(cookies[i].getName().equals("previous_page")){
//                System.out.println(cookies[i].getValue());
//            }
//        }
//        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logIn");

        return modelAndView;
    }

    public String getPreviousPage(HttpServletRequest request){
        String previousPage = "users";
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++) {
            if (cookies[i].getName().equals("previous_page")) {
                previousPage = cookies[i].getValue();
            }
        }
//        if(previousPage.equals("")){
//            previousPage = "users";
//        }
        return previousPage;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLogInMessage(HttpServletRequest request, @RequestParam String name,
                                        @RequestParam String password, HttpServletResponse response) throws NoSuchAlgorithmException {

        List<User> users = userService.getUsersByName(name);

        if (users.size() != 0) {
            User currentUser = users.get(0);
            String logInMessage = userService.canLogIn(currentUser, Md5Util.md5(password));
            if (logInMessage == "密码正确") {
                Cookie cookie = new Cookie("current_user", currentUser.getName());
                response.addCookie(cookie);

                String previousPage =getPreviousPage(request);

                return new ModelAndView("redirect:/" + previousPage);
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
