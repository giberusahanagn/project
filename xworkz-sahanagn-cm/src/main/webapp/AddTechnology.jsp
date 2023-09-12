<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		</div>
	</nav>
	<form action="addTechnology" method="post">
		<input type="hidden" value="${userID}" name="userId"
			readonly="readonly">
		<section class="vh-100">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<h3>Add Technology Form</h3>
<br>
								<span style="color: red">${errors}</span> <span
									style="color: green;">${addTechSuccess}</span>

								<div class="form-outline mb-4">
									<input type="text" id="name" class="form-control" name="name"
										placeholder="Name" /> <label class="form-label" for="name"></label>
								</div>


								<div class="form-outline mb-4">
									<input type="text" id="language" class="form-control"
										name="language" placeholder="Language" /> <label
										class="form-label" for="language"></label>
								</div>
								<div class="form-outline mb-4">
									<input type="text" id="version" class="form-control"
										name="version" placeholder="Version" /> <label
										class="form-label" for="version"></label>
								</div>


								<div class="form-outline mb-4">
									<input type="text" id="owner" class="form-control" name="owner"
										placeholder="Owner" /> <label class="form-label" for="owner"></label>
								</div>
								<div class="form-outline mb-4">
									<input type="text" id="supportFrom" class="form-control"
										name="supportFrom" placeholder="Support From" /> <label
										class="form-label" for="supportFrom"></label>
								</div>
								<div class="form-outline mb-4">
									<input type="text" id="supportTo" class="form-control"
										name="supportTo" placeholder="Support To" /> <label
										class="form-label" for="supportTo"></label>
								</div>

								<div class="form-outline mb-4">
									<input type="text" id="license" class="form-control"
										name="license" placeholder="License" /> <label
										class="form-label" for="license"></label>
								</div>
								<div class="form-outline mb-4">
									OsType :<select class="custom-select" id="osType" name="osType">
										<option>SELECT</option>
										<c:forEach items="${OStype}" var="p">
											<option value="${p}">${p}</option>
										</c:forEach>
									</select>
									 <label
										class="form-label" for="osType"></label>

								</div>

								<div class="form-group">
									<label for="openSource">Open Source: (if yes, click on
										check box)</label> <input type="checkbox" id="openSource"
										name="openSource" />
								</div>
								<div>
									<button class="btn btn-primary btn-lg btn-block" type="submit">Add</button>
							<!-- 		<button class="btn btn-primary btn-lg btn-block" type="submit">update</button> -->

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>

</body>
</html>