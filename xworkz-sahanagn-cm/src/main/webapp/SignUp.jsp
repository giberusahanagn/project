<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
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
					<<a href="index.jsp">Home</a> <a href="signIn">Login</a>
				</div>
		</div>
	</nav>

	<div align="center">

		<form action="sign" method="post">

			<div
				class="container px-8 py-10 px-md-12 text-center text-lg-start my-5">
				<div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 20">
					<h1 class="my-5 display-5 fw-bold ls-tight" style="color: green">
						Sign Up Page <br />
					</h1>
				</div>

				<div class="col-lg-6 mb-5 mb-lg-0 position-relative">
					<!-- box size -->

					<div class="card bg-glass">
						<!-- outer box -->
						<div class="card-body px-4 py-5 px-md-5">
							<!-- inner box sizes -->
							<h5 style="color: green;">${message}</h5>
							<c:forEach items="${errors}" var="e">
								<span style="color: red"> ${e.message}</span>
							</c:forEach>
							<h5 style="color: red;">${nonUniqueMessage}</h5>

							<!-- user id -->
							<div class="form-outline mb-4">
								<input type="text" id="Id" name="userId" class="form-control"
									onchange="onUser()" placeholder="User Name" /> <label for="Id">User
									Id</label> <span id="UserIdError" style="color: red"></span> <span
									style="color: red">${userIdExesist}</span> <span
									id="displayUserName" style="color: red"></span>
							</div>

							<!-- Email input -->
							<div class="form-outline mb-4">
								<input type="email" id="EmailId" name="email"
									class="form-control" onchange="onEmail()" placeholder="Email" />
								<label class="form-label" for="EmailId">Email address</label> <span
									id="EmailError" style="color: red"></span> <span
									style="color: red">${EmailisExesist}</span> <span
									id="displayEmail" style="color: red"></span>
							</div>


							<!-- Password input -->
							<div class="form-outline mb-4">
								<input type="password" id="userPassword" name="password"
									class="form-control" placeholder="Enter Password" /> <label
									class="form-label" for="userPassword">Password</label> <span
									id="passwordError" style="color: red"></span> <input
									type="checkbox" onclick="showPassword()">Show Password

							</div>

							<!-- Confirm Password input -->
							<div class="form-outline mb-4">
								<input type="password" id="userConfirmPassword"
									name="confirmPassword" class="form-control"
									onblur="ValidePassword()" placeholder="Confirm Password" /> <label
									class="form-label" for="userConfirmPassword">Confirm
									Password</label> <span id="passwordCompare" style="color: red"></span>
							</div>
							<br>

							<!-- mobile number input -->
							<div class="form-outline mb-4">
								<input type="number" id="MobileNoId" name="mobile"
									class="form-control" onchange="onMobileNo()"
									placeholder="Phone Number" /> <label class="form-label"
									for="MobileNoId">Mobile number</label> <span id="MobileNoError"
									style="color: red"></span> <span style="color: red">${MobileNoExesist}</span>
								<span id="displayMobileNo" style="color: red"></span>
							</div>


							<!-- Checkbox -->
							<div class="form-check d-flex justify-content-center mb-4">
								<input class="form-check-input me-2" type="checkbox"
									id="agreement" onclick="onAgreement()">Accept Agreement
								<br> <br>
							</div>
							<!-- Submit button -->

							<button type="submit" class="btn btn-primary btn-block mb-4"
								id="submitId" disabled="true" onclick="wrong_pass_alert()">Sign
								Up</button>
		</form>
	</div>
	<script>
		function onUser() {
			console.log("running onUser")
			var userInput = document.getElementById('Id');
			var userValue = userInput.value;
			console.log(userValue);
			if (userValue != null && userValue != "" && userValue.length > 3
					&& userValue.length < 30) {
				console.log('valid userName');
				var agrement = document.getElementById('agreement');
				if (agrement.checked) {
					document.getElementById('submitId').disabled = false;
				}
				document.getElementById('UserIdError').innerHTML = '';
			}

			else {
				console.log('invalid user name');
				document.getElementById('submitId').disabled = 'disabled';
				document.getElementById('UserIdError').innerHTML = 'Invalid userId, please enter min 3 and max 30';
			}
			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(userValue);
			xhttp.open("GET", "http://localhost:8080/xworkz-swati-cm/userId/"
					+ userValue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("displayUserName").innerHTML = this.responseText
			}

		}
		function onEmail() {
			console.log("running onEmail")
			var emailInput = document.getElementById('EmailId');
			var emailValue = emailInput.value;
			console.log(emailValue);
			if (emailValue != null && emailValue != "" && emailValue.length > 3
					&& emailValue.length < 30) {
				console.log('valid email');
				var agrement = document.getElementById('agreement');
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
			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(emailValue);
			xhttp.open("GET", "http://localhost:8080/xworkz-swati-cm/email/"
					+ emailValue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("displayEmail").innerHTML = this.responseText
			}
		}

		function onMobileNo() {
			console.log("running onMobileNo")
			var mobileNoInput = document.getElementById('MobileNoId');
			var mobileNoValue = mobileNoInput.value;
			console.log(mobileNoValue);
			if (mobileNoValue != null && mobileNoValue != ""
					&& mobileNoValue.length > 3 && mobileNoValue.length == 10) {
				console.log('valid Mobile number')
				document.getElementById('MobileNoError').innerHTML = '';
			}

			else {
				console.log('invalid Mobile number');

				document.getElementById('MobileNoError').innerHTML = ' please enter Mobile Number';
			}
			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(mobileNoValue);
			xhttp.open("GET", "http://localhost:8080/xworkz-swati-cm/mobile/"
					+ mobileNoValue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("displayMobileNo").innerHTML = this.responseText
			}

		}
		function onAgreement() {

			var agrement = document.getElementById('agreement');
			console.log(agrement.checked);
			if (agrement.checked) {
				document.getElementById('submitId').disabled = false;
			} else {
				document.getElementById('submitId').disabled = 'disabled';
			}

		}
		function ValidePassword() {
			var userPassword = document.getElementById('userPassword');
			var userConfirmPassword = document
					.getElementById('userConfirmPassword');
			var userPasswordvalue = userPassword.value;
			var userConfirmPasswordvalue = userConfirmPassword.value;
			console.log(userPasswordvalue);
			if (userPasswordvalue != null && userPasswordvalue != ""
					&& userPasswordvalue.length > 4
					&& userPasswordvalue.length < 12) {
				if (userPasswordvalue == userConfirmPasswordvalue) {
					console.log('valide both password are same');
					document.getElementById('passwordCompare').innerHTML = '';
				} else {
					console.log('valide both password are not same');
					document.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword must be same';
				}
				console.log('valide password');
				document.getElementById('passwordError').innerHTML = '';
			} else {
				console.log('invalide password');
				document.getElementById('passwordError').innerHTML = 'Plese enter valide password';
			}
		}
		function showPassword() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>

	</div>
	</div>
	</div>
	</div>

</body>
</html>