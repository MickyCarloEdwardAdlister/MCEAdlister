<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
</head>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<body  class="index_background">
<div class="container">
    <h1 id="login-here-form">Log in here!</h1>
    <form action="/login" method="POST">
        <div class="form-group">
            <label for="username" id="user-log">Username</label>
         <input id="username" name="username" class="form-control" type="text" required>
        </div>

        <div class="form-group">
            <label for="password" id="pass-log">Password</label>
            <input id="password" name="password" class="form-control" type="password"required>
        </div>

        <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon-glyphicon-user"></span>login</button>
    </form>
</div>
<script src="/resources/jquery/j-query.js" type="text/javascript"></script>
<script src = "/resources/jquery/jquery-ui.js" type="text/javascript"></script>
<script src="/resources/js/some.js" type="text/javascript"></script>
</body>
</html>


