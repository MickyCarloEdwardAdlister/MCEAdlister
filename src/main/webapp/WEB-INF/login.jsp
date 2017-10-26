<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 10/25/17
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Log in here Amigos!</h1>
    <form action="/login" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
         <input id="username" name="username" class="form-control" type="text">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>

        <button type="submit" class="btn btn-primary btn-block">login</button>
    </form>
</div>

</body>
</html>


