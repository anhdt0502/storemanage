<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Đăng nhập - Mini Store</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">

    <div class="row justify-content-center mt-5">

        <div class="col-md-5 col-lg-4">

            <div class="card shadow">

                <div class="card-body p-4">

                    <h3 class="text-center mb-4">
                        Mini Store
                    </h3>

                    <h5 class="text-center mb-4">
                        Đăng nhập
                    </h5>

                    <!-- Hiển thị lỗi -->
                    <%
                        String errorMessage =
                                (String) request.getAttribute(
                                        "errorMessage"
                                );
                    %>

                    <% if (errorMessage != null) { %>

                        <div class="alert alert-danger"
                             role="alert">

                            <%= errorMessage %>

                        </div>

                    <% } %>

                    <form method="post"
                          action="<%= request.getContextPath() %>/login">

                        <div class="mb-3">

                            <label class="form-label">
                                Tên đăng nhập
                            </label>

                            <input
                                    type="text"
                                    name="username"
                                    class="form-control"
                                    placeholder="Nhập tên đăng nhập"
                                    required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Mật khẩu
                            </label>

                            <input
                                    type="password"
                                    name="password"
                                    class="form-control"
                                    placeholder="Nhập mật khẩu"
                                    required>

                        </div>

                        <button
                                type="submit"
                                class="btn btn-primary w-100">

                            Đăng nhập

                        </button>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

</body>

</html>