<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<div class="product-container">

    <c:forEach var="product" items="${products}">

        <div class="product-card">

            <a
                    href="${pageContext.request.contextPath}/assets/images/${product.imageUrl}"
                    class="glightbox"
                    data-gallery="product-gallery"
                    title="${product.name}">

                <c:choose>

                    <c:when test="${not empty product.imageUrl}">

                        <img
                                src="${pageContext.request.contextPath}/assets/images/${product.imageUrl}"
                                alt="${product.name}"
                                class="product-img">

                    </c:when>

                    <c:otherwise>

                        <img
                                src="${pageContext.request.contextPath}/assets/images/default.png"
                                alt="No image"
                                class="product-img">

                    </c:otherwise>

                </c:choose>

            </a>

            <div class="product-price">

                <fmt:formatNumber
                        value="${product.price}"
                        type="number"
                        groupingUsed="true"
                        maxFractionDigits="0" />

                đ

            </div>

            <div class="product-name">

                <strong>
                    ${product.name}
                </strong>

            </div>

            <div class="product-description">

                ${product.description}

            </div>

        </div>

    </c:forEach>

</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {

        GLightbox({
            selector: ".glightbox"
        });

    });
</script>