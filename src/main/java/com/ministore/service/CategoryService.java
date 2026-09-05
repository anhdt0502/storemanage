package com.ministore.service;

import com.ministore.dao.CategoryDAO;
import com.ministore.model.Category;

import java.util.List;

public class CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
    public boolean insert(Category category) {
        return categoryDAO.insert(category);
    }
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }
    public boolean delete(int id) {return categoryDAO.delete(id);}
}