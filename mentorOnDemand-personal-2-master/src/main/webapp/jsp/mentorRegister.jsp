<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>User Registeration Page</title>
<link rel="Stylesheet" href="/styles/login-style.css">
</head>
<body>

	<div class="regiterationbox1">

		<h1 class="reg-heading">Registeration</h1>
		<form:form method="POST" action="/registerMentor" modelAttribute="mentor">
			<p>Enter username</p>
			<form:input type="text" path="name" name="uname"
				placeholder="Enter username" required="required"  />
				 <div class="has-error">
                        <form:errors path="name" class="text-danger"/>
                    </div>
			<p>Enter Password</p>
			<form:input type="password" path="password" name="password"
				placeholder="Enter password" required="required" />
				<div class="has-error">
                        <form:errors path="password" class="text-danger"/>
                    </div>

			<p>Enter EmailId</p>
			<form:input type="text" path="email" name="email"
				placeholder="Enter Email" required="required"/>
				<div class="has-error">
                        <form:errors path="email" class="text-danger"/>
                    </div>
			<p>Enter Mobile Number</p>
			<form:input type="text" path="mobileno" name="mobile"
				placeholder="Enter mobile number" required="required" />
				<div class="has-error">
                        <form:errors path="mobileno" class="text-danger"/>
                    </div>
                    <p>Enter years of experience</p>
			<form:input type="text" path="exp" name="mobile"
				placeholder="Enter experience" required="required" />
				<div class="has-error">
                        <form:errors path="mobileno" class="text-danger"/>
                    </div>
                    <p>Enter years of timezone</p>
			<form:input type="text" path="timezone" name="mobile"
				placeholder="Enter timezone" required="required" />
				<div class="has-error">
                        <form:errors path="mobileno" class="text-danger"/>
                    </div>
                    <p>Linkedin URL</p>
			<form:input type="text" path="linkedin_URL" name="mobile"
				placeholder="Enter url" required="required" />
				<div class="has-error">
                        <form:errors path="mobileno" class="text-danger"/>
                    </div>
                    <p>Enter facilities you provide</p>
			<form:input type="text" path="facilities" name="mobile"
				placeholder="Enter materials provided" required="required" />
				<div class="has-error">
                        <form:errors path="mobileno" class="text-danger"/>
                    </div>
                    <p>Enter list of technologies</p>
			<form:input type="text" path="technologies" name="mobile"
				placeholder="Enter technologies" required="required" />
				<div class="has-error">
                        <form:errors path="mobileno" class="text-danger"/>
                    </div>
			<input type="submit" name="sumbit" value="Register">
			<a href="/loginUser">Already have an account?SignIn Here!</a>
		</form:form>
	</div>

</body>
</html>