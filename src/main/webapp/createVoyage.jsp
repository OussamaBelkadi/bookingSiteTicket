<%--
  Created by IntelliJ IDEA.
  User: electro fatal
  Date: 10/17/2023
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>
    <form action="createVoyage" method="post">
        <input name="villeDepart" type="text" placeholder="Ville Depart">
        <input name="villeArriver" type="text" placeholder="Ville Arriver">
        <input name="dateDepart" type="date">
        <input name="dateArriver" type="date">
        <input name="heureDepart" type="time"  pattern="[0-9]{2}:[0-9]{2}">
        <input name="heureArriver" type="time"  pattern="[0-9]{2}:[0-9]{2}">
        <input name="place" type="number" min="0" max="30" placeholder="les nombre du place">
        <input name="prix" type="number" min="0"  placeholder="le prix du place">
        <input type="submit" value="create">

    </form>
</body>
</html>
