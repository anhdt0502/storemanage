package com.ministore.service;

import com.ministore.dao.UserDAO;
import com.ministore.model.User;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public User login(
            String username,
            String password
    ) {

        if (username == null ||
                username.trim().isEmpty()) {

            return null;
        }

        if (password == null ||
                password.trim().isEmpty()) {

            return null;
        }

        return userDAO.findByUsernameAndPassword(
                username.trim(),
                password
        );
    }
}