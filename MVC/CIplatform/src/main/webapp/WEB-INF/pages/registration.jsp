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
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<link rel="icon" href="" type="images/x-icon">
<link rel="stylesheet" href="css/Registration.css">
<%-- <script type="text/javascript" src="<c:url value='/js/registration.js'/>"></script> --%>
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
					<c:if test="${not empty msg }">
						<div class="alert alert-success">
							<b><c:out value="${msg}"></c:out></b>
						</div>
					</c:if>
					<div class="row"></div>
					<div class="row">
						<div class="myform">
							<form action="savedata" method="POST" name="login" class="registerForm" onsubmit="return verifyPassword()">
								<div class="form-group">
									<label for="exampleInputEmail1" class="first"
										style="font-size: 0.6rem; color: #8d8a8a; padding-bottom: -1%;">First
										name</label> <input type="Text" name="first_name" class="form-control firstName"
										id="fname" aria-describedby="emailHelp"
										placeholder="Enter first name" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-bottom: -1%;">Last
										name</label> <input type="text" name="last_name" class="form-control lastName"
										id="lname" aria-describedby="emailHelp"
										placeholder="Enter last name" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-bottom: -1%;">Phone
										number</label> <input type="tel" name="phone_number" id="number"
										class="form-control phoneNumber" aria-describedby="emailHelp"
										placeholder="Enter phone number">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-bottom: -1%;">Email
										address</label> <input type="email" name="email" class="form-control email"
										id="email" aria-describedby="emailHelp"
										placeholder="Enter email" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-bottom: -1%;">New
										Password</label> <input type="password" name="password" id="password"
										class="form-control password" aria-describedby="emailHelp"
										placeholder="**************" required>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1"
										style="font-size: 0.6rem; color: #8d8a8a; padding-bottom: -1%;">Confirm
										Password</label> <input type="password" name="confirmPassword"
										id="confpassword" class="form-control"
										aria-describedby="emailHelp" placeholder="**************"
										required>
								</div>
								<div class="col-md-12 d-grid gap-2 text-center mt-4">
									<button type="submit"
										class=" btn btn-block registerButton mybtn btn-outline-warning "
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
						<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
					</div>

				</div>

			</div>
		</div>
	</div>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
	<script>
	let firstName=""
	let lastName="";
	let email="";
	let password="";
	let consfirmPassword="";
	let phoneNumber="";
	$(document).ready(function() {
		$.ajax({
			url : "loadAllBanner",
			dataType : 'json',
			success : function(response) {
				setbanner(response);
			}
		});
		$('.email').val('');
		$('.password').val('');
		$('.firstName').keyup(function(){
           	firstName=$('.firstName').val();
        });
		$('.lastName').keyup(function(){
			lastName=$('.lastName').val();
        });
		$('.email').keyup(function(){
			email=$('.email').val();
        });
		$('.password').keyup(function(){
			password=$('.password').val();
        });
		$('.consfirmPassword').keyup(function(){
			consfirmPassword=$('.consfirmPassword').val();
        });
		$('.phoneNumber').keyup(function(){
			phoneNumber=$('.phoneNumber').val();
        });
	});
	$(".registerButton").click(function(e){
		e.preventDefault();
		if($('.password').val().length<8 && $('.warning').html()!=""){
			$('.warning').html("");
			$('.password').after("<div class='text-danger warning'><small>Please enter valid password</small></div>");
		}
		else{
			$('.warning').html("");
		}
		if($('.email').val().length<1 && $('.warning1').html()!=""){
			$('.warning1').html("");
			$('.email').after("<div class='text-danger warning1'><small>Please enter valid email</small></div>");
		}
		else{
			$('.warning1').html("");
		}
		if($('.firstName').val().length<1 && $('.warning2').html()!=""){
			$('.warning2').html("");
			$('.firstName').after("<div class='text-danger warning2'><small>This field is required</small></div>");
		}
		else{
			$('.warning2').html("");
		}
		if($('.lastName').val().length<1 && $('.warning3').html()!=""){
			$('.warning3').html("");
			$('.lastName').after("<div class='text-danger warning3'><small>This field is required</small></div>");
		}
		else{
			$('.warning3').html("");
		}
		if($('.phoneNumber').val().length<10 && $('.warning4').html()!=""){
			$('.warning4').html("");
			$('.phoneNumber').after("<div class='text-danger warning3'><small>Please enter 10 digit number</small></div>");
		}
		else if(phoneNumber.indexOf('0')==0){
			console.log("hii");
			$('.warning4').html("");
			$('.phoneNumber').after("<div class='text-danger warning3'><small>Invalid number</small></div>");
		}
		else{
			$('.warning4').html("");
		}
		if($('.password').val().length>7 && $('.email').val()!="" && $('.firstName').val()!="" && $('.lastName').val()!=""){
			$(".registerForm").submit();
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
	function verifyPassword() {  
		var pw = document.getElementById("password").value;
	  	var cpw = document.getElementById("confpassword").value;
	  	if(pw.length<8){
		  	swal("Error!", "Minimum length is 8 character!", "error");
		  	return false;
	  	}
	  
	  	if(pw != cpw) {  
		  	swal("Error!", "Password and confirm password are not same!", "error");
	     	return false;
	  	}
	  	return true;
	}   
	</script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script> 
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