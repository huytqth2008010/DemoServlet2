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

<form class="w3-container w3-card-4" action="/products/edit" method="post">
    <h2 class="w3-text-blue">Edit Product</h2>

    <p>
        <label class="w3-text-blue"><b>Name</b></label>
        <input type="hidden" name="id" value="<%=obj.getId()%>">
        <input class="w3-input w3-border" name="name" type="text" value="<%=obj.getName()%>"></p>
    <p>
        <label class="w3-text-blue"><b>Thumbnail</b></label>
        <input class="w3-input w3-border" name="thumbnail" type="text" value="<%=obj.getThumbnail()%>"></p>
    <p>
        <label class="w3-text-blue"><b>Price</b></label>
        <input class="w3-input w3-border" name="price" type="number" value="<%=obj.getPrice()%>"></p>

    <p>
        <label class="w3-text-blue"><b>Status</b></label>
        <input class="w3-input w3-border" name="status" type="number" value="<%=obj.getStatus()%>"></p>

    <p>
        <button class="w3-btn w3-blue" type="submit">Submit</button>
        <input type="reset" class="w3-btn w3-teal" value="Reset">
    </p>
</form>

</body>
</html>
