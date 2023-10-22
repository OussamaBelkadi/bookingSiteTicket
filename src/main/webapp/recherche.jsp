<%@ page import="entity.Voyages" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: electro fatal
  Date: 10/20/2023
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page de recherche</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleRecherche.css"  >

</head>
<body>
<jsp:include page="staticPage/header.jsp" />
<section class="adv-Flight">
    <h5 class="title-adv">BON VOYAGE</h5>
</section>
<section class="page-recherche">
    <div class="left-parte">
        <% for (Voyages voyages : (List<Voyages>) request.getAttribute("voyages")) { %>

        <div class="ticket">
            <div class="header">
                <div class="left-side">
                    <img src="${pageContext.request.contextPath}/image/Logo/logo.png" class="image_logo_ticket">
                </div>
                <div class="right-side">
                    <h6>Postsnap</h6>
                </div>
            </div>
            <div class="ticket-body">
                <div class="depart">
                        <p class="title">Ville depart :</p>
                        <h5><%= voyages.getVilledepart()%></h5>
                        <p class="title">Date depart :</p>
                        <h6><%= voyages.getDatedepart()%></h6>
                        <p class="title">Heure depart :</p>
                        <h6><%= voyages.getHeuredepart()%></h6>
                </div>

                <div class="meduim">
                <img src="${pageContext.request.contextPath}/image/plane/plane.png" class="image_plane">
                </div>

                <div class="arriver">
                        <p class="title">Ville arriver :</p>
                        <h5><%= voyages.getVillearriver()%></h5>
                        <p class="title">Date arriver :</p>
                        <h6><%= voyages.getDatedarriver()%></h6>
                        <p class="title">Heure arriver :</p>
                        <h6><%= voyages.getHeuredarriver()%></h6>
                </div>
                <div class="reserve-bar">
                    <h6><%= voyages.getPrix()%>$</h6>
                    <button class="btn bg-pramiry-subtle reserve-btn"><a href="reserve?id=<%= voyages.getId()%>">Reserver</a></button>
                </div>
            </div>
        </div>

        <% } %>
    </div>
    <div class="right-parte">

    </div>
</section>
</body>
</html>
