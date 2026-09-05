<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1>
            Chi tiết đơn hàng #${order.id}
        </h1>

        <a
                href="${pageContext.request.contextPath}/orders"
                class="btn btn-secondary">

            Quay lại

        </a>

    </div>


    <!-- Thông tin đơn hàng -->
    <div class="card mb-4">

        <div class="card-header">

            <strong>
                Thông tin đơn hàng
            </strong>

        </div>

        <div class="card-body">

            <div class="row">

                <div class="col-md-3">

                    <strong>Mã đơn:</strong>
                    ${order.id}

                </div>

                <div class="col-md-3">

                    <strong>Khách hàng:</strong>
                    ${order.customerId}

                </div>

                <div class="col-md-3">

                    <strong>Ngày đặt:</strong>
                    ${order.orderDate}

                </div>

                <div class="col-md-3">

                    <strong>Trạng thái:</strong>

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

                </div>

            </div>

        </div>

    </div>


    <!-- Chi tiết sản phẩm -->
    <div class="card">

        <div class="card-header">

            <strong>
                Sản phẩm trong đơn hàng
            </strong>

        </div>

        <div class="card-body">

            <div class="table-responsive">

                <table class="table table-bordered table-striped align-middle">

                    <thead class="table-dark">

                    <tr>

                        <th>ID</th>
                        <th>Order ID</th>
                        <th>Product ID</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Thành tiền</th>

                    </tr>

                    </thead>

                    <tbody>

                    <c:forEach
                            var="detail"
                            items="${orderDetails}">

                        <tr>

                            <td>
                                ${detail.id}
                            </td>

                            <td>
                                ${detail.orderId}
                            </td>

                            <td>
                                ${detail.productId}
                            </td>

                            <td>
                                ${detail.quantity}
                            </td>

                            <td>
                                ${detail.price}
                            </td>

                            <td>
                                ${detail.price * detail.quantity}
                            </td>

                        </tr>

                    </c:forEach>

                    </tbody>

                </table>

            </div>


            <div class="text-end mt-3">

                <h4>

                    Tổng tiền:

                    <strong>
                        ${order.totalPrice}
                    </strong>

                </h4>

            </div>

        </div>

    </div>

</div>