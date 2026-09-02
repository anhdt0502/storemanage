package com.ministore.service;

import com.ministore.dao.ProductDAO;
import com.ministore.model.Product;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO ;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public List<Product> findAll() {

        return productDAO.findAll();
    }
}