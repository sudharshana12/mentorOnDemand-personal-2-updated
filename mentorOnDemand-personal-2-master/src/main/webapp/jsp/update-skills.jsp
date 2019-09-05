<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.example.models.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<head>
<title>Admin Update Ipo</title>
<link rel="Stylesheet" href="/styles/style.css">
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
				<li class="nav-item"><a class="nav-link" href="/listRequest">Notifications</a></li>
				&nbsp; &nbsp;&nbsp; &nbsp;
				<li class="nav-item"><a class="nav-link"
					href="/User/user-compare-company">Current Trainings</a></li> &nbsp;
				&nbsp;&nbsp; &nbsp;
				<li class="nav-item"><a class="nav-link"
					href="/User/user-compare-sectors">Completed Training</a></li> &nbsp;
				&nbsp;&nbsp; &nbsp;
				<li class="nav-item"><a class="nav-link"
					href="/updateSkills?mentorid%>">Update Skills</a></li>

			</ul>
		</div>
		<div>
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/User/login">Logout</a></li>
			</ul>
		</div>
	</nav>
	<%
		User mentor = (User) request.getAttribute("mentor");
	%>
	<form:form method="POST" action="/updateSkills" modelAttribute="mentor">
		<div>
			<h3 class="text-center" style="margin-top: 20px;">Update Skills</h3>
			<div class="form-group row"
				style="margin-left: 690px; margin-top: 60px">
				<label for="user-id" class="col-sm-2 col-form-label">Mentor Id
				</label>
				<div class="col-sm-3">
					<form:input type="text" path="id" class="form-control" id="user-id"
						value="<%=mentor.getId()%>" readonly="true" />
				</div>
			</div>
			<div class="form-group row"
				style="margin-left: 690px; margin-top: 60px">
				<label for="exp" class="col-sm-2 col-form-label">Years of experience
				</label>
				<div class="col-sm-3">
					<form:input type="text" path="exp" class="form-control"
						id="exp" value="<%=mentor.getExp()%>" />
				</div>
			</div>
			<div class="form-group row"
				style="margin-left: 690px; margin-top: 60px">
				<label for="not" class="col-sm-2 col-form-label">
					No.Of Trainings Taken</label>
				<div class="col-sm-3">
					<form:input type="text" path="numberOfTrainings" class="form-control"
						id="not" value="<%=mentor.getNumberOfTrainings()%>" />
				</div>
			</div>
			<div class="form-group row"
				style="margin-left: 690px; margin-top: 60px">
				<label for="tech" class="col-sm-2 col-form-label">Technologies </label>
				<div class="col-sm-3">
					<form:input type="text" path="technologies" class="form-control"
						id="tech" value="<%=mentor.getTechnologies()%>" />
				</div>
			</div>
			<div class="form-group row"
				style="margin-left: 690px; margin-top: 60px">
				<label for="rating" class="col-sm-2 col-form-label">Self-Rating</label>
				<div class="col-sm-3">
					<form:input type="text" path="rating" class="form-control"
						id="rating" value="<%=mentor.getRating()%>" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10" style="margin-left: 900px; margin-top: 70px;">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div>
		</div>
	</form:form>
	<div class="footer">
		<p class="footer-text">Stock Exchange</p>
	</div>
</body>

</html>