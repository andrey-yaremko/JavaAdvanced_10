<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 15.06.2021
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h3> Welcome, this is your personal cabinet</h3>
<jsp:include page="header.jsp"></jsp:include>
<form class="createProduct">
    <div class="form-group">

        <input
                type="text"
                class="productName"
                placeholder="enter product name">
    </div>
    <div class="form-group">

        <input
                type="text"
                class="ProductDescription"
                placeholder="enter description name">
    </div>
    <div class="form-group">

        <input
                type="text"
                class="ProductPrice"
                placeholder="enter product price">
    </div>
    <button type="submit" class="createProduct">Submit</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="js/serverCalls.js"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/header.js"></script>

</body>
</html>
