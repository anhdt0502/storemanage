<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />

<div class="container-fluid">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1>Sửa danh mục</h1>
    </div>

    <form
            method="post"
            action="${pageContext.request.contextPath}/categories">

        <input
                type="hidden"
                name="action"
                value="update">

        <input
                type="hidden"
                name="id"
                value="${category.id}">

        <div class="mb-3">
            <label class="form-label">
                Tên danh mục
            </label>

            <input
                    type="text"
                    name="name"
                    class="form-control"
                    value="${category.name}"
                    required>
        </div>

        <div class="mb-3">
            <label class="form-label">
                Mô tả
            </label>

            <textarea
                    name="description"
                    class="form-control"
                    rows="4">${category.description}</textarea>
        </div>

        <button
                type="submit"
                class="btn btn-primary">
            Lưu thay đổi
        </button>

        <a
                href="${pageContext.request.contextPath}/categories"
                class="btn btn-secondary">
            Quay lại
        </a>

    </form>

</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />