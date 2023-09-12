<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>X-workz</title>
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">

			<a class="navbar-brand" href="#"> <img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="150" height="55" class="d-inline-block align text-top">
				<div>
					<a href="index.jsp">Home</a> <span style="color: white;">Welcome:${userID}</span>
					<span> <img src="download?fileName=${dtoPic}" height="70"
						width="80">
					</span>
				</div>
		</div>
	</nav>
	<div align="center">
		User Name:${userId}
		<h1>Welcome to success page,</h1>
		<!--  <h1 style="color: green;">${UpdateSuccess}</h1>-->
		<a href="update?userId=${userID}">Update Profile</a> <br> <a
			href="addTechnology">addTechnology</a> <br> <a
			href="KnownTechnology.jsp">KnownTechnology</a>

	</div>
</body>
</html>