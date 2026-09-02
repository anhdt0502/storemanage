package com.ministore.dao;

import com.ministore.config.DatabaseConnection;
import com.ministore.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM products";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Product product = new Product();

                product.setId(
                        resultSet.getInt("id")
                );

                product.setName(
                        resultSet.getString("name")
                );

                product.setPrice(
                        resultSet.getBigDecimal("price")
                );

                product.setStock(
                        resultSet.getInt("stock")
                );

                product.setCategoryId(
                        resultSet.getInt("category_id")
                );

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}