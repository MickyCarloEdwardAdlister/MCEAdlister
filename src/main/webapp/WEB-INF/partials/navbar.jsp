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
            <a class=" title-index navbar-brand lead w3-container w3-center w3-animate-zoom " href="/profile"
               id="kraigzlizt">
                <- Kraigzlizt ->
            </a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${sessionScope.get('user') == null}">
                    <li class="navb"><a href="/login" id="login">Login</a></li>
                    <li class="navb" id="navSearch">
                        <form action="/search" method="get" class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" name="search" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-primary">Search Ads</button>
                        </form>
                    </li>
                    <li><a id="timer"></a></li>
                </c:when>
                <c:when test="${sessionScope.get('user') != null}">
                    <li class="navb"><a href="/logout" id="logout">Logout</a></li>
                    <li class="navb"><a href="/ads" id="view">View All Ads</a></li>
                    <li class="navb" id="navSearch">
                        <form action="/search" method="get" class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" name="search" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-primary">Search Ads</button>
                        </form>
                    </li>
                    <li><a id="timer"></a></li>


                </c:when>
            </c:choose>




        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
