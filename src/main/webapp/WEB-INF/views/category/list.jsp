<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />

<div class="container-fluid">

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

    <table class="table table-bordered table-striped">

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

                    <button
                            class="btn btn-danger btn-sm">

                        Xóa

                    </button>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />