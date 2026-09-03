<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="d-flex">

    <aside
            class="bg-light border-end"
            style="width: 230px; min-height: calc(100vh - 56px);">

        <div class="p-3">

            <h5 class="mb-4">
                Menu
            </h5>

            <div class="nav flex-column">

                <a
                        href="${pageContext.request.contextPath}/home"
                        class="nav-link">

                    🏠 Dashboard

                </a>

                <a
                        href="${pageContext.request.contextPath}/products"
                        class="nav-link">

                    📦 Sản phẩm

                </a>

                <a
                        href="${pageContext.request.contextPath}/order"
                        class="nav-link">

                    🛒 Đơn hàng

                </a>

                <a
                        href="${pageContext.request.contextPath}/categories"
                        class="nav-link">

                    📂 Danh mục

                </a>

            </div>

        </div>

    </aside>

    <main class="flex-grow-1 p-4">