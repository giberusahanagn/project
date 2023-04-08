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
	<nav class="navbar navbar-dark bg-dark">
		<a> <img alt=""
			src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
			width="200" height="100" /></a> <a class="nav-link" href="Army.jsp">Army</a>
		<a class="nav-link" href="ArmySearch.jsp">Search By Id </a>  <a
			class="nav-link" href="index.jsp">Home</a>
	</nav>

	<form action="searchByCountry" method="get">
		Search By Country<input class="form-control form-control-lg" type="text" name="country"> <input
			type="submit" value="Seach Country" class="btn btn-success" />
	</form>
	
	<table border="1" class="table">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Country</th>
			<th>Age</th>
			<th>Punishment</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${dtos}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td>${c.country}</td>
				<td>${c.age}</td>
				<td>${c.punishment}</td>
				<td><a href="update?id=${c.id}">Edit</a></td>

				<td><a href="delete?id=${c.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</body>
</html>