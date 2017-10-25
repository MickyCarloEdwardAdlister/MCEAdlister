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
<form>
    <jsp:include page="partials/head.jsp" />
    <div class="container">
        <h1>Please Register</h1>

        <form action="/register" method="post">
            <div class="form-group">
                username : <input id="username" name="username" class="form-control" type="text">
            </div>

            <div class="form-group">
                email : <input id="email" name="email" class="form-control" type="text">
            </div>

            <div class="form-group">
                password : <input id="password" class="form-control" type="password">
            </div>
            <button type="submit">Register</button>

        </form>

    </div>
</form>

</body>
</html>
