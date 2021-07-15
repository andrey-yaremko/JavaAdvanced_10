<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bucket.css">
</head>
<body>
<h3> Welcome, this is your personal cabinet</h3>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">

        <h1>Basket of Product</h1>
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search" title="Type in a name">

        <table id="myTable">

        </table>
    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="js/header.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/header.js"></script>
<script src="js/bucket.js"></script>

</body>
</html>
