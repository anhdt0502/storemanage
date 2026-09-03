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
                    p.id,
                    p.name,
                    p.price,
                    p.stock,
                    p.category_id,
                    c.name AS category_name,
                    p.description,
                    p.image_url,
                    p.status
                FROM products p
                JOIN categories c
                    ON p.category_id = c.id
                ORDER BY p.id DESC;
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
                product.setCategoryName(
                        resultSet.getString("category_name")
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
    public Product findById(int id) {

        String sql = """
            SELECT
                p.id,
                p.name,
                p.price,
                p.stock,
                p.category_id,
                c.name AS category_name,
                p.description,
                p.image_url,
                p.status
            FROM products p
            JOIN categories c
                ON p.category_id = c.id
            WHERE p.id = ?
            """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

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

                    product.setCategoryName(
                            resultSet.getString("category_name")
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

                    return product;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean update(Product product) {

        String sql = """
            UPDATE products
            SET
                name = ?,
                price = ?,
                stock = ?,
                category_id = ?,
                description = ?,
                image_url = ?,
                status = ?
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setInt(4, product.getCategoryId());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getImageUrl());
            statement.setInt(7, product.getStatus());
            statement.setInt(8, product.getId());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean insert(Product product) {

        String sql = """
            INSERT INTO products
            (
                name,
                price,
                stock,
                category_id,
                description,
                image_url,
                status
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setInt(4, product.getCategoryId());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getImageUrl());
            statement.setInt(7, product.getStatus());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean delete(int id) {

        String sql = """
            DELETE FROM products
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}