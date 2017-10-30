<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 10/30/17
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<div class = "container">

    <h2>Update ads information</h2>

    <form action="/ads/create" method="post">

        <div class = "form-group">
            <label for = "title">title</label>
            <input type="text" id="title" name="title" class = "form-control">
        </div>

        <div class = "form-group">
            <label for = "description">description</label>
            <input type="text" id="description" name="description" class = "form-control">
        </div>

        <button type = "update"  class="btn btn-primary btn-block">Update</button>

    </form>
</div>
</body>
</html>
