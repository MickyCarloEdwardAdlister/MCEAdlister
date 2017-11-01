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
<body class="index_background">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<jsp:include page="partials/head.jsp"/>
<div class="container">
    <h1 id="register-form">Please Register</h1>

    <c:if test="${error != null}">
        <p>${error}</p>
    </c:if>

    <form action="/register" method="post">
        <div class="form-group">
            <label for="username" id="user-reg">Username</label> <input id="username" name="username"
                                                                        class="form-control" type="text" required>
        </div>

        <div class="form-group">
            <label for="email" id="email-reg">email</label><input id="email" name="email" class="form-control"
                                                                  type="text" required>
        </div>

        <div class="form-group">
            <label for="password" id="pass-reg">Password</label> <input id="password" class="form-control"
                                                                        name="password" type="password" required>
        </div>

        <div class="form-group">
            <label for="confirm_password" id="con-pass-reg">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Register</button>

    </form>

</div>
<script src="/resources/jquery/j-query.js" type="text/javascript"></script>
<script src="/resources/jquery/jquery-ui.js" type="text/javascript"></script>
<script src="/resources/js/some.js" type="text/javascript"></script>


</body>
</html>
