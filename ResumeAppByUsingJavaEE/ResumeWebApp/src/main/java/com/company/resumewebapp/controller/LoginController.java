package com.company.resumewebapp.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.resumewebapp.util.ControllerUtil;
import dao.inter.UserDaoInter;
import entity.User;
import main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();
    private static final BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User u = userDao.getByEmail(email);
            if (u == null) {
                throw new IllegalArgumentException("user doesn't exist!");
            }
            BCrypt.Result rs = verifyer.verify(password.toCharArray(), u.getPassword());
            if (!rs.verified) {
                throw new IllegalArgumentException("password is incorrrect!");
            }
            response.sendRedirect("users");
            request.getSession().setAttribute("loggedInUser", u);
        } catch (Exception ex) {
            ControllerUtil.errorPage(response, ex);
        }
    }

}
