<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container-fluid">
    <c:if test="${not empty errorMessage}">

        <div class="alert alert-danger alert-dismissible fade show"
             role="alert">

            <strong>Xóa danh mục thất bại!</strong>

            <br>

            ${errorMessage}

            <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="alert"
                    aria-label="Close">
            </button>

        </div>

    </c:if>

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Quản lý danh mục
        </h1>

        <a
                href="${pageContext.request.contextPath}/categories?action=create"
                class="btn btn-primary">

            + Thêm danh mục

        </a>

    </div>

    <div class="table-responsive">

        <table class="table table-bordered table-striped align-middle">

            <thead class="table-dark">

            <tr>
                <th>ID</th>
                <th>Tên danh mục</th>
                <th>Mô tả</th>
                <th>Thao tác</th>
            </tr>

            </thead>

            <tbody>

            <c:forEach
                    var="category"
                    items="${categories}">

                <tr>

                    <td>
                        ${category.id}
                    </td>

                    <td>
                        ${category.name}
                    </td>

                    <td>
                        ${category.description}
                    </td>

                    <td>

                        <a
                                href="${pageContext.request.contextPath}/categories?action=edit&id=${category.id}"
                                class="btn btn-warning btn-sm">

                            Sửa

                        </a>

                        <form
                                method="post"
                                action="${pageContext.request.contextPath}/categories"
                                style="display:inline;"
                                onsubmit="return confirm('Bạn có chắc muốn xóa danh mục này?');">

                            <input
                                    type="hidden"
                                    name="action"
                                    value="delete">

                            <input
                                    type="hidden"
                                    name="id"
                                    value="${category.id}">

                            <button
                                    type="submit"
                                    class="btn btn-danger btn-sm">

                                Xóa

                            </button>

                        </form>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>