<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>  
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;900&display=swap"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Noto Sans'
	rel='stylesheet'>
<title>Edit profile</title>
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
<link rel="stylesheet" href="css/EditProfile.css">

</head>

<body>


	<!-- modal for change password -->
	<div class="modal " id="exampleModal1" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Change password</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body ">
					<input type="password" name="oldpass" class="form-control my-3"
						id="oldpass" aria-describedby="emailHelp"
						placeholder="Enter old password"> 
					<input type="password" name="newpass" class="form-control my-3" 
						id="newpass" aria-describedby="emailHelp" 
						placeholder="Enter new password">
					<input type="password" name="confpass" class="form-control my-3"
						id="confpass" aria-describedby="emailHelp"
						placeholder="Confirm new password">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
					<button type="button" class="btn changepass"
						data-bs-dismiss="modal" aria-label="Close" onclick="changePass()">Change
						password</button>
				</div>
			</div>
		</div>
	</div>

	<!-- modal for add skills -->
	<div class="modal " id="exampleModal2" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add your skills</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body ">
					<div class="approveTermsContainer">
						<div class="newItems">
						</br>
							<select multiple="multiple" id='lstBox1' name="skills" class="countrySelector">
								<option value="country" hidden>Country</option>
							</select>
						</div>
						<div class="transferBtns">
							<input type='button' id='btnRight' value='  >  ' /> <br />
							<input type='button' id='btnLeft' value='  <  ' />
						</div>
						<div class="approvedItems">
							<br /> 
							<select multiple="multiple" id='lstBox2' >
							</select>
						</div>
					</div>

				</div>
				<div class="modal-footer justify-content-start">
					<button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
					<button type="button" id="saveSkills" class="btn changepass"
						data-bs-dismiss="modal" aria-label="Close" >Save</button>
				</div>
			</div>
		</div>
	</div>

	<!-- modal for contact us -->
	<div class="modal " id="exampleModal3" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Contact us</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Name*</p>
					<input type="text" name="cname" class="form-control " id="cname"
						aria-describedby="emailHelp" placeholder="Enter username">
					<p>Email address*</p>
					<input type="email" name="email" class="form-control " id="email"
						aria-describedby="emailHelp" placeholder="Enter email address">
					<p>Subject*</p>
					<input type="text" name="subject" class="form-control "
						id="subject" aria-describedby="emailHelp"
						placeholder="Enter your subject">
					<p>Message*</p>
					<textarea name="subject" id="message" class="form-control  "
						aria-describedby="emailHelp" placeholder="Enter your message"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
					<button type="button" class="btn changepass"
						data-bs-dismiss="modal" aria-label="Close">Save</button>
				</div>
			</div>
		</div>
	</div>

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
		<div class="container d-flex justify-content-around  ">

			<div class="d-flex ">

				<button class="w3-button " onclick="openRightMenu()">
					<img class="rightbutton" src="images/filter.png">
				</button>
			</div>




			<div class="col d-flex justify-content-around">

				<div class="leftHeader d-flex align-items-center">
					<ul class="navbar-nav d-flex flex-row justify-content-between">
						<div class="d-felx align-items-center" 	>
						<form action="storiesLoader" method="POST" name="storiesLoader">
							<button type="submit" style="background: none; border: none; min-width: 120px;">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
								<li class="nav-item upperButtons blocking" style="margin-top: 15px;">Stories</li>
							</button>
						</form>
					</div>
						<li class="nav-item dropdown upperButtons blocking">
								<a
								class="nav-link dropdown-toggle" href="#"
								id="navbarDropdownMenuLink" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> &nbsp;Policy
									&nbsp;<img src="images/drop-down.png">
								</a>
								<ul class="dropdown-menu slugs posAbsolute"
									aria-labelledby="navbarDropdownMenuLink">
									
								</ul>
							</li>
					</ul>
				</div>

				<div class="d-flex ">
					<ul class="navbar-nav rightHeader align-items-between">
						<img class="rightbutton "
							style="padding-top: 22% !important; padding-right: 10%;"
							src="images/search.png">

						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle d-flex align-items-center gap-3"
								href="#" id="navbarDropdownMenuLink" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"
								style="display: flex !important">
								<div> <img src="images/<c:out value="${user.avatar}"></c:out>" class="userimage "> </div>
								<div>
									<span class="blocking uNameuImage" class="uNameuImage"><c:out
										value="${user.first_name} ${user.last_name}"></c:out></span>
								</div> 
								<img src="images/drop-down.png">
								<input type="text" class="usernameforlike" id="fname" name="fname" value="${user.user_id}" hidden>
								
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

	<!-- edit profile -->
	<input type="text" class="userId" name="uid" value="${user.user_id}"
		hidden>
	<div class="container mt-5 ">

		<div class=" d-flex row ">

			<!-- sideimage -->
			<div class=" EPuserimg col-md-3 ">
			
				<div class="container">
				    <div class="picture-container">
				        <div class="picture d-flex userprofilepic">
				            <img src="images/<c:out value="${user.avatar}"></c:out>" class="userimage profilePic">
				            <input type="file" id="wizard-picture" class="d-none">
				        </div>
				    </div>
				</div>

				
				<div class="EDchangepass d-flex justify-content-center mt-3">${user.first_name}
					${user.last_name}</div>
				<div class="EDchangepass d-flex justify-content-center mt-2">
					<a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal1">Change
						password</a>
				</div>
			</div>


			<!-- rightcontent -->
			<div class="EPbasicInformation col-md-9 ">

				<!-- basic Information -->
				<div class="EPbasicInfo">
					<p>Basic Information</p>
				</div>
				<div class="form-group ">
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<span>Name*</span> <input type="text" name="name"
								class="form-control" id="name" aria-describedby="emailHelp"
								placeholder="Enter name">
						</div>
						<div class="col">
							<span>Surname*</span> <input type="text" name="surname"
								class="form-control" id="surname" aria-describedby="emailHelp"
								placeholder="Enter surname">
						</div>
					</div>
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<span>Employee Id</span> <input type="text" name="employeeId"
								class="form-control" id="employeeID"
								aria-describedby="emailHelp" placeholder="Enter employee Id">
						</div>
						<div class="col">
							<span>Manager</span> <input type="text" name="manager"
								class="form-control" id="manager" aria-describedby="emailHelp"
								placeholder="Enter manager">
						</div>
					</div>
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<span>Title</span> <input type="text" name="title"
								class="form-control" id="title" aria-describedby="emailHelp"
								placeholder="Enter title">
						</div>
						<div class="col">
							<span>Department</span> <input type="text" name="department"
								class="form-control" id="department"
								aria-describedby="emailHelp" placeholder="Enter department">
						</div>
					</div>
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<span>Why I volunteer*</span>
							<div class="EPnameSurname mt-1">
								<textarea name="skills" id="WhyIvolunteer" class="w-100 "
									placeholder=" Enter your comments"></textarea>
							</div>
						</div>
					</div>
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<span>My profile*</span>
							<div class="EPnameSurname mt-1">
								<textarea name="skills" id="comments" class="w-100 "
									placeholder=" Enter your comments"></textarea>
							</div>
						</div>
					</div>
				</div>

				<!-- Address Information -->
				<div class="EPbasicInfo">
					<p>Address Information</p>
				</div>
				<div class="form-group ">
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
						<input type="text" class="defaultCity" value="${user.city.name}" hidden>
						<input type="text" class="defaultCityid" value="${user.city.city_id}" hidden>
							<span>City*</span> 
								<select name="country" id="city" class="countrySelector">
									<option value="city" hidden>city</option>
								</select> 
						</div>
						<div class="col">
						<input type="text" class="defaultCountry" value="${user.country.name}" hidden>
						<input type="text" class="defaultCountryid" value="${user.country.country_id}" hidden>
							<span>Country*</span>
								<select name="country" id="country" class="countrySelector">
										<option value="country" hidden>Country</option>
								</select>
						</div>

					</div>
				</div>

				<!-- personal Information -->
				<div class="EPbasicInfo">
					<p>Professional Information</p>
				</div>
				<div class="form-group ">
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<span>Availability</span>
								<select name="availability" id="availability" class="countrySelector">
									<option value="starter" selected>Select availability</option>
										<option value="DAILY">DAILY</option>
										<option value="WEEKLY">WEEKLY</option>
										<option value="MONTHLY">MONTHLY</option>
										<option value="YEARLY">YEARLY</option>
								</select>
						</div>
						<div class="col">
							<span>LinkedIn</span> <input type="email" name="linkedINUrl"
								class="form-control LinkedIn" id="linkedINUrl"
								aria-describedby="emailHelp" placeholder="Enter LinkedIn url">
						</div>

					</div>
				</div>

				<!-- my skill -->
				<div class="EPbasicInfo">
					<p>My skills</p>
				</div>
				<div class="EPmyskill mt-4">
					<div class="EPmyskilltextarea">
						<select multiple="multiple" id="selectedSkills" >
						</select>
					</div>
				</div>

				<!-- footer button -->
				<div class="EPaddskill mt-3">
					<button data-bs-toggle="modal" data-bs-target="#exampleModal2"
						id="addSkillButton">Add skill</button>
				</div>
				<div class="d-flex justify-content-end EPsave mt-3">
					<button class="save">Save</button>
				</div>

			</div>

		</div>

		<!-- footer -->
		<div class="EPfooterline "></div>
		<div class="EPprivacypolicy d-flex justify-content-start mt-3 gap-3">
			<div class="privacypolicy">
				<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
			</div>
			<div class="contactus">
				<a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal3"
					id="contactus"> Contact us</a>
			</div>
		</div>


	</div>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script> 
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

	<script src="js/EditProfile.js"></script>
	<script>
		let CountryOfUser=$(".defaultCountry").val();
		let CityOfUser=$(".defaultCity").val();
		let CityIdOfUser=$(".defaultCityid").val();
		let CountryIdOfUser=$(".defaultCountryid").val();
		let userSkills = "";
		let allSkills = "";
		let user_id = $('.userId').val();
		let name = "";
		let surname = "";
		let employeeID = "";
		let title = "";
		let department = "";
		let WhyIvolunteer = "";
		let city = CityIdOfUser;
		let cityList = "";
		let country = CountryIdOfUser;
		let countries = "";
		let LinkedIn = "";
		let selectedSkills=[];
		let oldPass="";
		let newPass="";
		let confPass="";
		let profilePic="";

		$(document).ready(function() {
			getCityList(CountryIdOfUser);
			$.ajax({
				url : "loadListOfCountry",
				dataType : 'json',
				success : function(response) {
					countries = response;
					addCountryList(countries);
				}
			});
			$("#wizard-picture").change(function(){
			    readURL(this);
			});
			$(".profilePic").click(function(){		
				$("#wizard-picture").click();
			});
			$('#name').keyup(function(){
				name = $('#name').val();
			});
			$('#surname').keyup(function(){
				surname = $('#surname').val();
			});
			$('#employeeID').on('change', function() {
				employeeID = $('#employeeID').val();
			});
			$('#title').on('change', function() {
				title = $('#title').val();
			});
			$('#department').on('change', function() {
				department = $('#department').val();
			});
			$('#WhyIvolunteer').on('change', function() {
				WhyIvolunteer = $('#WhyIvolunteer').val();
			});
			$('#city').on('change', function() {
				city = $(this).find("option:selected").val();
			});
			$('#country').on('change', function() {
				country = $(this).find("option:selected").val();
				getCityList(country);
			});
			$('#linkedINUrl').on('change', function() {
				LinkedIn = $('#linkedINUrl').val();
			});
			$('#lstBox1').on('change', function() {
				selectedSkills.push($(this).val());
			});
			loadAllSkill();
			loadUserSkill();
			loadAllDetails();
			$.ajax({
	            url: "loadAllSlugs",
	            dataType: 'json',
	            success: function(response){
	           		addSlugs(response);
	            }
	        });
		});
		function addSlugs(slugs){
	     	var data="";
	     	console.log(slugs);
	     	for(var i in slugs){
	     		data+=`<li><a class="dropdown-item" href="PrivacyPolicy?uid=${user.user_id}">`+slugs[i].title+`</a></li>`;
	     	}
	     	$(".slugs").html(data);
	     }
		$(".save").click(function(e){
			e.preventDefault();
			if(name.length==0 && $('.warning').html()!=""){
				$('.warning').html("");
				$('#name').after("<div class='text-danger warning'><small>This field is compalsory</small></div>");
			}
			else{
				$('.warning').html("");
			}
			if(surname.length==0 && $('.warning1').html()!=""){
				$('.warning1').html("");
				$('#surname').after("<div class='text-danger warning1'><small>This field is compalsory</small></div>");
			}
			else{
				$('.warning1').html("");
			}
// 			if(city==0 && $('.warning1').html()!=""){
// 				$('.warning1').html("");
// 				$('#surname').after("<div class='text-danger warning1'><small>This field is compalsory</small></div>");
// 			}
// 			else{
// 				$('.warning1').html("");
// 			}
			if(surname.length>0 && name.length>0){
				updateProfile();
			}
		});	
		function readURL(input) {
		    if (input.files && input.files[0]) {
		        var reader = new FileReader();

		        reader.onload = function (e) {
		            $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
		        }
		        reader.readAsDataURL(input.files[0]);
		    }
		    profilePic=input.files[0].name;
		    swal("Please click on save button to update profile pic!", "info");
		}
		function changePass(){
			oldPass=$('#oldpass').val();
			newPass=$('#newpass').val();
			confPass=$('#confpass').val();
			if(oldPass==''){
				swal("Error!", "Please enter old password!", "error");
				clearPasswordFields();
			}
			if(newPass!=confPass){
				swal("Error!", "New password and confirm password are not same!", "error"); 
				clearPasswordFields();
			}	
			if(oldPass!='' && newPass==confPass){
				changePassword();
			}
		}
		function changePassword(){
			$.ajax({
				url : "changePassword",
				dataType : 'json',
				data : {'uid' : user_id,
						'oldPass' : oldPass,
						'newPass' : newPass,
						},
				type : "POST",
				success : function(response) {
					if(response==0){
						swal("Error!", "Old pass did not matched!", "error"); 
					}
					else if(response==1){
						swal("Success!", "Password changed successfully!", "success"); 
					}
					clearPasswordFields();
				}
			});
		}
		function getCityList(CheckedCountry) {
			cityList="";
			//get City List
			$.ajax({
				url : "loadListOfCity",
				dataType : 'json',
				data : {
					countryId : CheckedCountry
				},
				type : "POST",
				success : function(response) {
					cityList = response;
					addCityList(cityList);
				}
			});
		}
		function addCityList(cityList) {
			$("#city").empty();
			var data = "";
			if(country==CountryIdOfUser){
				data +='<option value="' + CityIdOfUser + '" selected> ' + CityOfUser + '</option>';
			}
			
			for ( var i in cityList) {
				if(cityList[i].city_id!=CityIdOfUser){
					data +='<option value="' + cityList[i].city_id + '"> ' + cityList[i].name + '</option>';
				}	
			}
			$("#city").append(data);
		}
		function addCountryList(country) {
			var data = "";
			data += '<option value="'+CountryIdOfUser+'" selected> ' + CountryOfUser + '</option>';
			for ( var i in country) {
				if(country[i].country_id!=CountryIdOfUser){
					data += '<option value="'+country[i].country_id+'"> ' + country[i].name + '</option>';
				}
			}
			$("#country").append(data);
		}
		function loadAllSkill() {
			$.ajax({
				url : "loadAllSkill",
				dataType : 'json',
				type : "GET",
				success : function(response) {
					allSkills = response;
				}
			});
		}
		function loadUserSkill() {
			$.ajax({
				url : "loadUserSkill",
				dataType : 'json',
				data : {'uid' : user_id},
				type : "GET",
				success : function(response) {
					userSkills = response;
					addSkills();
				}
			});
		}
		function addSkills() {
			$("#lstBox1").empty();
			var data1 = "";
			var data2 = "";
			let userskill=[];
			for (var i in userSkills) {
				userskill[i]=userSkills[i].skill;
			}
			for (var i in allSkills) {
				data1 +='<option value="' + allSkills[i].skill_id + '"> ' + allSkills[i].skill_name + '</option>';
			}
			for (var i in userSkills) {
				data2 +='<option value="' + userSkills[i].skill.skill_id + '"> ' + userSkills[i].skill.skill_name + '</option>';
			}
			$("#lstBox1").append(data1);
			$("#selectedSkills").append(data2);
		}
		function loadAllDetails() {
			$.ajax({
				url : "loadAllDetails",
				dataType : 'json',
				data : {'uid' : user_id},
				type : "GET",
				success : function(response) {
					user = response;
					setUserData(response);
				}
			});
		}
		function setUserData() {
			clearPasswordFields();
			$('#name').val(user.first_name);
			name=$('#name').val();
			$('#surname').val(user.last_name);
			surname=$('#surname').val();
			$('#employeeID').val(user.employee_id);
			$('#title').val(user.title);
			$('#department').val(user.department);
			$('#WhyIvolunteer').val(user.why_i_volunteer);
			$('#city').val(user.city.name);
			$('#country').val(user.country.name);
			$('#linkedINUrl').val(user.linked_in_url);
		}
		function clearPasswordFields(){
			$('#oldpass').val('');
			$('#newpass').val('');
			$('#confpass').val('');
		}
		function updateProfilePic(){
			$.ajax({
				url : "updateProfilePic",
				dataType : 'json',
				data : {'uid' : user_id,
						'profilePic':profilePic},
				type : "POST",
				success : function(response) {
					location.reload(true);
				}
			});
		}
		function updateSkills(skills){
			for(var i in skills){
				skills[i]=parseInt(skills[i]);
			}
			$.ajax({
				url : "updateUserSkills",
				data : {'uid' : user_id,
						'skills':skills},
				type : "POST",
				success : function(response) { 
// 					location.reload(true);
				}
			});
		}
		function updateProfile(){
			if(profilePic!=""){
				updateProfilePic();
			}
			let length=selectedSkills.length;
			if(length>0){
				updateSkills(selectedSkills[length-1]);
			}
			EditProfileObject={
					name :name ,
					surname:surname,
					employeeId:employeeID,
					manager:"Dummy",
					title:title,
					whyIVolunteer:WhyIvolunteer,
					department:department,
					myComments:"Demo",
					city:city,
					country:country,
					availability:"MONTHLY",
					linkedInUrl:LinkedIn
	   		}
			
			$.ajax({
				url : "updateProfile",
				dataType : 'json',
				data : {'uid' : user_id,
						'EditProfile': JSON.stringify(EditProfileObject)},
				type : "GET",
				success : function(response) {
					swal("Good job!", "Profile edited successfully!", "success");  
				}
			});
		}
		
	</script>
</body>

</html>