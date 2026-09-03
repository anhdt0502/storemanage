<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Quản lý danh mục
        </h1>

    </div>

    <table class="table table-bordered table-striped">

        <thead class="table-dark">

        <tr>
                                    <th>ID</th>
                                    <th>Mã Khách Hàng</th>
                                    <th>Ngày Đặt</th>
                                    <th>Tổng Tiền</th>
                                    <th>Trạng thái</th>
                                    <th>Thao tác</th>
                             </tr>

        </thead>

        <tbody>

        <c:forEach var="order" items="${orders}">

            <tr>
                                            <td>${order.id}</td>
                                            <td>${order.customerId}</td>
                                            <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                            <td class="text-danger fw-bold">
                                                <fmt:formatNumber value="${order.totalPrice}" type="number" groupingUsed="true" maxFractionDigits="2" />đ
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${order.status == 0}"><span class="badge bg-warning text-dark">Chờ duyệt</span></c:when>
                                                    <c:when test="${order.status == 1}"><span class="badge bg-info text-dark">Đang giao</span></c:when>
                                                    <c:when test="${order.status == 2}"><span class="badge bg-success">Hoàn thành</span></c:when>
                                                    <c:otherwise><span class="badge bg-danger">Đã hủy</span></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/orders?action=detail&id=${order.id}" class="btn btn-sm btn-warning text-dark fw-bold">Chi tiết</a>
                                            </td>
                                        </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />