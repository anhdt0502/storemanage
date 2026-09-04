package com.ministore.controller;

import com.ministore.model.Order;
import com.ministore.model.OrderDetail;
import com.ministore.service.OrderDetailService;
import com.ministore.service.OrderService;
import com.ministore.model.Product;
import com.ministore.service.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private OrderService orderService ;
    private OrderDetailService orderDetailService;
    private ProductService productService;
    @Override
    public void init() {

        orderService = new OrderService();
        orderDetailService = new OrderDetailService();
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action =  request.getParameter("action");
        if ("detail".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Order order =
                    orderService.findById(id);

            List<OrderDetail> orderDetails =
                    orderDetailService.findByOrderId(id);

            request.setAttribute("order",
                    order
            );

            request.setAttribute("orderDetails",
                    orderDetails
            );

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/order/detail.jsp"
                    );

            dispatcher.forward(request, response);

            return;
        }
        if ("create".equals(action)) {
            List<Product> products = productService.findAll();

            request.setAttribute("products", products);

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/order/create.jsp"
                    );

            dispatcher.forward(request, response);

            return;
        }


            List<Order> orderList = orderService.findAll();
            request.setAttribute("orders", orderList);
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/views/order/list.jsp");
            dispatcher.forward(request, response);



    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            int customerId =
                    Integer.parseInt(
                            request.getParameter("customerId")
                    );

            int status =
                    Integer.parseInt(
                            request.getParameter("status")
                    );

            String[] productIdValues =
                    request.getParameterValues("productId");

            String[] quantityValues =
                    request.getParameterValues("quantity");

            if (productIdValues == null ||
                    quantityValues == null ||
                    productIdValues.length == 0 ||
                    productIdValues.length != quantityValues.length) {

                response.getWriter().println(
                        "Danh sách sản phẩm không hợp lệ!"
                );

                return;
            }

            int[] productIds =
                    new int[productIdValues.length];

            int[] quantities =
                    new int[quantityValues.length];

            for (int i = 0;
                 i < productIdValues.length;
                 i++) {

                productIds[i] =
                        Integer.parseInt(
                                productIdValues[i]
                        );

                quantities[i] =
                        Integer.parseInt(
                                quantityValues[i]
                        );
            }

            Order order = new Order();

            order.setCustomerId(customerId);

            order.setStatus(status);

            try {

                int orderId =
                        orderService.createOrder(
                                order,
                                productIds,
                                quantities
                        );

                response.sendRedirect(
                        request.getContextPath()
                                + "/orders?action=detail&id="
                                + orderId
                );

            } catch (Exception e) {

                e.printStackTrace();

                List<Product> products =
                        productService.findAll();

                request.setAttribute(
                        "products",
                        products
                );

                request.setAttribute(
                        "errorMessage",
                        e.getMessage()
                );

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(
                                "/WEB-INF/views/order/create.jsp"
                        );

                dispatcher.forward(request, response);
            }
        }

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