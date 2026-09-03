package com.ministore.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int id;
    private int customerId; // Hoặc tên khách hàng
    private Date orderDate;
    private BigDecimal totalPrice;
    private int status; // 0: Chờ duyệt, 1: Đang giao, 2: Hoàn thành, 3: Đã hủy

    public Order() {}

    public Order(int id, int customerId, Date orderDate, BigDecimal totalPrice, int status) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}