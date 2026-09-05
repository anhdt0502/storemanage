<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Sửa danh mục
        </h1>

        <a
                href="${pageContext.request.contextPath}/categories"
                class="btn btn-secondary">

            Quay lại

        </a>

    </div>

    <div class="card shadow-sm">

        <div class="card-body">

            <form
                    method="post"
                    action="${pageContext.request.contextPath}/categories">

                <input
                        type="hidden"
                        name="action"
                        value="update">

                <input
                        type="hidden"
                        name="id"
                        value="${category.id}">


                <!-- Tên danh mục -->

                <div class="mb-3">

                    <label class="form-label">
                        Tên danh mục
                    </label>

                    <input
                            type="text"
                            name="name"
                            class="form-control"
                            value="${category.name}"
                            required>

                </div>


                <!-- Mô tả -->

                <div class="mb-3">

                    <label class="form-label">
                        Mô tả
                    </label>

                    <textarea
                            name="description"
                            class="form-control"
                            rows="4">${category.description}</textarea>

                </div>


                <!-- Buttons -->

                <button
                        type="submit"
                        class="btn btn-primary">

                    Lưu thay đổi

                </button>

                <a
                        href="${pageContext.request.contextPath}/categories"
                        class="btn btn-secondary">

                    Hủy

                </a>

            </form>

        </div>

    </div>

</div>