<%@ page import="java.sql.Time" %>
<%@ page import="java.util.Timer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
</head>
<body class="index_background">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>


<div class="container-fuid">
    <p><i class="fa fa-spinner w3-spin" style="font-size:64px"></i></p>

    <div class="w3-container w3-center w3-animate-zoom">
    </div>

</div>
<div id="kraigslist-p">
    <p class="text-center" id="indexText">
        "kraigslizt,  A place for creepy people..."
    </p>
</div>

<jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>