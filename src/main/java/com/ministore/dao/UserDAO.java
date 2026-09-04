package com.ministore.dao;

import com.ministore.config.DatabaseConnection;
import com.ministore.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User findByUsernameAndPassword(
            String username,
            String password
    ) {

        String sql = """
                SELECT
                    id,
                    username,
                    password,
                    full_name,
                    role,
                    status
                FROM users
                WHERE username = ?
                  AND password = ?
                  AND status = 1
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                if (resultSet.next()) {

                    User user = new User();

                    user.setId(
                            resultSet.getInt("id")
                    );

                    user.setUsername(
                            resultSet.getString("username")
                    );

                    user.setPassword(
                            resultSet.getString("password")
                    );

                    user.setFullName(
                            resultSet.getString("full_name")
                    );

                    user.setRole(
                            resultSet.getString("role")
                    );

                    user.setStatus(
                            resultSet.getInt("status")
                    );

                    return user;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}