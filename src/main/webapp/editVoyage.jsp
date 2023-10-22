<%--
  Created by IntelliJ IDEA.
  User: electro fatal
  Date: 10/19/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container col-9">
    <form action="editComplet" method="post">
        <div class="mb-3">
            <label for="date" class="form-label">Date depart</label>
            <input type="date" class="form-control" id="date" value="${voyage.datedepart}" name="dateDepart" aria-describedby="emailHelp" required>
        </div>
        <div class="mb-3">
            <label for="date1" class="form-label">Date arriver</label>
            <input type="date" value="${voyage.datedarriver}" class="form-control" name="dateArriver" id="date1" required>
        </div>
        <div class="mb-3 form-check">
            <label for="time" class="form-label">Heure depart</label>
            <input type="time" value="${voyage.heuredepart}" name="heureDepart" class="form-control" id="time" required>


        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Heure arriver</label>
            <input type="time" class="form-control" id="exampleInputEmail1" value="${voyage.heuredarriver}" name="heureArriver" required>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ville Depart</label>
            <input type="text" class="form-control" id="ville" value="${voyage.villedepart}" name="villeDepart" required>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Ville Depart</label>
            <input type="text" class="form-control" id="ville2" value="${voyage.villearriver}" name="villeArriver" required>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Place</label>
            <input type="text" class="form-control" id="place" value="${voyage.place}" name="place" >
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Prix</label>
            <input type="text" class="form-control" id="prix" value="${voyage.prix}" name="place" >
        </div>
        <input type="hidden" value="${voyage.id}" name="id">
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
