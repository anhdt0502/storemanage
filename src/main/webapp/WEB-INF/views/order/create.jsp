<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container-fluid">

    <!-- Hiển thị lỗi khi tạo đơn thất bại -->
    <c:if test="${not empty errorMessage}">

        <div class="alert alert-danger alert-dismissible fade show"
             role="alert">

            <strong>Tạo đơn hàng thất bại!</strong>

            <br>

            ${errorMessage}

            <button type="button"
                    class="btn-close"
                    data-bs-dismiss="alert"
                    aria-label="Close">
            </button>

        </div>

    </c:if>


    <!-- Tiêu đề -->
    <div class="d-flex justify-content-between align-items-center mb-4">

        <h1 class="mb-0">
            Tạo đơn hàng
        </h1>

        <a
                href="${pageContext.request.contextPath}/orders"
                class="btn btn-secondary">

            Quay lại

        </a>

    </div>


    <!-- Form -->
    <div class="card">

        <div class="card-header">

            <strong>
                Thông tin đơn hàng
            </strong>

        </div>


        <div class="card-body">

            <form
                    method="post"
                    action="${pageContext.request.contextPath}/orders">

                <input
                        type="hidden"
                        name="action"
                        value="insert">


                <!-- Customer -->
                <div class="mb-3">

                    <label class="form-label">
                        Customer ID
                    </label>

                    <input
                            type="number"
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

                                <select
                                        name="productId"
                                        class="form-select"
                                        required>

                                    <option value="">
                                        -- Chọn sản phẩm --
                                    </option>


                                    <c:forEach
                                            var="product"
                                            items="${products}">

                                        <option
                                                value="${product.id}">

                                            ${product.name}
                                            - ${product.price}
                                            - Tồn kho: ${product.stock}

                                        </option>

                                    </c:forEach>

                                </select>

                            </div>


                            <div class="col-md-3">

                                <input
                                        type="number"
                                        name="quantity"
                                        class="form-control"
                                        min="1"
                                        value="1"
                                        required>

                            </div>


                            <div class="col-md-2">

                                <button
                                        type="button"
                                        class="btn btn-danger remove-product">

                                    Xóa

                                </button>

                            </div>

                        </div>

                    </div>


                    <button
                            type="button"
                            id="add-product"
                            class="btn btn-success">

                        + Thêm sản phẩm

                    </button>
                    <!-- Giảm giá -->
                    <div class="mb-3 mt-4">

                        <label class="form-label">
                            Giảm giá
                        </label>

                        <select
                                name="discountType"
                                id="discountType"
                                class="form-select">

                            <option value="none">
                                Không giảm giá
                            </option>

                            <option value="10">
                                Giảm 10%
                            </option>

                            <option value="20">
                                Giảm 20%
                            </option>

                            <option value="30">
                                Giảm 30%
                            </option>

                            <option value="custom">
                                Tự nhập %
                            </option>

                        </select>

                    </div>


                    <!-- Nhập % tùy chỉnh -->
                    <div
                            class="mb-3"
                            id="customDiscountContainer"
                            style="display: none;">

                        <label class="form-label">
                            Phần trăm giảm giá
                        </label>

                        <div class="input-group">

                            <input
                                    type="number"
                                    name="customDiscount"
                                    id="customDiscount"
                                    class="form-control"
                                    min="0"
                                    max="100"
                                    step="0.01"
                                    value="0">

                            <span class="input-group-text">
                                %
                            </span>

                        </div>

                        <div class="form-text">
                            Nhập từ 0% đến 100%.
                        </div>

                    </div>

                </div>


                <!-- Trạng thái -->
                <div class="mb-3">

                    <label class="form-label">
                        Trạng thái
                    </label>


                    <select
                            name="status"
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


                <!-- Buttons -->
                <button
                        type="submit"
                        class="btn btn-primary">

                    Tạo đơn hàng

                </button>


                <a
                        href="${pageContext.request.contextPath}/orders"
                        class="btn btn-secondary">

                    Hủy

                </a>

            </form>

        </div>

    </div>

</div>


<!-- JavaScript thêm / xóa sản phẩm -->
<script>

    document
        .getElementById("add-product")
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
        // =========================
        // Discount
        // =========================

        const discountType =
            document.getElementById("discountType");

        const customDiscountContainer =
            document.getElementById(
                "customDiscountContainer"
            );

        const customDiscount =
            document.getElementById("customDiscount");


        discountType.addEventListener(
            "change",
            function () {

                if (this.value === "custom") {

                    customDiscountContainer.style.display =
                        "block";

                    customDiscount.required = true;

                } else {

                    customDiscountContainer.style.display =
                        "none";

                    customDiscount.required = false;

                    customDiscount.value = 0;
                }
            }
        );

</script>