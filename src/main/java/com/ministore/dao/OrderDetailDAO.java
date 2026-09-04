package com.ministore.dao;

import com.ministore.config.DatabaseConnection;
import com.ministore.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {

    public List<OrderDetail> findByOrderId(int orderId) {

        List<OrderDetail> orderDetails =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    order_id,
                    product_id,
                    quantity,
                    price
                FROM order_details
                WHERE order_id = ?
                ORDER BY id
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, orderId);

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                while (resultSet.next()) {

                    OrderDetail detail =
                            new OrderDetail();

                    detail.setId(
                            resultSet.getInt("id")
                    );

                    detail.setOrderId(
                            resultSet.getInt("order_id")
                    );

                    detail.setProductId(
                            resultSet.getInt("product_id")
                    );

                    detail.setQuantity(
                            resultSet.getInt("quantity")
                    );

                    detail.setPrice(
                            resultSet.getBigDecimal("price")
                    );

                    orderDetails.add(detail);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderDetails;
    }

    public boolean insert(OrderDetail detail) {

        String sql = """
                INSERT INTO order_details
                (
                    order_id,
                    product_id,
                    quantity,
                    price
                )
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    detail.getOrderId()
            );

            statement.setInt(
                    2,
                    detail.getProductId()
            );

            statement.setInt(
                    3,
                    detail.getQuantity()
            );

            statement.setBigDecimal(
                    4,
                    detail.getPrice()
            );

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}