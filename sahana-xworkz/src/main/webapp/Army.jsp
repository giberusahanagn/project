<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
				width="200" height="100" /></a>
        <a class="nav-link" href="index.jsp">Home</a>
           <a class="nav-link" href="ArmySearch.jsp">Search By Id </a>
         <a class="nav-link" href="CountrySearch.jsp">Search By Country </a>
    
     
     
</nav>
	<c:forEach items="${errors}" var="e">
		<span style="color: red;">${e.message}</span>
	</c:forEach>
	<form action="army" method="post">


		<div class="form-group">
			<label for="formGroupExampleInput">Name</label> <input type="text"
				class="form-control" id="formGroupExampleInput" placeholder="name"
				name="name" value="${dto.name}" >
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput"> Country</label> <input
				class="form-control form-control-lg" type="text" name="country"
				value="${dto.country}" />
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput">Age </label><input class="form-control " type="number"
			name="age" value="${dto.age}" /> 
			</div>
		<div class="form-group">
			<label for="formGroupExampleInput">Punishment</label> <input
			class="form-control " type="number" name="punishment"
			value="${dto.punishment}" /> 
			</div>
			
			<div class="form-group">
			<input type="submit" value="Save"
			class="btn btn-success" />
			</div>
	</form> 

</body>
</html>