<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>

</head>

<nav class="back navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class=" navbar-header">
            <a class="  title-index navbar-brand lead w3-container w3-center w3-animate-zoom "  href="/ads" id="kraigzlizt">
                <- Kraigzlizt ->
            </a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <form action="/search" method="get">
                <input type="text" name="search">
                <button type="submit">search</button>
            </form>

            <%--if user is null use login button--%>
            <c:if test="${sessionScope.get('user') == null}">
                <li><a href="/login" id="login">Login</a></li>

            </c:if>
            <%--if user is not null use logout button--%>
            <c:if test="${sessionScope.get('user') != null}">
                <li><a href="/logout" id="logout">Logout</a></li>

            </c:if>


            <li><a id="timer"></a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
