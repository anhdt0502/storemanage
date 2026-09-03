<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="mb-0">Quản lý phụ kiện điện thoại</h1>

        <a
            href="${pageContext.request.contextPath}/products?action=create"
            class="btn btn-primary">
            + Thêm sản phẩm
        </a>
    </div>
    <div class="table-responsive">

    <table class="table table-bordered table-striped">

        <thead class="table-dark">

        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Hình ảnh </th>
            <th>Giá</th>
            <th>Tồn kho</th>
            <th>Danh mục</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
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
                    <c:choose>
                        <c:when test="${not empty product.imageUrl}">
                            <img
                                src="${pageContext.request.contextPath}/assets/images/${product.imageUrl}"
                                alt="${product.name}"
                                width="70"
                                height="70"
                                class="rounded"
                                style="object-fit: cover;">
                        </c:when>

                        <c:otherwise>
                            <span class="text-muted">Chưa có ảnh</span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    ${product.price}
                </td>

                <td>
                    ${product.stock}
                </td>

                <td>
                    ${product.categoryName}
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
                <td>

                    <a
                            href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}"
                            class="btn btn-warning btn-sm">

                        Sửa

                    </a>

                    <form
                            method="post"
                            action="${pageContext.request.contextPath}/products"
                            style="display:inline;"
                            onsubmit="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">

                        <input
                                type="hidden"
                                name="action"
                                value="delete">

                        <input
                                type="hidden"
                                name="id"
                                value="${product.id}">

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

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />