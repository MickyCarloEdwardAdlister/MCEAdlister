<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="create new ad"/>
    </jsp:include>
</head>
<body>


<div class="container">
    <h1>
        Create a new Ad!
    </h1>
    <div class="form-group">
        <form action="/ads/create" method="post">

            <label for="title">Title</label>
            <input type="text" id="title" name="title" class="form-control" value="${title}">
            <c:if test="${adInputError.containsKey('title')}">
            <span class="errors">${adInputError.get('title')}</span>
            </c:if>
    </div>
    <div class="form-group">

        <label for="description">Description</label>
        <input class="form-control" id="description" name="description" type="text" value="${description}">
        <c:if test="${adInputError.containsKey('description')}">
            <span class="errors">${adInputError.get('description')}</span>
        </c:if>

        <%--</div>--%>
        <%--<div>--%>
        <%--<select name="category">--%>
        <%--<option value="0" selected>Select a Category</option>--%>
        <%--<c:forEach var="category" items="${categories}" varStatus="loop">--%>
        <%--<option value="${loop.index + 1}">${category.value}</option>--%>
        <%--</c:forEach>--%>
        <%--</select>--%>
        <%--</div>--%>
        <%--<div>--%>
        <button type="submit" class="btn btn-primary btn-block">
            create new ad
        </button>
    </div>
    </form>
</div>
</body>
</html>
