<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;900&display=swap"
	rel="stylesheet">
<title>Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<link rel="icon" href="" type="images/x-icon">
<link rel="stylesheet" href="css/Registration.css">
<script type="text/javascript" src="<c:url value='/js/home.js'/>"></script>
</head>


<body>

	<div class="main">

		<div class="container-fluid">

			<div class="row ">

				<div class="col-md-8 m-auto">

					<div id="carouselExampleDark" class="carousel carousel-dark slide"
						data-bs-ride="carousel">
						<div class="carousel-indicators">
							<button type="button" data-bs-target="#carouselExampleDark"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#carouselExampleDark"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#carouselExampleDark"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
							<button type="button" data-bs-target="#carouselExampleDark"
								data-bs-slide-to="3" aria-label="Slide 4"></button>
						</div>
						<div class="carousel-inner">

							<div class="carousel-item active" data-bs-interval="1000">
								<img
									src="images/Grow-Trees-On-the-path-to-environment-sustainability-login.png"
									class="d-block w-100 size-fix" alt="...">
								<div class="carousel-caption d-none d-md-block"
									style="color: white; text-align: left;">
									<h5>Lorem ipsum dolor sit amet consectetur.</h5>
									<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
										Quo sint ad dolorem ullam? Rem modi blanditiis molestias.
										Voluptas magnam minus repellat temporibus voluptatem itaque
										officiis.</p>
								</div>
							</div>
							<div class="carousel-item" data-bs-interval="2000">
								<img
									src="images/Grow-Trees-On-the-path-to-environment-sustainability-login.png"
									class="d-block w-100 size-fix" alt="... ">
								<div class="carousel-caption d-none d-md-block"
									style="color: white; text-align: left;">
									<h5>Lorem ipsum dolor sit amet consectetur.</h5>
									<p>Lorem ipsum dolor, sit amet consectetur adipisicing
										elit. Tenetur molestias maxime iste eum magnam. Obcaecati
										repellat quia iste accusamus corporis eius, ea ullam
										accusantium necessitatibus?</p>
								</div>
							</div>
							<div class="carousel-item" data-bs-interval="2000">
								<img
									src="images/Grow-Trees-On-the-path-to-environment-sustainability-login.png"
									class="d-block w-100 size-fix" alt="...">
								<div class="carousel-caption d-none d-md-block"
									style="color: white; text-align: left;">
									<h5>Lorem ipsum dolor sit amet.</h5>
									<p>Lorem ipsumf dolor sit amet consectetur adipisicing
										elit. Quidem quasi laborum id nam neque pariatur suscipit,
										minus est, repellendus at enim excepturi ipsam facilis
										dignissimos?</p>
								</div>
							</div>
							<div class="carousel-item" data-bs-interval="2000">
								<img
									src="images/Grow-Trees-On-the-path-to-environment-sustainability-login.png"
									class="d-block w-100 size-fix" alt="...">
								<div class="carousel-caption d-none d-md-block"
									style="color: white; text-align: left;">
									<h5>Lorem ipsum dolor sit amet.</h5>
									<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
										Nisi quia tempora quibusdam amet architecto et mollitia
										voluptatem repellat id reprehenderit. Voluptate cupiditate
										explicabo inventore aut.</p>
								</div>
							</div>

						</div>
					</div>

				</div>
					
				<div
					class="col-md-4 col-sm-12 d-flex flex-column justify-content-between">
					<c:if test="${not empty msg }">
						<div class="alert alert-success">
							<b><c:out value="${msg }"></c:out></b>
						</div>
					</c:if>
					<div class="row"></div>
					<div class="row">
						<div class="myform">
							<form action="savedata" method="POST" name="login" onsubmit="return verifyPassword()">
								<div class="form-group">
									<label for="exampleInputEmail1" class="first"
										style="font-size: 0.6rem; color: #8d8a8a; padding-left: 15%; padding-bottom: -1%;">First
										name</label> <input type="Text" name="first_name" class="form-control "
										id="fname" aria-describedby="emailHelp"
										placeholder="Enter first name" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-left: 15%; padding-bottom: -1%;">Last
										name</label> <input type="text" name="last_name" class="form-control"
										id="lname" aria-describedby="emailHelp"
										placeholder="Enter last name" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-left: 15%; padding-bottom: -1%;">Phone
										number</label> <input type="tel" name="phone_number" id="number"
										class="form-control" aria-describedby="emailHelp"
										placeholder="Enter phone number">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-left: 15%; padding-bottom: -1%;">Email
										address</label> <input type="email" name="email" class="form-control"
										id="email" aria-describedby="emailHelp"
										placeholder="Enter email" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-left: 15%; padding-bottom: -1%;">New
										Password</label> <input type="password" name="password" id="password"
										class="form-control" aria-describedby="emailHelp"
										placeholder="**************" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-left: 15%; padding-bottom: -1%;">Confirm
										Password</label> <input type="password" name="confpassword"
										id="confpassword" class="form-control"
										aria-describedby="emailHelp" placeholder="**************"
										required>
								</div>
								<div class="col-md-12 d-grid gap-2 text-center mt-4">
									<button type="submit"
										class=" btn btn-block mybtn btn-outline-warning "
										style="border-radius: 50px;" >Register</button>
								</div>
								<div class="form-group mt-3 link">
									<p class="text-center lostpass"
										style="font-size: 14px; color: #8d8a8a;">
										<a href="ForgotPass" style="color: grey !important;">Lost
											your Password?</a>
									</p>
								</div>
								<div class="form-group">
									<p class="text-center" style="font-size: 14px; color: #8d8a8a;">
										Alredy a member? <a href="login" id="signup">Login now</a>
									</p>
								</div>
							</form>

						</div>

					</div>
					<div class="row privacylogin"
						style="font-size: 14px; color: #8d8a8a;">
						<p>Privacy Policy</p>
					</div>

				</div>

			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>

</body>
</html>