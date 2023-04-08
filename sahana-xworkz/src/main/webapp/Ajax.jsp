<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<input type="text" id="id" />
	<button onclick="loadDto()">Click</button>
	<span id="id2"></span>
	<span id="name2"></span>
	
	<script>
	
	function loadDto(){
		console.log('running loadDto');
		var xhttp=new XMLHttpRequest();
		
		
		var id=document.getElementById("id").value;
		xhttp.open("GET", "http://localhost:8082/sahana-demo/dto/"+id,true);
		xhttp.send();
		
		xhttp.onload=function(){
			console.log(this);
			document.getElementById("displayDto2").innerHTML='test';
			var json=JSON.parse(this.responseText);
			console.log(json);
			document.getElementById("id2").innerHTML=json.id;
			document.getElementById("name2").innerHTML=json.name;
		}
	}
	</script>

</body>
</html>