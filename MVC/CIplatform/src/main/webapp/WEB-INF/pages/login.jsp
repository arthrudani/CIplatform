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
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<link rel="icon" href="" type="images/x-icon">
<link rel="stylesheet" href="css/Login.css">
<script src="js/login.js"></script>
</head>



<body>

	<div class="main">

		<div class="container-fluid">

			<div class="row ">

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


					<div class="row">
						<c:if test="${not empty msg }">
							<div class="alert alert-warning">
								<b><c:out value="${msg }"></c:out></b>
							</div>
						</c:if>
					</div>
					<div class="row">
						<div class="myform form">
							<div class="myform form">
								<form action="verifyuser" method="post" name="login" id="loginForm">
									<div class="form-group">
										<label for="exampleInputEmail1" class="box">Email
											address</label> <input type="email" name="email" class="form-control"
											id="email" aria-describedby="emailHelp"
											placeholder="Enter email" required>
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1" class="box">Password</label> <input
											type="password" name="password" id="password"
											class="form-control password" aria-describedby="emailHelp"
											placeholder="Enter Password" required>
									</div>
									<div class="col-md-12 d-grid gap-2 text-center mt-4">
										<button type="submit" 
											class="loginButton btn btn-block mybtn btn-outline-warning tx-tfm"
											style="border-radius: 50px;">Login</button>
									</div>
									<div class="form-group mt-3 link">
										<p class="text-center"
											style="font-size: 0.8rem; color: #8d8a8a;">
											<a href="ForgotPass" style="color: grey !important;">Lost
												your Password?</a>
										</p>
									</div>
									<div class="form-group">
										<p class="text-center"
											style="font-size: 0.8rem; color: #8d8a8a;">
											Don't have account? <a
												href="http://localhost:8080/CIplatform/registration"
												id="signup">Create an account</a>
										</p>
									</div>
								</form>

							</div>
						</div>

					</div>
					<div class="row">
						<div class="row privacylogin "
							style="font-size: 0.8rem; color: #8d8a8a;">
							<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
						</div>
					</div>
				</div>

			</div>


		</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
<script>
	let password="";
	$(document).ready(function() {
		$.ajax({
			url : "loadAllBanner",
			dataType : 'json',
			success : function(response) {
				console.log(response);
				setbanner(response);
			}
		});
		$('.password').keyup(function(){
			password=$('.password').val();
        });
	});
	$(".loginButton").click(function(e){
		e.preventDefault();
		if($('.password').val().length>7){
			console.log("submitted");
			$("#loginForm").submit();
		}
		else if($('.warning').val()!=""){
			$('.password').after("<div class='text-danger warning'>Please enter atleast 8 digit</div>");
		}
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