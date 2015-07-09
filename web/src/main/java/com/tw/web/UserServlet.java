package com.tw.web;

import com.tw.service.UserService;
import com.tw.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hgwang on 7/8/15.
 */
public class UserServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setCharacterEncoding("UTF-8");
        res.setHeader("content-type","text/html;charset=UTF-8");

        List<User> users = new UserService().getAllUsers();
        req.setAttribute("users", users);

        RequestDispatcher de=req.getRequestDispatcher("/views/user.jsp");
        de.forward(req, res);
    }
}
