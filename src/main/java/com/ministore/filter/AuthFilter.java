package com.ministore.filter;

import com.ministore.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/products",
        "/categories",
        "/orders",
        "/home"
})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        HttpSession session =
                httpRequest.getSession(false);

        User currentUser = null;

        if (session != null) {
            currentUser =
                    (User) session.getAttribute(
                            "currentUser"
                    );
        }

        if (currentUser != null) {

            chain.doFilter(
                    request,
                    response
            );

        } else {

            httpResponse.sendRedirect(
                    httpRequest.getContextPath()
                            + "/login"
            );
        }
    }
}