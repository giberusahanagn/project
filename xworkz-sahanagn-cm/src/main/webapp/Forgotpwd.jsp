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

	<form action="resetPwd" method="post">
		<section class="vh-100">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<h3 class="mb-5">Forgot Password</h3>
								<div class="form-outline mb-4">
									<input type="email" class="form-control " placeholder="Email"
										id="EmailId" name="email" onchange="onEmail()" /> <label
										class="form-label" for="EmailId"> </label> <span
										id="EmailError" style="color: red"></span>
								</div>
								<button class="btn btn-primary btn-lg btn-block" type="submit">Reset</button>
							</div>

							<div>
								<p class="mb-0 text-center">${message}
									<a href="SignIn.jsp" class="text-Bold-50 fw-bold ">login</a>
								</p>
							</div>
							<br>
							<script>
								function onEmail() {
									console.log("running onEmail")
									var emailInput = document
											.getElementById('EmailId');
									var emailValue = emailInput.value;
									console.log(emailValue);
									if (emailValue != null && emailValue != ""
											&& emailValue.length > 3
											&& emailValue.length < 30) {
										console.log('valid email');
										var agrement = document
												.getElementById('agreement');
										if (agrement.checked) {
											document.getElementById('submitId').disabled = false;
										}
										document.getElementById('EmailError').innerHTML = '';
									}

									else {
										console.log('invalid email');
										document.getElementById('submitId').disabled = 'disabled';

										document.getElementById('EmailError').innerHTML = 'Invalid Email, please enter min 3 and max 30';
									}

								}
							</script>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
</body>
</html>