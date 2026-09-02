package com.ministore.dao;

import com.ministore.config.DatabaseConnection;
import com.ministore.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List<Category> findAll() {

        List<Category> categories = new ArrayList<>();

        String sql = """
                SELECT id, name, description
                FROM categories
                ORDER BY id
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Category category = new Category();

                category.setId(
                        resultSet.getInt("id")
                );

                category.setName(
                        resultSet.getString("name")
                );

                category.setDescription(
                        resultSet.getString("description")
                );

                categories.add(category);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
}