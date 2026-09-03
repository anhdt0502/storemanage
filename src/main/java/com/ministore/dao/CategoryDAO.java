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
    public Category findById(int id) {

        String sql = """
            SELECT id, name, description
            FROM categories
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                if (resultSet.next()) {

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

                    return category;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(Category category) {

        String sql = """
            INSERT INTO categories
            (
                name,
                description
            )
            VALUES (?, ?)
            """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    category.getName()
            );

            statement.setString(
                    2,
                    category.getDescription()
            );

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    public boolean update(Category category) {

        String sql = """
            UPDATE categories
            SET
                name = ?,
                description = ?
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.setInt(3, category.getId());

            int rowsAffected =
                    statement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}