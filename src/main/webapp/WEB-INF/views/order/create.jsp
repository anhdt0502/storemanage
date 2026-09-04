<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="mb-0">Tạo đơn hàng</h1>

        <a href="${pageContext.request.contextPath}/orders"
           class="btn btn-secondary">
            Quay lại
        </a>
    </div>

    <div class="card">

        <div class="card-header">
            <strong>Thông tin đơn hàng</strong>
        </div>

        <div class="card-body">

            <form method="post"
                  action="${pageContext.request.contextPath}/orders">

                <input type="hidden"
                       name="action"
                       value="insert">

                <!-- Khách hàng -->
                <div class="mb-3">

                    <label class="form-label">
                        Customer ID
                    </label>

                    <input type="number"
                           name="customerId"
                           class="form-control"
                           min="1"
                           required>

                </div>

             <!-- Danh sách sản phẩm -->
               <div class="mb-3">

                    <label class="form-label">
                          Sản phẩm trong đơn hàng
                                </label>

                    <div id="product-container">

                          <!-- Dòng sản phẩm đầu tiên -->
                               <div class="row product-row mb-3">

                                   <div class="col-md-7">

                                   <select name="productId"
                                            class="form-select"
                                            required>

                                            <option value="">
                                           -- Chọn sản phẩm --
                                            </option>

                                       <c:forEach var="product"
                                                    items="${products}">

                                            <option value="${product.id}">
                                                        ${product.name}
                                                        - ${product.price}
                                                        - Tồn kho: ${product.stock}
                                            </option>

                                       </c:forEach>

                                   </select>

                                   </div>

                                        <div class="col-md-3">

                                            <input type="number"
                                                   name="quantity"
                                                   class="form-control"
                                                   min="1"
                                                   value="1"
                                                   required>

                                        </div>

                                        <div class="col-md-2">

                                            <button type="button"
                                                    class="btn btn-danger remove-product">
                                                Xóa
                                            </button>

                                        </div>

                                    </div>

                                </div>

                          <button type="button"
                                        id="add-product"
                                        class="btn btn-success">
                                    + Thêm sản phẩm
                          </button>

                </div>



                <!-- Trạng thái -->
                <div class="mb-3">

                    <label class="form-label">
                        Trạng thái
                    </label>

                    <select name="status"
                            class="form-select">

                        <option value="0">
                            Chờ duyệt
                        </option>

                        <option value="1">
                            Đang giao
                        </option>

                        <option value="2">
                            Hoàn thành
                        </option>

                        <option value="3">
                            Đã hủy
                        </option>

                    </select>

                </div>

                <button type="submit"
                        class="btn btn-primary">
                    Tạo đơn hàng
                </button>

                <a href="${pageContext.request.contextPath}/orders"
                   class="btn btn-secondary">
                    Hủy
                </a>

            </form>

        </div>

    </div>

</div>
<script>

    document.getElementById("add-product")
        .addEventListener("click", function () {

            const container =
                document.getElementById("product-container");

            const firstRow =
                document.querySelector(".product-row");

            const newRow =
                firstRow.cloneNode(true);


            newRow.querySelector(
                'select[name="productId"]'
            ).value = "";


            newRow.querySelector(
                'input[name="quantity"]'
            ).value = 1;

            container.appendChild(newRow);

        });


    document
        .getElementById("product-container")
        .addEventListener("click", function (event) {

            if (
                event.target.classList.contains(
                    "remove-product"
                )
            ) {

                const rows =
                    document.querySelectorAll(
                        ".product-row"
                    );


                if (rows.length > 1) {

                    event.target
                        .closest(".product-row")
                        .remove();

                }

            }

        });

</script>


<jsp:include page="/WEB-INF/views/layout/footer.jsp" />