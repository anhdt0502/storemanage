package com.ministore.controller;

import com.ministore.dao.ProductDAO;
import com.ministore.model.Product;
import com.ministore.service.ProductService;
import com.ministore.model.Category;
import com.ministore.service.CategoryService;

import com.ministore.service.CategoryService;
import com.ministore.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            List<Product> productList = productService.findAll();
            request.setAttribute("products", productList);
            request.setAttribute(
                    "contentPage",
                    "/WEB-INF/views/home.jsp"
            );
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/layout/layout.jsp"
                    );

        dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi tải trang chủ!");
        }
    }
}