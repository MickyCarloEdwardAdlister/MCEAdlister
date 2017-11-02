<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body id="profile-back">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <div style="height: 30px">
        <h1 class="awesome text-left" id="welcome">Welcome!</h1>
    </div>
    <div style="height: 40px">
        <h3 id="profile-user-name"><c:out value="${sessionScope.user.username}"/></h3>
    </div>
    <div style="height: 40px">
        <h3> here are your ads </h3>
    </div>

    <c:forEach var="ad" items="${ads}">
        <div id="cont">
        <div id="ad-title-profile"class="center-text" style="height: auto; width: auto; border: 2px solid black;">
            <h2 style="overflow: auto;" class="text-center"><c:out value="${ad.title}"/></h2>
        </div>
        <div id="ad-description-profile" class="center-text" style="height: auto; width: auto; border: 2px solid black;">
            <p style="overflow: auto;"><c:out value="${ad.description}"/></p>
        </div>
        <div style="height: auto; width: auto;">
            <a href="/delete?id=<c:out value="${ad.id}"/>" class="btn btn-primary" id="delete"> Delete Ad</a>
            <a href="ads/update?id=<c:out value="${ad.id}"/>" class="btn btn-primary" id="update"> update</a>
        </div>
        </div>
    </c:forEach>
    </div>
</div>


<jsp:include page="/WEB-INF/partials/scripts.jsp" />


</div>
</body>
</html>
