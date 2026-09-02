<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Danh sách sản phẩm</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h1 class="mb-4">
        Quản lý phụ kiện điện thoại
    </h1>

    <table class="table table-bordered table-striped">

        <thead class="table-dark">

        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Tồn kho</th>
            <th>Category ID</th>
            <th>Trạng thái</th>
        </tr>

        </thead>

        <tbody>

        <c:forEach var="product"  items="${products}">

            <tr>

                <td>
                    ${product.id}
                </td>

                <td>
                    ${product.name}
                </td>

                <td>
                    ${product.price}
                </td>

                <td>
                    ${product.stock}
                </td>

                <td>
                    ${product.categoryId}
                </td>

                <td>

                    <c:choose>

                        <c:when test="${product.status == 1}">
                            <span class="badge bg-success">
                                Đang bán
                            </span>
                        </c:when>

                        <c:otherwise>
                            <span class="badge bg-secondary">
                                Ngừng bán
                            </span>
                        </c:otherwise>

                    </c:choose>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

</body>

</html>