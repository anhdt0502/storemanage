<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Mini Store</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">

        <a class="navbar-brand"
           href="${pageContext.request.contextPath}/home">
            Mini Store
        </a>

        <div class="d-flex align-items-center">

            <%
                com.ministore.model.User currentUser =
                        (com.ministore.model.User)
                                session.getAttribute("currentUser");
            %>

            <% if (currentUser != null) { %>

                <span class="text-white me-3">
                    Xin chào,
                    <strong>
                        <%= currentUser.getFullName() %>
                    </strong>
                </span>

                <a href="${pageContext.request.contextPath}/logout"
                   class="btn btn-outline-light btn-sm">
                    Đăng xuất
                </a>

            <% } %>

        </div>

    </div>
</nav>