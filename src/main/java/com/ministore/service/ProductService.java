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
        public Product findById(int id) {
        return productDAO.findById(id);
    }
        public boolean update(Product product) {
        return productDAO.update(product);
    }
        public boolean insert(Product product) {
        return productDAO.insert(product);
    }
        public boolean delete(int id) {
        return productDAO.delete(id);
    }
}