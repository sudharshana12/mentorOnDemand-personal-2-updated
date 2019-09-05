<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,com.example.models.User" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<head>
<title>User Landing Page</title>
<link rel="Stylesheet" href="/styles/style.css">
<link rel="Stylesheet" href="/styles/style1.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><img src="/images/page-icon.png"
			width="30" height="30" alt=""> Mentor On Demand</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/user-landing-page">Home <span class="sr-only">(current)</span></a>
				</li> &nbsp;&nbsp; &nbsp; &nbsp;
				<li class="nav-item"><a class="nav-link" href="/user-landing-page">Search
						Trainings</a></li> &nbsp; &nbsp;&nbsp; &nbsp;
				<li class="nav-item"><a class="nav-link"
					href="/User/user-compare-company">Current Trainings</a></li> &nbsp;
				&nbsp;&nbsp; &nbsp;
				<li class="nav-item"><a class="nav-link"
					href="/User/user-compare-sectors">Completed Training</a></li> &nbsp;
				&nbsp;&nbsp; &nbsp;
				<li class="nav-item"><a class="nav-link"
					href="/User/user-update-page">Update Profile</a></li>

			</ul>
		</div>
		<div>
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/User/login">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="page-body">
		<div class="box">
			<form method="POST" action="/search">

				<input type="text" placeholder="Search.." name="searchValue">
				<input type="submit" value="Search">
			</form>
		</div>
	</div>
	
		<div class="footer">
			<p class="footer-text">Stock Exchange</p>
		</div>
</body>

</html>