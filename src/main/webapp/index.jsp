<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ticket Booking</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="staticPage/header.jsp" />
<!-- Hero Section -->
<header class="jumbotron">
  <div class="container">
    <h1>Welcome to Ticket Booking</h1>
    <p>Find and book tickets for your favorite events.</p>
    <a href="#" class="btn btn-primary btn-lg">Browse Events</a>
  </div>
</header>
<div class="container my-5">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div class="card">
        <div class="card-body">
          <h3 class="card-title text-center">Search for Flights</h3>
          <form action="rechercheVoy" method="post">
            <div class="form-group">
              <label for="departure">Ville depart</label>
              <input type="text" class="form-control" id="departure" name="villeDepart" placeholder="Entrer la ville depart">
            </div>
            <div class="form-group">
              <label for="arrival">Ville d'arriver</label>
              <input type="text" class="form-control" id="arrival"  name="villeArriver" placeholder="Entrer la ville d'arriver">
            </div>
            <div class="form-group">
              <label for="dateDepart">Date depart</label>
              <input type="date" class="form-control" id="dateDepart">
            </div>
            <div class="form-group">
              <label for="dateArriver">Date d'arriver</label>
              <input type="date" class="form-control" id="dateArriver">
            </div>


            <button type="submit" class="btn btn-primary btn-block">Search</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Featured Events Section -->
<section class="container">
  <h2>Featured Events</h2>
  <div class="row">
    <div class="col-md-4">
      <div class="card">
        <img src="event1.jpg" class="card-img-top" alt="Event 1">
        <div class="card-body">
          <h5 class="card-title">Event 1</h5>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          <a href="#" class="btn btn-primary">Buy Tickets</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <!-- Add more event cards here -->
    </div>
    <div class="col-md-4">
      <!-- Add more event cards here -->
    </div>
  </div>
</section>

<!-- Footer -->
<footer class="bg-dark text-light text-center py-3">
  <div class="container">
    &copy; 2023 Ticket Booking
  </div>
</footer>

  <a href="login">Login</a>
  <a href="sign-up">Sign up</a>
</body>
</html>