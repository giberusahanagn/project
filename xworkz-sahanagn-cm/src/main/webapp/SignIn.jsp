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
				<a href="index.jsp">Home</a>
		</div>
	</nav>
	<form action="signIn" method="post">
		<section class="vh-100">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<h3 class="mb-5">Sign in</h3>
								<p>Please enter your User Id and password!</p>
								<h5 style="color: red">${msgs}</h5>
								<h4 style="color: red">${message}</h4>

								<div class="form-outline mb-4">
									<input type="text" class="form-control" name="userId"
										placeholder="User Id" /> <label class="form-label"></label>
								</div>


								<div class="form-outline mb-4">
									<input type="password" id="typePasswordX-2"
										class="form-control " name="password" placeholder="Password" />
									<label class="form-label" for="typePasswordX-2"></label> <a
										href="Forgotpwd.jsp">Forgot password?</a>
								</div>
								<button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
								<hr>
								<div>
									<p class="mb-0">
										Don't have an account? <a href="SignUp.jsp"
											class="text-Bold-50 fw-bold">Sign Up</a>
									</p>
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