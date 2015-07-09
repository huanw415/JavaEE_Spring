package com.tw.web;

import com.tw.service.UserService;
import com.tw.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hgwang on 7/8/15.
 */
public class UpdateUserServlet extends HttpServlet {
    private int id;
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));

        UserService userService = new UserService();
        User user = userService.getUserById(id);

        req.setAttribute("user", user);

        RequestDispatcher de=req.getRequestDispatcher("/views/updateUser.jsp");
        de.forward(req, res);
    }

    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));

        User user = new User();

        user.setId(id);
        user.setAge(age);
        user.setGender(gender);
        user.setName(name);
        user.setEmail(email);

        new UserService().updateUser(user);

        res.sendRedirect("/web/views/user");
    }
}
