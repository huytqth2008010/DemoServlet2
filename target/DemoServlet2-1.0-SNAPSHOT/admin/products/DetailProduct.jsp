<%@ page import="com.example.DemoServlet2.entity.Product" %><%
    Product obj = (Product)request.getAttribute("obj");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<form class="w3-container w3-card-4" action="/products/detail" method="post">
    <h2 class="w3-text-blue">Product Detail</h2>

    <p>
        <label class="w3-text-blue"><b>Name</b></label>
        <span><%=obj.getName()%></span>
    <p>
        <label class="w3-text-blue"><b>Thumbnail</b></label>
        <img src="<%=obj.getThumbnail()%>" style="width: 150%" alt="">
    <p>
        <label class="w3-text-blue"><b>Price</b></label>
        <span><%=obj.getPrice()%> (VND)</span>
    <p>
        <label class="w3-text-blue"><b>Status</b></label>
        <span><%=obj.getStatus()%> </span>
    <p>
</form>

</body>
</html>
