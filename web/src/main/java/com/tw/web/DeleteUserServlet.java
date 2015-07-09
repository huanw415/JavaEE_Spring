package com.tw.web;

import com.tw.service.UserService;
import com.tw.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hgwang on 7/8/15.
 */
public class DeleteUserServlet extends HttpServlet{

    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        UserService userService = new UserService();
        User user = userService.getUserById(id);
        userService.deleteUser(user);

        res.sendRedirect("/web/views/user");
    }
}

