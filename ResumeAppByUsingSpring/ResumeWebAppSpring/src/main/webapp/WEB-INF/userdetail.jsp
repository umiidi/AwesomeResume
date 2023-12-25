<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User u = (User) request.getAttribute("user");
%>
<div>
    <form action="users.jsp" method="GET">
        <label for="name">name:</label>
        <input type="text" name="name" value=<%=u.getName()%>>
        <label for="surname">surname:</label>
        <input type="text" name="surname" value=<%=u.getSurname()%>>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>


</body>
</html>