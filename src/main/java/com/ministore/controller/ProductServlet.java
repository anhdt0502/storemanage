package com.ministore.controller;

import com.ministore.model.Product;
import com.ministore.service.ProductService;
import com.ministore.model.Category;
import com.ministore.service.CategoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.io.File;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/products")
//@MultipartConfig
public class ProductServlet extends HttpServlet {

    private ProductService productService;
    private CategoryService categoryService;

    @Override
    public void init() {
        productService = new ProductService();
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("create".equals(action)) {

            List<Category> categories =
                    categoryService.findAll();

            request.setAttribute("categories", categories);

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/product/create.jsp"
                    );

            dispatcher.forward(request, response);

            return;
        }

        if ("edit".equals(action)) {

            String idParam = request.getParameter("id");

            if (idParam == null || idParam.isBlank()) {
                response.sendRedirect(
                        request.getContextPath() + "/products"
                );
                return;
            }

            int id = Integer.parseInt(idParam);

            Product product = productService.findById(id);

            if (product == null) {
                response.sendRedirect(
                        request.getContextPath() + "/products"
                );
                return;
            }

            request.setAttribute("product", product);

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/WEB-INF/views/product/edit.jsp"
                    );

            dispatcher.forward(request, response);

            return;
        }

        List<Product> products =
                productService.findAll();

        request.setAttribute("products", products);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/views/product/list.jsp"
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

        if ("update".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            String name = request.getParameter("name");

            BigDecimal price = new BigDecimal(
                    request.getParameter("price")
            );

            int stock = Integer.parseInt(
                    request.getParameter("stock")
            );

            int categoryId = Integer.parseInt(
                    request.getParameter("categoryId")
            );

            String description =
                    request.getParameter("description");

            String imageUrl =
                    request.getParameter("imageUrl");

            int status = Integer.parseInt(
                    request.getParameter("status")
            );

            Product product = new Product();

            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategoryId(categoryId);
            product.setDescription(description);
            product.setImageUrl(imageUrl);
            product.setStatus(status);

            boolean success =
                    productService.update(product);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/products"
                );

            } else {

                response.getWriter().println(
                        "Cập nhật sản phẩm thất bại!"
                );
            }
        }
        if ("insert".equals(action)) {

            String name = request.getParameter("name");

            BigDecimal price = new BigDecimal(
                    request.getParameter("price")
            );

            int stock = Integer.parseInt(
                    request.getParameter("stock")
            );

            int categoryId = Integer.parseInt(
                    request.getParameter("categoryId")
            );

            String description =
                    request.getParameter("description");



            int status = Integer.parseInt(
                    request.getParameter("status")
            );
            String imageUrl =
                    request.getParameter("imageUrl");

            Product product = new Product();

            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategoryId(categoryId);
            product.setDescription(description);
            product.setImageUrl(imageUrl);
            product.setStatus(status);

            boolean success =
                    productService.insert(product);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/products"
                );

            } else {

                response.getWriter().println(
                        "Thêm sản phẩm thất bại!"
                );
            }
        }
        if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            boolean success =
                    productService.delete(id);

            response.sendRedirect(
                    request.getContextPath() + "/products"
            );
        }
    }
}