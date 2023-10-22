<%--
  Created by IntelliJ IDEA.
  User: electro fatal
  Date: 10/16/2023
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container text-center mt-4">
    <h1 class="text-primary">Login Form</h1>
</div>
<%--<div class="container">--%>
<%--    <form method="post" action="login" class="cantainer">--%>
<%--        <input type="input" name="email">--%>
<%--        <input type="input" name="password">--%>
<%--        <button type="submit" class="bg-primary">Connecter</button>--%>

<%--    </form>--%>
<div class="container col-9">
     <div id="login-overlay" class="modal-dialog ">
        <div class="modal-content">

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="well">
                            <form id="loginForm" method="POST" action="login" novalidate="novalidate">
                                <div class="form-group mb-2">
                                    <label for="email" class="control-label">Email :</label>
                                    <input type="text" class="form-control" id="email" name="email" value="" required="" title="Please enter you username" placeholder="example@gmail.com">
                                    <span class="help-block"></span>
                                </div>
                                <div class="form-group mb-2">
                                    <label for="password" class="control-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" value="" required="" title="Please enter your password" placeholder="Please enter your password">
                                    <span class="help-block"></span>
                                </div>
                                <button type="submit" class="btn btn-success btn-block mb-2">Login</button>
                            </form>
                        </div>
                    </div
                </div>
<%--</div>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
