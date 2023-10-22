<%@ page import="entity.Voyages" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: electro fatal
  Date: 10/16/2023
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="createVoyage">create</a>
        </div>
    </nav>
<%--    <button><a href="createVoyage">create</a></button>--%>

<div class="container col-9">
    <table class="table">
        <thead>

        <tr>
            <th>ID</th><th>ville Depart</th><th>ville Arriver</th><th>Date Depart</th><th>Date Arriver</th><th>Heure Depart</th><th>Heure Arriver</th>
        </tr>
        </thead>
        <tbody>
        <% for (Voyages voyages : (List<Voyages>) request.getAttribute("voyages")) { %>
        <tr>
            <form action="editVoy" method="post">
                <td><%= voyages.getId() %></td>
                <td><%= voyages.getDatedepart() %></td>
                <td><%= voyages.getDatedarriver() %></td>
                <td><%= voyages.getVilledepart() %></td>
                <td><%= voyages.getVillearriver() %></td>
                <td><%= voyages.getHeuredepart() %></td>
                <td><%= voyages.getHeuredarriver() %></td>
                <td><%= voyages.getPlace() %></td>
                <input type="hidden" name="id" value="<%= voyages.getId() %>">
                <td><button type="submit" class="bg-success text-white">Edit</button></td>
            </form>
            <form action="supVoy" method="post">
                <input type="hidden" name="id" value="<%= voyages.getId() %>">
                <td><button type="submit" class="bg-danger text-white">Supr</button> </td>
            </form>

            <!-- Add more columns as needed -->
        </tr>
        <% } %>

<%--        <c:forEach items="${voyages}" var="voyage">--%>
<%--            <tr>--%>
<%--                <td>${voyage.id}</td>--%>
<%--                <td>${voyage.villeDepart}</td>--%>
<%--                <td>${voyage.villeArriver}</td>--%>
<%--                <!-- Add more columns as needed -->--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        </tbody>

    </table>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>