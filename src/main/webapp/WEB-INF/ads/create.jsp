<%--
  Created by IntelliJ IDEA.
  User: carlocappellini
  Date: 10/25/17
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create new ad</title>
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
        <button type = "submit">
            create new ad
        </button>
    </form>
</div>
</body>
</html>
