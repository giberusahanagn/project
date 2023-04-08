<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<nav style="background-color: black;">
		<nav class="navbar navbar-dark bg-dark">
			<a> <img alt=""
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				width="200" height="100" /></a> <a class="nav-link"
				href="Army.jsp">Army</a> <a class="nav-link"
				href="index.jsp">Home</a> <a class="nav-link"
				href="CountrySearch.jsp">Search By Country</a>
		</nav>
	</nav>

	<h4 style="color: red">${display}</h4>
	<form action="search" method="post">

		Search By Id<input class="form-control form-control-lg" type="number"
			name="id" /> <input type="submit" value="Search"
			class="btn btn-success" /> </form>
	<h4> Name:${dto.name}<br> Country:${dto.country}<br>
		Age:${dto.age}<br> Punishment:${dto.punishment}</h4>	
	

</body>
</html>