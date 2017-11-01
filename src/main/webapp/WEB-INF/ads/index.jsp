<%--
  Created by IntelliJ IDEA.
  User: carlocappellini
  Date: 10/25/17
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <form action="/cat" method="get">
        <select name="searchCat">
            <option value="0" selected disabled>Search by Category</option>
            <c:forEach var="category" items="${categories}" varStatus="loop">
                <option value="${loop.index + 1}">${category.value}</option>
            </c:forEach>
        </select>
        <button class="btn btn-primary">Submit</button>
    </form>

    <h1>Here are all the Ads:</h1>


    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
                <h2><c:out value="${ad.title}"/></h2>
                <p><c:out value="${ad.description}"/></p>
                <p><c:out value="${ad.category}"/></p>

        </div>
        <a href="/ads">see details</a>
    </c:forEach>
</div>
</form>

</body>
</html>
