package com.ministore.service;

import com.ministore.dao.OrderDAO;
import com.ministore.dao.ProductDAO;
import com.ministore.model.Order;
import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO ;
    public OrderService() { this.orderDAO = new OrderDAO() ;
    }

    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    public Order getOrderById(int id) {
        return orderDAO.findById(id);
    }

    public void updateOrderStatus(int orderId, int status) {
        orderDAO.updateStatus(orderId, status);
    }
}