<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carlocappellini
  Date: 10/25/17
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<title>register new user</title>
</head>
<body>

    <jsp:include page="partials/head.jsp" />
    <div class="container">
        <h1>Please Register</h1>

        <c:if test="${error != null}">
            <p>${error}</p>
        </c:if>

        <form action="/register" method="post">
            <div class="form-group">
                username : <input id="username" name="username" class="form-control" type="text">
            </div>

            <div class="form-group">
                email : <input id="email" name="email" class="form-control" type="text">
            </div>

            <div class="form-group">
                password : <input id="password" class="form-control" name="password" type="password">
            </div>

            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <button type="submit">Register</button>

        </form>

    </div>


</body>
</html>
