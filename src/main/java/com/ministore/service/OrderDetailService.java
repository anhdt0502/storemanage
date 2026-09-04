package com.ministore.service;

import com.ministore.dao.OrderDetailDAO;
import com.ministore.model.OrderDetail;

import java.util.List;

public class OrderDetailService {

    private final OrderDetailDAO orderDetailDAO;

    public OrderDetailService() {
        this.orderDetailDAO =new OrderDetailDAO();
    }

    public List<OrderDetail> findByOrderId(  int orderId) {
        return orderDetailDAO.findByOrderId(  orderId);
    }

    public boolean insert(   OrderDetail detail) {
        return orderDetailDAO.insert(  detail  );
    }
}