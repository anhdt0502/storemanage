<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Sửa sản phẩm</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <h1 class="mb-4">
        Sửa sản phẩm
    </h1>

    <form
                    method="post"
                    action="${pageContext.request.contextPath}/products">
        <input
                type="hidden"
                name="action"
                value="update">

        <input
                type="hidden"
                name="id"
                value="${product.id}">


        <div class="mb-3">

            <label class="form-label">
                Tên sản phẩm
            </label>

            <input
                    type="text"
                    class="form-control"
                    name="name"
                    value="${product.name}"
                    required>
        </div>


        <div class="mb-3">

            <label class="form-label">
                Giá
            </label>

            <input
                    type="number"
                    class="form-control"
                    name="price"
                    value="${product.price}"
                    min="0"
                    step="0.01"
                    required>
        </div>


        <div class="mb-3">

            <label class="form-label">
                Tồn kho
            </label>

            <input
                    type="number"
                    class="form-control"
                    name="stock"
                    value="${product.stock}"
                    min="0"
                    required>
        </div>


        <div class="mb-3">

            <label class="form-label">
                Danh mục
            </label>

            <input
                        type="text"
                        class="form-control"
                        value="${product.categoryName}"
                        readonly>

                <input
                        type="hidden"
                        name="categoryId"
                        value="${product.categoryId}">
        </div>


        <div class="mb-3">

            <label class="form-label">
                Mô tả
            </label>

            <textarea
                    class="form-control"
                    name="description"
                    rows="4">${product.description}</textarea>

        </div>
        <div class="mb-3">
                  <label class="form-label">Ảnh sản phẩm</label>

                  <input
                          type="text"
                          class="form-control"
                          name="imageUrl"
                          placeholder="Ví dụ: op15.jpg">

              </div>


        <div class="mb-3">

            <label class="form-label">
                Trạng thái
            </label>

            <select class="form-select"
                    name="status">

                <option
                        value="1"
                        ${product.status == 1 ? 'selected' : ''}>
                    Đang bán
                </option>

                <option
                        value="0"
                        ${product.status == 0 ? 'selected' : ''}>
                    Ngừng bán
                </option>

            </select>

        </div>



        <button
                type="submit"
                class="btn btn-primary">
            Lưu thay đổi
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