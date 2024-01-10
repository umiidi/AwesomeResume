package com.company.resumewebapp.controller;

import dao.inter.UserDaoInter;
import entity.User;
import main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/users")
public class UserController extends HttpServlet {

    private final UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer nationalityId = null;
        if (request.getParameter("nid") != null && !request.getParameter("nid").trim().isEmpty()) {
            nationalityId = Integer.parseInt(request.getParameter("nid"));
        }
        List<User> users = userDao.getAll(name, surname, nationalityId);
        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

}
