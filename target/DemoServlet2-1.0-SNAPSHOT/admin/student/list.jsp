<%@ page import="java.util.List" %>
<%@ page import="com.example.DemoServlet2.entity.Student" %>
<%
    List<Student> list = (List<Student>)request.getAttribute("listStudent");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<div class="w3-container">
    <a href="/student/create" class="w3-btn w3-ble">Create New Student </a>
    <table class="w3-table-all w3-card-4" >
        <tr>
            <th>Id</th>
            <th>RollNumber</th>
            <th>Email</th>
            <th>Name</th>
        </tr>
        <%
            for (int i = 0; i < list.size(); i++) {
                Student st = list.get(i);
        %>
        <tr>
            <td><%=st.getId()%>></td>
            <td><%=st.getRollNumber()%>></td>
            <td><%=st.getEmail()%>></td>
            <td><%=st.getName()%>></td>
        </tr>
        <%
            }

        %>
    </table>
</div>
</body>