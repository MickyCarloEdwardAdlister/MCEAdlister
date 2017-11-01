<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 10/30/17
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update" />
    </jsp:include>
</head>
<body>
<div class = "container">

    <h2>Update ads information</h2>

    <form action="/ads/update" method="post">

        <input type="hidden" name="id" value="${ad.id}">

        <div class = "form-group">
            <label for = "title">title</label>
            <input type="text" id="title" name="title" class = "form-control" value="${ad.title}">
            <c:if test="${errors.containsKey('title')}">
                <p>${errors.get('title')}</p>
            </c:if>
        </div>

        <div class = "form-group">
            <label for = "description">description</label>
            <input type="text" id="description" name="description" class = "form-control" value="${ad.description}">
            <c:if test="${errors.containsKey('description')}">
                <p>${errors.get('description')}</p>
            </c:if>
        </div>

        <button type = "update"  class="btn btn-primary btn-block">Update</button>

    </form>
</div>
</body>
</html>
