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
		<div align="center">User Name:${message}</div>
	<form action="updatePwd" method="post">
		<input type="hidden" name="userId" value=${message } />
		<section class="vh-100">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<h3 class="mb-5">Update New Password</h3>

								<div class="form-outline mb-4">
									<input type="password" id="userPassword" class="form-control"
										name="password" placeholder="Password" /> <label
										class="form-label" for="userPassword"></label>
								</div>

								<div class="form-outline mb-4">
									<input type="password" id="userConfirmPassword"
										class="form-control" name="confirmPassword"
										onblur="ValidePassword()" placeholder="Confirm New Password" />
									<label class="form-label" for="userConfirmPassword"></label> <span
										id="passwordCompare" style="color: red"></span>
								</div>

								<div>
									<button class="btn btn-primary btn-lg btn-block" type="submit">Update</button>
								</div>
								<script>
									function ValidePassword() {
										var userPassword = document
												.getElementById('userPassword');
										var userConfirmPassword = document
												.getElementById('userConfirmPassword');
										var userPasswordvalue = userPassword.value;
										var userConfirmPasswordvalue = userConfirmPassword.value;
										console.log(userPasswordvalue);
										if (userPasswordvalue != null
												&& userPasswordvalue != ""
												&& userPasswordvalue.length > 4
												&& userPasswordvalue.length < 12) {
											if (userPasswordvalue == userConfirmPasswordvalue) {
												console
														.log('valide both password are same');
												document
														.getElementById('passwordCompare').innerHTML = '';
											} else {
												console
														.log('valide both password are not same');
												document
														.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword must be same';
											}
											console.log('valide password');
											document
													.getElementById('passwordError').innerHTML = '';
										} else {
											console.log('invalide password');
											document
													.getElementById('passwordError').innerHTML = 'Plese enter valide password';
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