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

<!-- <script src="timer.js"></script> -->
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

	<form action="updateProfile" method="post" enctype="multipart/form-data">
		<section class="vh-100">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<h3 class="mb-5">Update Profile</h3>

								<div class="form-outline mb-4">
									<input type="email" id="EmailId" name="email"
										class="form-control" placeholder="Email" value="${dto.email}"
										readonly /> <label class="form-label" for="EmailId">Email
										address</label>
								</div>

								<div class="form-outline mb-4">
									<input type="text" id="Id" name="userId" class="form-control"
										placeholder="User Name" value="${dto.userId}" /> <label
										for="Id">User Id</label>
								</div>


								<!-- mobile number input -->
								<div class="form-outline mb-4">
									<input type="number" id="MobileNoId" name="mobile"
										class="form-control" placeholder="Phone Number"
										value="${dto.mobile}" /> <label class="form-label"
										for="MobileNoId">Mobile number</label>

								</div>
                                <div>
								Select Profile Pic :<input type="file" name="profilePicture"
								 id="profilePicture"/> 
									<label class="form-label" for="profilePicture"></label>
                               </div>
								<button class="btn btn-primary btn-lg btn-block" type="submit">Update</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
</body>
</html>