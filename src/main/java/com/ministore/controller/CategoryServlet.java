package com.ministore.controller;

import com.ministore.model.Category;
import com.ministore.service.CategoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init() {
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/category/create.jsp"
                    );

            dispatcher.forward(request, response);

            return;
        }
        if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Category category =
                    categoryService.findById(id);

            request.setAttribute(
                    "category",
                    category
            );

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/category/edit.jsp"
                    );

            dispatcher.forward(request, response);

            return;
        }

        List<Category> categories = categoryService.findAll();

        request.setAttribute(
                "categories",
                categories
        );

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/views/category/list.jsp"
                );

        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if ("insert".equals(action)) {

            String name = request.getParameter("name");

            String description = request.getParameter("description");

            Category category =     new Category();

            category.setName(name);
            category.setDescription(description);

            boolean success =  categoryService.insert(category);

            if (success) {

                response.sendRedirect(
                        request.getContextPath()
                                + "/categories"
                );

            } else {

                response.getWriter().println(
                        "Thêm danh mục thất bại!"
                );
            }
        }
        if ("update".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            String name = request.getParameter("name");
            String description = request.getParameter("description");

            Category category = new Category();

            category.setId(id);
            category.setName(name);
            category.setDescription(description);

            boolean success =
                    categoryService.update(category);

            if (success) {

                response.sendRedirect(
                        request.getContextPath()
                                + "/categories"
                );

            } else {

                request.setAttribute(
                        "error",
                        "Cập nhật category thất bại!"
                );

                request.setAttribute(
                        "category", category);

                request.getRequestDispatcher(
                        "/WEB-INF/views/category/edit.jsp"
                ).forward(request, response);
            }
        }
    }
}