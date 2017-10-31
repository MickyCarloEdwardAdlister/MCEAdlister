<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 10/31/17
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="email" value="UpdateUser" />
        </jsp:include>
    </head>
<body>
<div class = "container">

    <h2>Update users information</h2>

    <form action="/user/updateUser" method="post">

        <input type="hidden" name="id" value="${user.id}">

        <div class = "form-group">
            <label for = "email">Email</label>
            <input type="text" id="email" name="email" class = "form-control" value="${user.email}">
            <c:if test="${errors.containsKey('email')}">
                <p>${errors.get('email')}</p>
            </c:if>
        </div>

        <button type = "updateUser"  class="btn btn-primary btn-block">UpdateUser</button>

    </form>
</div>
</body>
</html>
