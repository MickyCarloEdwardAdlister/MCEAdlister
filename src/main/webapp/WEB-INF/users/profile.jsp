<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body id="profile-back">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Welcome to your profile! <c:out value="${user.username}"/></h1>
    <jsp:include page="/WEB-INF/partials/category-option.jsp"/>
    <a href="/ads/create" class="btn btn-primary" id="profile-create-ads"> create your ad</a>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
            <a href="/delete?id=<c:out value="${ad.id}"/>" class="btn btn-primary" id="delete"> Delete Ad</a>
            <br><br>
            <a href="ads/update?id=<c:out value="${ad.id}"/>" class="btn btn-primary" id="updateAd"> updateAd</a>
            <br><br>
            <a href="user/updateUser?id=<c:out value="${user.id}"/>" class="btn btn-primary" id="updateUser"> updateUser</a>
        </div>
    </c:forEach>

<jsp:include page="/WEB-INF/partials/scripts.jsp" />
</div>
</body>
</html>
