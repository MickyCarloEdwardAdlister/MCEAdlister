<%--
  Created by IntelliJ IDEA.
  User: carlocappellini
  Date: 10/31/17
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new category</title>
</head>
<body>

<div class="container">
    <h1>Log in here!</h1>
    <form action="/category" method="POST">
        <div class="form-group">
            <label for="category-form">category</label>
            <input id="category-form" name="category-form" class="form-control" type="text">
        </div>
        <button type="submit">Create New Category</button>
    </form>
</div>
</body>
</html>
