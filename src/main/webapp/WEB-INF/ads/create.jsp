<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="create new ad" />
</jsp:include>

</head>
<body>


<div class = "container">
    <h1>
        Create a new Ad!
    </h1>
    <form action="/ads/create" method="post">
        <div class = "form-group">
            <label for = "title">title</label>
            <input type="text" required id="title" name="title" class = "form-control">
        </div>
        <div class = "form-group">
            <label for = "description">description</label>
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text" required></textarea>
        </div>
        <select name="category">
            <option value="0" selected>Select a Category</option>
            <c:forEach var="category" items="${categories}" varStatus="loop">
                <option value="${loop.index + 1}">${category.value}</option>
            </c:forEach>
        </select>
        <button type = "submit"  class="btn btn-primary btn-block">
            create new ad
        </button>
    </form>
</div>
</body>
</html>
