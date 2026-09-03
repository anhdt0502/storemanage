package com.ministore.controller;

import com.ministore.model.Order;
import com.ministore.service.OrderService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService ;
    @Override
    public void init() {
        orderService = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try {
            List<Order> orderList = orderService.findAll();
            request.setAttribute("orders", orderList);
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/views/order/list.jsp");
            dispatcher.forward(request, response);

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if ("updateStatus".equals(action)) {

            int orderId = Integer.parseInt(
                    request.getParameter("orderId")
            );

            int status = Integer.parseInt(
                    request.getParameter("status")
            );

            orderService.updateOrderStatus(orderId, status);

            response.sendRedirect(
                    request.getContextPath() + "/orders"
            );
        }
    }
}