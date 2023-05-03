<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<link href='https://fonts.googleapis.com/css?family=Noto Sans'
	rel='stylesheet'>
<title>Privacy policy</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="icon" href="" type="images/x-icon">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/PrivacyPolicy.css">

</head>

<body>

	<!-- upper nav side open bar -->
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
		style="display: none;" id="rightMenu">
		<button onclick="closeRightMenu()"
			class="w3-bar-item w3-button w3-large ">
			<img src="images/left.png">
		</button>

		<div class="dropdown button1">
			<ul class="navbar-nav">
				<li class="nav-item dropdown upperButtons"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
					aria-expanded="false">&nbsp;Stories&nbsp; <img
						src="images/drop-down.png"></a>
					<ul class="dropdown-menu  posAbsolute"
						aria-labelledby="navbarDropdownMenuLink">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>

				<li class="nav-item dropdown upperButtons"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> &nbsp;Policy &nbsp; <img
						src="images/drop-down.png">
				</a>
					<ul class="dropdown-menu  posAbsolute"
						aria-labelledby="navbarDropdownMenuLink">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
			</ul>
		</div>


	</div>

	<!-- upper nav bar -->
	<div class="container-fluid borderH2 d-flex ">
		<div
			class="container d-flex justify-content-around align-items-center">

			<div class="d-flex ">

				<button class="w3-button " onclick="openRightMenu()">
					<img class="rightbutton" src="images/filter.png">
				</button>
			</div>
			<div class="col d-flex justify-content-around align-items-center">
				<div>
					<form action="storiesLoader" method="POST" name="storiesLoader">
						<button type="submit" style="background: none; border: none; min-width: 120px;">
							<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
							<li class="nav-item upperButtons blocking ">Stories</li>
						</button>
					</form>
				</div>
				<div class="d-flex ">
					<ul class="d-flex navbar-nav rightHeader align-items-center">
						<img class="rightbutton " src="images/search.png">

						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle d-flex align-items-center gap-2"
								href="#" id="navbarDropdownMenuLink" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"
								style="display: flex !important">
								<div> <img src="images/<c:out value="${user.avatar}"></c:out>" class="userimage "> </div>
								<div>
									<span class="blocking uNameuImage" class="uNameuImage"><c:out
										value="${user.first_name} ${user.last_name}"></c:out></span>
								</div> 
								<input type="text" class="usernameforlike" id="fname" name="fname" value="${user.user_id}" hidden>
								<div>
									<img src="images/drop-down.png" class="uNameuImage">
								</div>
							</a>

							<ul class="dropdown-menu posAbsolute dropdown-menu-end"
								aria-labelledby="navbarDropdownMenuLink">
								<form action="editProfile" method="POST" name="storiesLoader">
									<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
									<li><button type="submit" class="dropdown-item">Edit Profile</button></li>
								</form>
								<form action="volunteeringTimesheet" method="POST" name="storiesLoader">
									<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
									<li><button type="submit" class="dropdown-item">Volunteering timesheet</button></li>
								</form>
								<li><a class="dropdown-item" href="login">Logout</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>


		</div>
	</div>


	<div class=" container maincontainer ">

		<div class="pacp col sticky1" style="z-index: -1;">Privacy and
			Coockie Policy</div>
		<div class="d-flex row mt-4">
			<div id="list-example" class="list-group col-md-3 col-12 ">
				<div class="sticky slugsTitle" style="z-index: -1;"></div>
			</div>
			<div data-bs-spy="scroll" data-bs-target="#list-example"
				data-bs-offset="0" class="slugDescription scrollspy-example col-9"
				tabindex="0" style="z-index: -2;"></div>

		</div>
	</div>
	<!-- footer -->
	<div class="EPfooterline "></div>
	<div
		class="container EPprivacypolicy d-flex justify-content-start mt-3 gap-3">
		<div class="privacypolicy">
			<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
		</div>
		<div class="contactus">
			<a href="#"> Contact us</a>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>
	<script>
	$(document).ready(function() {
		$.ajax({
            url: "loadAllSlugs",
            dataType: 'json',
            success: function(response){
           		setSlugs(response);
            }
        });
	});
	function setSlugs(slugs){
		var data1="";
		var data2="";
     	for(var i in slugs){
     		data1+=`<a class="list-group-item list-group-item-action d-flex justify-content-between"
		                href=`+slugs[i].cmsPageId+`>
		                <div>`+slugs[i].title+`</div>
		                <div><img src="images/right-arrow1.png" alt=""></div>
		            </a>`;
     		data2+=`<h3 id=`+slugs[i].cmsPageId+`>`+slugs[i].title+`</h3>
	                <p>`+slugs[i].description+`</p>
	                <div class="bbottom"></div>`;
		            
     	}
     	$(".slugsTitle").html(data1);
     	$(".slugDescription").html(data2);
	}
	</script>
	<script src="js/EditProfile.js"></script>
</body>

</html>