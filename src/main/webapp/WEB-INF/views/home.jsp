<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ - Mini Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/home.css">
        <!-- Nhúng CSS của Glightbox -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/glightbox/dist/css/glightbox.min.css" />

        <!-- Nhúng JS của Glightbox trước thẻ đóng </body> -->
        <script src="https://cdn.jsdelivr.net/npm/glightbox/dist/js/glightbox.min.js"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/layout/header.jsp" />
    <jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />

    <div class="product-container py-4">
        <c:forEach var="product" items="${products}">
            <div class="product-card row g-3">
            <a href="${pageContext.request.contextPath}/assets/images/${product.imageUrl}"
                   class="glightbox"
                   data-gallery="product-gallery"
                   title="${product.name}">
                <!-- Sử dụng đúng trường imageUrl từ Product.java -->
                <c:choose>
                    <c:when test="${not empty product.imageUrl}">
                        <img src="${pageContext.request.contextPath}/assets/images/${product.imageUrl}"
                             alt="${product.name}" class="product-img">
                    </c:when>
                    <c:otherwise>
                        <img src="${pageContext.request.contextPath}/assets/images/default.png" alt="No image" class="product-img">
                    </c:otherwise>
                </c:choose>
                </a>

                <div class="product-price text-danger fw-bold">
                    <fmt:formatNumber value="${product.price}" type="number" groupingUsed="true" maxFractionDigits="0" /> đ
                </div>

                <div class="product-name">
                    <strong>${product.name}</strong>
                </div>



                <div class="product-description">
                    ${product.description}
                </div>

            </div>
        </c:forEach>
    </div>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />

</body>
</html>