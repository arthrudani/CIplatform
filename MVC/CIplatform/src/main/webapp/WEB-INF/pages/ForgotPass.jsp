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
<title>Forgot password</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
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
<link rel="stylesheet" href="css/ForgotPass.css">
</head>


<body>

	<div class="main">

		<div class="container-fluid">

			<div class="row">

				<div class="col-md-8 m-auto">

					<div id="carouselExampleDark" class="carousel carousel-dark slide"
						data-bs-ride="carousel">
						<div class="carousel-indicators indicators">
							
						</div>
						<div class="carousel-inner carouserImages">

						</div>
					</div>

				</div>
				<div
					class="col-md-4 col-sm-12 d-flex flex-column justify-content-between">
					<div class="row"></div>
					<c:if test="${not empty msg }">
						<div class="alert alert-success">
							<b><c:out value="${msg }"></c:out></b>
						</div>
					</c:if>
					<c:if test="${not empty tokenStatus }">
						<div class="alert alert-success">
							<b><c:out value="${tokenStatus}"></c:out></b>
						</div>
					</c:if>
					<div class="row">
						<div class="myform form">
							<div class="logo mb-3">
								<div class="col-md-12 text-center box1">
									<h4 style="font-size: 22px;">Forget Password</h4>
									<p
										style="font-size: 12px; padding-left: 5%; padding-right: 5%;">Enter
										your email address you've using for your account below and we
										will send you a reset password link</p>
								</div>
							</div>
							<form action="ForgotPassword" method="POST" name="forgotpass">
								<div class="form-group">
									<label for="exampleInputEmail1" class="box">Email
										Address</label> <input type="email" name="email" id="email"
										class="form-control mt-1" aria-describedby="emailHelp"
										placeholder="Enter your email address.." style="height: 40px;" required>
								</div>
								<div class="col-md-12 d-grid gap-2 text-center mt-4">
									<input type="submit"
										class=" btn btn-block mybtn btn-outline-warning"
										style="border-radius: 50px;" value="Reset my Password">
								</div>
								<div class="form-group mt-3 text-center">
									<a href="login"
										style="font-size: 0.8rem; color: #8d8a8a; font-weight: 500;">Login</a>
								</div>
							</form>

						</div>
						<div class="privacylogin"
							style="font-size: 0.8rem; color: #8d8a8a;">
							<p>Privacy Policy</p>
						</div>
					</div>


				</div>

			</div>
		</div>


	</div>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		$.ajax({
			url : "loadAllBanner",
			dataType : 'json',
			success : function(response) {
				console.log(response);
				setbanner(response);
			}
		});
	});
	function setbanner(banner){
		let data1="";
		let data2="";
		for(i in banner){
			if(i==0){
				data2=`<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="`+i+`" class="active" aria-current="true"
						aria-label="Slide 1"></button>`;
						
				data1+=`<div class="carousel-item active" data-bs-interval="2000">
						<img src="images/`+banner[i].image+`" class="d-block w-100 size-fix" alt="...">
							<div class="carousel-caption d-none d-md-block"
								style="color: white; text-align: left;">
								<p>`+banner[i].text+`</p>
							</div>
						</div>`;
			}
			else{
				data2+=`<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="`+i+`" aria-label="Slide 2"></button>`;
						
				data1+=`<div class="carousel-item" data-bs-interval="2000">
						<img src="images/`+banner[i].image+`" class="d-block w-100 size-fix" alt="..." > 
							<div class="carousel-caption d-none d-md-block"
								style="color: white; text-align: left;">
								<p>`+banner[i].text+`</p>
							</div>
						</div>`;
			}
			
		}
		$('.carouserImages').html(data1);
		$('.indicators').html(data2);
	}
</script>
</body>

</html>