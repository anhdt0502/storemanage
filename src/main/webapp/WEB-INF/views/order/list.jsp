<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Quản lý đơn hàng
        </h1>

        <a
                href="${pageContext.request.contextPath}/orders?action=create"
                class="btn btn-primary">

            + Tạo đơn hàng

        </a>

    </div>

    <div class="table-responsive">

        <table class="table table-bordered table-striped align-middle">

            <thead class="table-dark">

            <tr>
                <th>ID</th>
                <th>Khách hàng</th>
                <th>Ngày đặt</th>
                <th>Tổng tiền</th>
                <th>Trạng thái</th>
                <th>Thao tác</th>
            </tr>

            </thead>

            <tbody>

            <c:forEach
                    var="order"
                    items="${orders}">

                <tr>

                    <td>
                        ${order.id}
                    </td>

                    <td>
                        ${order.customerId}
                    </td>

                    <td>
                        ${order.orderDate}
                    </td>

                    <td>
                        ${order.totalPrice}
                    </td>

                    <td>

                        <c:choose>

                            <c:when test="${order.status == 0}">

                                <span class="badge bg-warning text-dark">
                                    Chờ duyệt
                                </span>

                            </c:when>

                            <c:when test="${order.status == 1}">

                                <span class="badge bg-primary">
                                    Đang giao
                                </span>

                            </c:when>

                            <c:when test="${order.status == 2}">

                                <span class="badge bg-success">
                                    Hoàn thành
                                </span>

                            </c:when>

                            <c:when test="${order.status == 3}">

                                <span class="badge bg-danger">
                                    Đã hủy
                                </span>

                            </c:when>

                            <c:otherwise>

                                <span class="badge bg-secondary">
                                    Không xác định
                                </span>

                            </c:otherwise>

                        </c:choose>

                    </td>

                    <td>

                        <a
                                href="${pageContext.request.contextPath}/orders?action=detail&id=${order.id}"
                                class="btn btn-info btn-sm">

                            Chi tiết

                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>