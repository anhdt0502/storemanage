<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Thêm sản phẩm
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

                    <label class="form-label">
                        Ảnh sản phẩm
                    </label>

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


                <!-- Buttons -->

                <button
                        type="submit"
                        class="btn btn-primary">

                    Thêm sản phẩm

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