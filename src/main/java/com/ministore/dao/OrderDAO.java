package com.ministore.dao;

import com.ministore.config.DatabaseConnection;
import com.ministore.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public List<Order> findAll(){
        List<Order> orders = new ArrayList<>();
        String sql = """
                SELECT
                o.id,
                o.customer_id,
                o.order_date,
                o.total_price,
                o.status
                FROM orders o 
                ORDER BY o.id DESC
              
                """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =connection.prepareStatement(sql);

                ResultSet resultSet =   statement.executeQuery()
        ){

            while (resultSet.next()) {
                Order o = new Order();
                o.setId(resultSet.getInt("id"));
                o.setCustomerId(resultSet.getInt("customer_id"));
                o.setOrderDate(resultSet.getTimestamp("order_date"));
                o.setTotalPrice(resultSet.getBigDecimal("total_price"));
                o.setStatus(resultSet.getInt("status"));
                orders.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    public Order findById(int id) {
        Order o = null;
        String sql = """
            SELECT
                o.id,
                o.customer_id,
                o.order_date,
                o.total_price,
                o.status
            FROM orders o 
            WHERE o.id = ?
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    o = new Order();
                    o.setId(resultSet.getInt("id"));
                    o.setCustomerId(resultSet.getInt("customer_id"));
                    o.setOrderDate(resultSet.getTimestamp("order_date"));
                    o.setTotalPrice(resultSet.getBigDecimal("total_price"));
                    o.setStatus(resultSet.getInt("status"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public void updateStatus(int orderId, int status) {
        String sql = """
            UPDATE orders 
            SET status = ? 
            WHERE id = ?
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, status);
            statement.setInt(2, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
