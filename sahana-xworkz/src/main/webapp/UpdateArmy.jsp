<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
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
		<a class="nav-link" href="ArmySearch.jsp">Search By Id </a>
		<a class="nav-link" href="CountrySearch">Search By Country</a> 
		 <a class="nav-link" href="index.jsp">Home</a>
	</nav>

	<c:forEach items="${errors}" var="e">
		<span style="color: red;">${e.message}</span>
	</c:forEach>
	<form action="update" method="post">
		
		
		Id <input class="form-control form-control-lg"  type="number" name="id" value="${dto.id}" />
		
		Name <input class="form-control form-control-lg" type="text" name="name" value="${dto.name}" />
		
		Country <input class="form-control form-control-lg" type="text" name="country" value="${dto.country}" />
		
		Age <input class="form-control form-control-lg" type="number" name="age" value="${dto.age}" />
		
		Punishment <input class="form-control form-control-lg" type="number" name="punishment"
				value="${dto.punishment}" />
		
		<input type="submit" value="update" class="btn btn-success" />


	</form>
</body>
</html>