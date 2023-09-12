<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Xworkz</title>
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
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top"></a>
			<div>
				<a href="index.jsp">Home</a> <span style="color: white;">Welcome
					${userID}</span> <img src="download?fileName=${dtoPic}" height="50"
					width="80">
			</div>
		</div>
	</nav>
	<div align="center" style="color: green;">These are technology
		were added by : ${userID}</div>

	<form action="searchByKeyword">

		<div style="color: purple;" align="center">
			Search Bar<input type="search" name="keyword" /> <input
				type="submit" value="search" class="btn btn-secondary">
	</form>
	</div>
	<table class="table table-bordered">
		<thead class="thead-dark  ">

			<tr class="table-dark">
				<th scope="col">Technology Name</th>
				<th scope="col">Technology Language</th>
				<th scope="col">Technology Version</th>
				<th scope="col">Technology Owner</th>
				<th scope="col">Support From</th>
				<th scope="col">Support to</th>
				<th scope="col">License</th>
				<th scope="col">Open source</th>
				<th scope="col">OS Type</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="l">
				<tr>
					<td>${l.name}</td>
					<td>${l.language}</td>
					<td>${l.version}</td>
					<td>${l.owner}</td>
					<td>${l.supportFrom}</td>
					<td>${l.supportTo}</td>
					<td>${l.license}</td>
					<td>${l.osType}</td>
					<td>${l.openSource}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="center">
		<a href="view" class="btn btn-info">View Technologies</a>
	</div>
</body>
</html>



