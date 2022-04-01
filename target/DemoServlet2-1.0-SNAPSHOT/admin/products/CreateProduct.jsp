<%@ page import="java.util.HashMap" %><%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null){
        errors = new HashMap<>();
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<form class="w3-container w3-card-4" action="/products/create" method="post">
    <h2 class="w3-text-blue">Create Product</h2>
    <%
        if (errors != null && errors.size() >0){
    %>
    <div class="w3-pannel w3-pale-red w3-border">
        <h3>Please fix error below !</h3>
        <ul>
            <%
                for (String message:
                     errors.values()) {
            %>
                <li><%=message%></li>
            <%
               }
            %>
        </ul>
    </div>
    <%
        }
    %>
    <p>
        <label class="w3-text-blue"><b>Name</b></label>
        <input class="w3-input w3-border" name="name" type="text"></p>
        <%if (errors.containsKey("name")){%>
               <span class="w3-text-red">* <%=errors.get("name")%></span>
        <%}%>

    <p>
        <label class="w3-text-blue"><b>Thumbnail</b></label>
        <input class="w3-input w3-border" name="thumbnail" type="text"></p>
        <%if (errors.containsKey("thumbnail")){%>
        <span class="w3-text-red">* <%=errors.get("thumbnail")%></span>
        <%}%>
    <p>
        <label class="w3-text-blue"><b>Price</b></label>
        <input class="w3-input w3-border" name="price" type="number" value="0"></p>
        <%if (errors.containsKey("price")){%>
        <span class="w3-text-red">* <%=errors.get("price")%></span>
        <%}%>

    <p>
        <button class="w3-btn w3-blue">Submit</button>
        <input type="reset" class="w3-btn w3-teal" value="Reset"><%if (errors.containsKey("Name")){%>
        <span class="w3-text-red">* <%=errors.get("name")%></span>
        <%}%>
    </p>
</form>

</body>
</html>
