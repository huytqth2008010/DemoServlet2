<%@ page import="java.util.List" %>
<%@ page import="com.example.DemoServlet2.entity.Product" %>
<%
    List<Product> list = (List<Product>)request.getAttribute("listObj");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<div class="w3-container">
    <a href="/products/create" class="w3-btn w3-ble">Create New Product </a>
    <table class="w3-table-all w3-card-4" >
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Thumbnail</th>
            <th>Price</th>
            <th>Status</th>
        </tr>
        <%
            for (int i = 0; i < list.size(); i++) {
                Product obj = list.get(i);
        %>
        <tr>
            <td><%=obj.getId()%></td>
            <td><%=obj.getName()%></td>
            <td><img src="<%=obj.getThumbnail()%>" style="width: 150px" alt=""></td>
            <td><%=obj.getPrice()%></td>
            <td><%=obj.getStatus()%></td>
            <td>
                <a href="/products/detail?id=<%=obj.getId()%>">Detail</a>
                <a href="/products/edit?id=<%=obj.getId()%>">Edit</a>
                <a href="/products/delete?id=<%=obj.getId()%>" class="btn-delete">Delete</a>
            </td>
        </tr>
        <%
            }

        %>
    </table>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        let listDeleteButton = document.querySelectorAll('.btn-delete');
        for (let i = 0; i < listDeleteButton.length; i++) {
            listDeleteButton[i].addEventListener('click', function (event) {
                event.preventDefault();
                if (confirm('Are you sure ?')){
                     let xhr = new XMLHttpRequest();
                     xhr.onreadystatechange = function () {
                         if (xhr.readyState == 4 && xhr.status == 200){
                             alert('Delete success');
                             window.location.href = "/products";
                         }
                     }
                     xhr.open('POST', this.href, false);
                     xhr.send();
                }
            })
        }
    })
</script>
</body>