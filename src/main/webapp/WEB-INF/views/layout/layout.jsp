<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Mini Store</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link
        rel="stylesheet"
        href="${pageContext.request.contextPath}/assets/css/home.css">

    <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/glightbox/dist/css/glightbox.min.css">

</head>

<body>

    <!-- Header -->
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

    <div class="d-flex">

        <!-- Sidebar -->
        <jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />

        <!-- Content -->
        <main class="flex-grow-1 p-4">

            <jsp:include page="${contentPage}" />

        </main>

    </div>

    <!-- Footer -->
    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
    </script>
    <script
        src="https://cdn.jsdelivr.net/npm/glightbox/dist/js/glightbox.min.js">
    </script>

</body>

</html>