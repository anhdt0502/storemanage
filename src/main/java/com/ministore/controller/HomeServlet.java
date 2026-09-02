package com.ministore.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        if (dispatcher == null) {
            response.getWriter().println("Không tìm thấy: /WEB-INF/views/index.jsp");
            return;
        }
        dispatcher.forward(request, response);

//        response.setContentType("text/html;charset=UTF-8");

//        response.getWriter().println("""
//                <!DOCTYPE html>
//                <html>
//                <head>
//                    <meta charset="UTF-8">
//                    <title>Mini Store</title>
//                </head>
//                <body>
//
//                    <h1>Mini Store Management System</h1>
//
//                    <p>Servlet is working!</p>
//
//                </body>
//                </html>
//                """);
    }
}