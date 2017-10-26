<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 10/26/17
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome, <c:out value="${user.username}"/>!</h1>
    <p>Your registered email is <c:out value="${user.email}"/></p>
</div>
</body>
</html>
