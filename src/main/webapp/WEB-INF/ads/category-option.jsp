<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
    <form action="/category" method="POST">
        <div class="form-group">
            <select name="searchCategories">
                <option value="0" selected disabled>Search by Category</option>
                <c:forEach var="category" items="${categories}" varStatus="loop">
                    <option value="${loop.index + 1}">${category.value}</option>
                    <option href="/category">--Add New Category--</option>
                </c:forEach>

            </select>
            <button type="submit" class="btn btn-primary">search</button>

        </div>

    </form>
</div>