<%@ page import="entity.Voyages" %><%--
  Created by IntelliJ IDEA.
  User: electro fatal
  Date: 10/21/2023
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%--<%--%>
<%--    Voyages voyage =(Voyages) request.getAttribute("voyage");--%>
<%--    String villeDepart = voyage.getVilledepart();--%>
<%--    Cookie villeArriver = new Cookie("villeArriver",villeDepart);--%>
<%--//    villeArriver.setPath("/");--%>
<%--//    int cookieMaxAge = 60*60*24;--%>
<%--//    villeArriver.setMaxAge(cookieMaxAge);--%>
<%--//    response.addCookie(villeArriver);--%>
<%--//    Cookie flightCookie = new Cookie("flightNumber", "ferda");--%>
<%--//    Cookie flightDeparter = new Cookie("villeDepart", villeArriver);--%>

<%--    // Set the path and expiration time if needed--%>
<%--    //    flightCookie.setPath("/");--%>
<%--//    villeArriver.setPath("/");--%>

<%--    // Set cookie expiration time (in seconds)--%>
<%--    int cookieMaxAge = 60 * 60 * 24; // 24 hours--%>
<%--    villeArriver.setMaxAge(cookieMaxAge);--%>

<%--    // Add the cookies to the response--%>
<%--    response.addCookie(villeArriver);--%>

<%--%>--%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/reserve.css" type="text/css" rel="stylesheet">

</head>
<body>
<div class="reservation-container">
    <div class="left-part">
        <div id="login-container">
            <div class="profile-img"></div>
            <h1>
                Maddie
            </h1>
            <div class="description">

                Maddie is a front end web developer in New York. She has worked in the field for 10 years now. Check out her projects in the links below. She is available for hire as well.
            </div>
            <div class="social">
                <a>Hotel</a>
                <a>Manger</a>
                <a>Assurance</a>
                <p></p>
                <a>${voyage.getVillearriver()}</a>
            </div>
            <form action="reserver">
                <!-- Name input -->
                <div class="form-outline mb-4">
                    <label class="form-label" for="nom">Nom</label>
                    <input type="text" id="nom" name="nom" class="form-control" />
                </div>
                <!-- Name input -->
                <div class="form-outline mb-4">
                    <label class="form-label" for="nom">Prenom</label>
                    <input type="text" id="prenom" name="prenom" class="form-control" />
                </div>

                <!-- Email input -->
                <div class="form-outline mb-4">
                    <label class="form-label" for="email">Email address</label>
                    <input type="email" id="email" name="email" class="form-control" />
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label" for="place">Prix</label>
                    <input type="number" max="30" id="place" name="place" class="form-control"/>
                </div>
                <input name="villeDepart" type="hidden"  value="${voyage.getVilledepart()}">
                <input name="villeArriver" type="hidden"  value="${voyage.getVillearriver()}">
                <input name="dateDepart" type="hidden" value="${voyage.getVilledepart()}">
                <input name="dateArriver" type="hidden" value="${voyage.getDatedarriver()}">
                <input name="heureDepart" type="hidden"   value="${voyage.getHeuredepart()}">
                <input name="heureArriver" type="hidden"   value="${voyage.getHeuredarriver()}">
                <input name="place" type="hidden" value="${voyage.getPlace()}">
                <input name="prix" type="hidden" value="${voyage.getPrix()}">
                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block">Reserver</button>
            </form>

            <footer>
                <div class="likes">
                    <p><i class='fa fa-heart'></i></p>
                    <p>1.5K</p>
                </div>
                <div class="projects">
                    <p>Prix</p>
                    <p>154</p>
                </div>
            </footer>
        </div>
    </div>
    <div class="right-part">
        <div class="company-details">
            <h2>Company Information</h2>
            <p>Company Name</p>
            <p>Address: Company Address</p>
            <p>Phone: Company Phone Number</p>
            <p>Email: Company Email</p>
        </div>
    </div>
</div>
</body>
</html>

