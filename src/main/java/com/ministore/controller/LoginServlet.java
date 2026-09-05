package com.ministore.controller;

import com.ministore.model.User;
import com.ministore.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/views/login.jsp"
                );

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        User user =
                userService.login(
                        username,
                        password
                );

        if (user != null) {

            HttpSession session =request.getSession();
            request.changeSessionId();
            session.setAttribute(
                    "currentUser",
                    user
            );

            response.sendRedirect(
                    request.getContextPath()
                            + "/home"
            );

        } else {

            request.setAttribute(
                    "errorMessage",
                    "Tên đăng nhập hoặc mật khẩu không đúng!"
            );

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/login.jsp"
                    );

            dispatcher.forward(
                    request,
                    response
            );
        }
    }
}