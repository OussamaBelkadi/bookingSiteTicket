<%--
  Created by IntelliJ IDEA.
  User: electro fatal
  Date: 10/16/2023
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>
<div id="login-overlay" class="modal-dialog container-md ">
    <div class="modal-content">

        <div class="modal-body">
            <div class="row">
                <div class="col-xs-6">
                    <div class="well">
                        <form id="loginForm" method="POST" action="sign-up" novalidate="novalidate">
                            <div class="form-group mb-2">
                                <label for="username" class="control-label">Nom :</label>
                                <input type="text" class="form-control" id="username" name="nom" value="" required="" title="Entrer votre nom" placeholder="Entrer votre nom">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group mb-2">
                                <label for="prenom" class="control-label">Prenom :</label>
                                <input type="text" class="form-control" id="prenom" name="prenom" value="" required="" title="Entrer votre prenom" placeholder="Entrer votre prenom">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group mb-2">
                                <label for="email" class="control-label">Email :</label>
                                <input type="text" class="form-control" id="email" name="email" value="" required="" title="Please enter your email" placeholder="Entrer l'email">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group mb-2">
                                <label for="password" class="control-label">Password :</label>
                                <input type="password" class="form-control" id="password" name="password" value="" required title="Please enter your password" placeholder="Entrer le mot de passe">
                                <span class="help-block"></span>
                            </div>

                            <button type="submit" class="btn btn-success btn-block mb-2">Enregistrer</button>
                        </form>
                    </div>
                </div>
    <form method="post" action="sign-up">
        <input type="input" name="nom">
        <input type="input" name="prenom">
        <input type="input" name="email">
        <input type="input" name="password">
        <button type="submit">Connecter</button>
    </form>
</body>
</html>
