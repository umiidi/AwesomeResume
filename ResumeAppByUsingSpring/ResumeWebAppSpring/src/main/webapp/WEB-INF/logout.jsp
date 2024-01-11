<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="logout_background">

<form action="logout" method="POST">
    <div class="col-4 container login_fix_">
        <h1 style="text-align: center">Logout</h1>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

        <button type="submit" class="btn btn-primary" name="logout">Logout</button>
    </div>
</form>
</body>
</html>
