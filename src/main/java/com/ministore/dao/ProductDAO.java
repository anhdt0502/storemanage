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

        String sql = """
                SELECT
                    id,
                    name,
                    price,
                    stock,
                    category_id,
                    description,
                    image_url,
                    status
                FROM products
                ORDER BY id DESC
                """;

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

                product.setDescription(
                        resultSet.getString("description")
                );

                product.setImageUrl(
                        resultSet.getString("image_url")
                );

                product.setStatus(
                        resultSet.getInt("status")
                );

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}