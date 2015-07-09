package com.tw.web;

import com.tw.entity.User;
import com.tw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hgwang on 7/8/15.
 */

public class CreateUserServlet extends HttpServlet {

    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));

        User user = new User();

        user.setAge(age);
        user.setGender(gender);
        user.setName(name);
        user.setEmail(email);

        new UserService().createUser(user);

        res.sendRedirect("/web/views/user");
    }
}