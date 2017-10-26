<%--
  Created by IntelliJ IDEA.
  User: carlocappellini
  Date: 10/25/17
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="create new ad" />
</jsp:include>

</head>
<body>


<div class = "container">
    <h1>
        Create a new Ad!
    </h1>
    <form action="/ads/create" method="post">
        <div class = "form-group">
            <label for = "title">title</label>
            <input type="text" id="title" name="title" class = "form-control">
        </div>
        <div class = "form-group">
            <label for = "description">description</label>
            <input type="text" id="description" name="description" class = "form-control">
        </div>
        <button type = "submit"  class="btn btn-primary btn-block">
            create new ad
        </button>
    </form>
</div>
</body>
</html>
