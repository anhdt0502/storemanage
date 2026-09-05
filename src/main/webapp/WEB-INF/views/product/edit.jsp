<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Sửa sản phẩm
        </h1>

        <a
                href="${pageContext.request.contextPath}/products"
                class="btn btn-secondary">

            Quay lại

        </a>

    </div>

    <div class="card shadow-sm">

        <div class="card-body">

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


                <!-- Tên sản phẩm -->

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


                <!-- Giá -->

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


                <!-- Tồn kho -->

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


                <!-- Danh mục -->

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


                <!-- Mô tả -->

                <div class="mb-3">

                    <label class="form-label">
                        Mô tả
                    </label>

                    <textarea
                            class="form-control"
                            name="description"
                            rows="4">${product.description}</textarea>

                </div>


                <!-- Image URL -->

                <div class="mb-3">

                    <label class="form-label">
                        Ảnh sản phẩm
                    </label>

                    <input
                            type="text"
                            class="form-control"
                            name="imageUrl"
                            value="${product.imageUrl}"
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


                <!-- Buttons -->

                <button
                        type="submit"
                        class="btn btn-primary">

                    Lưu thay đổi

                </button>

                <a
                        href="${pageContext.request.contextPath}/products"
                        class="btn btn-secondary">

                    Hủy

                </a>

            </form>

        </div>

    </div>

</div>