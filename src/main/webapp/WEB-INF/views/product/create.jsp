<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Thêm sản phẩm</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h1 class="mb-4">
        Thêm sản phẩm
    </h1>

    <form
            method="post"
            action="${pageContext.request.contextPath}/products?action=insert">





        <!-- Tên sản phẩm -->

        <div class="mb-3">

            <label class="form-label">
                Tên sản phẩm
            </label>

            <input
                    type="text"
                    class="form-control"
                    name="name"
                    required>

        </div>


        <!-- Giá -->

        <div class="mb-3">

            <label class="form-label">
                Giá
            </label>

            <input
                    type="number"
                    class="form-control"
                    name="price"
                    min="0"
                    step="0.01"
                    required>

        </div>


        <!-- Tồn kho -->

        <div class="mb-3">

            <label class="form-label">
                Tồn kho
            </label>

            <input
                    type="number"
                    class="form-control"
                    name="stock"
                    min="0"
                    required>

        </div>


        <!-- Category -->

        <div class="mb-3">

            <label class="form-label">
                Danh mục
            </label>

            <select
                    class="form-select"
                    name="categoryId"
                    required>

                <option value="">
                    -- Chọn danh mục --
                </option>

                <c:forEach
                        var="category"
                        items="${categories}">

                    <option value="${category.id}">
                        ${category.name}
                    </option>

                </c:forEach>

            </select>

        </div>


        <!-- Mô tả -->

        <div class="mb-3">

            <label class="form-label">
                Mô tả
            </label>

            <textarea
                    class="form-control"
                    name="description"
                    rows="4"></textarea>

        </div>


        <!-- Image URL -->

        <div class="mb-3">
            <label class="form-label">Ảnh sản phẩm</label>

            <input
                    type="text"
                    class="form-control"
                    name="imageUrl"
                    placeholder="Ví dụ: op15.jpg">

        </div>


        <!-- Status -->

        <div class="mb-3">

            <label class="form-label">
                Trạng thái
            </label>

            <select
                    class="form-select"
                    name="status">

                <option value="1">
                    Đang bán
                </option>

                <option value="0">
                    Ngừng bán
                </option>

            </select>

        </div>


        <button
                type="submit"
                class="btn btn-primary">

            Thêm sản phẩm

        </button>


        <a
                href="${pageContext.request.contextPath}/products"
                class="btn btn-secondary">

            Quay lại

        </a>

    </form>

</div>

</body>

</html>