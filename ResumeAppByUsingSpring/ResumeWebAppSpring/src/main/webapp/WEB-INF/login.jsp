<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="login_background">

<form action="login" method="POST">
    <div class="col-4 container login_fix_">
        <h1 style="text-align: center">Login</h1>
        <div class="form-group">
            <label>Email address</label>
            <input type="email" class="form-control" placeholder="email@example.com" name="username">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" placeholder="Password" name="password">
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary" name="login">Login</button>
    </div>
</form>
</body>
</html>
