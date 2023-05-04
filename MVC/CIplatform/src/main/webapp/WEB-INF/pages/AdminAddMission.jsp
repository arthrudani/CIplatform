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
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link> 
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;900&display=swap" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Noto Sans' rel='stylesheet'>
    <title>Admin add new mission</title>
    <link rel="stylesheet" href="css/Admin.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="icon" href="" type="images/x-icon">
    
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/rowreorder/1.3.2/css/rowReorder.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">

			<!-- sidebar -->
			<div class="col-auto col-md-3 col-lg-3 col-xl-2 sidebar">
				<div
					class="d-flex flex-column align-items-center align-items-sm-start pt-2 text-white min-vh-100">
					<a href="/"
						class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-decoration-none">
						<span class="fs-5 d-none d-sm-inline">Menu</span>
					</a>
					<ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
                        id="menu">

                        <li class="nav-item  ">
                        	<form action="usersLoader" name="usersLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
	                            <button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                                <i class="bi bi-person-fill"></i><span
                                    class="ms-1 d-none d-sm-inline sidebarbuttons" >User</span>
	                            </a></button>
                            </form>
                        </li>
                        <li class="nav-item">
							<form action="cmsPageLoader" name="cmsPageLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
								<button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                                <i class="bi bi-file-earmark-medical-fill"></i><span
	                                    class="ms-2 d-none d-sm-inline sidebarbuttons">CMS Page</span>
	                            </a></button>
                            </form>
                        </li>
                        <li class="nav-item activepage">
                            <form action="missionLoader" name="missionLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
	                            <button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                               	<i class="bi bi-bullseye" style="color: #F88634;"></i><span
	                                    class="ms-2 d-none d-sm-inline sidebarbuttons" style="color: #F88634;">Missions</span>
	                            </a></button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="missionThemeLoader" name="missionThemeLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
	                            <button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                                <i class="bi bi-columns-gap"></i> <span
	                                    class="ms-2 d-none d-sm-inline sidebarbuttons">Mission Theme</span>
	                            </a></button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="missionSkillLoader" name="missionSkillLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
	                            <button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                                <i class="bi bi-tools"></i></i><span
	                                    class="ms-2 d-none d-sm-inline sidebarbuttons">Mission Skill</span>
	                            </a></button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="missionApplicationLoader" name="missionApplicationLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
	                            <button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                                <i class="bi bi-folder-fill"></i><span
	                                    class="ms-2 d-none d-sm-inline sidebarbuttons">Mission Application</span>
	                            </a></button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="storyLoader" name="storyLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
	                            <button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                                <i class="bi bi-bookmark-star-fill"></i><span
	                                    class="ms-2 d-none d-sm-inline sidebarbuttons">Story</span>
	                            </a></button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="bannerManagementLoader" name="bannerManagementLoader">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
	                            <button type="submit" class="dropdown-item"><a class="nav-link align-middle px-0">
	                                <img src="images/folded-ribbon.png" alt=""> <span
	                                    class="ms-2 d-none d-sm-inline sidebarbuttons">Banner Management</span>
	                            </a></button>
                            </form>
                        </li>

                    </ul>
					<hr>
				</div>
			</div>

			<!-- main content -->
			<div class="container">
			<div class="col py-3">
				<div class="headerbar d-flex justify-content-between">
					<div class="d-flex align-items-center">Thursday november 3,
						2022, 10:06 AM</div>
					<div class="d-flex justify-content-between align-items-center ">
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
					</div>
				</div>
				<div class="headerborder"></div>

				<div class="EPbasicInfo addbox">
					<div class="addtext">
						<p class="mt-2 ms-3">Add new mission</p>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Mission Title</div>
							<input type="text" name="title" class="ms-3 mt-2 me-3 titlebox missionTitle" required>
						</div>
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Mission short description</div>
							<input type="text" name="description" class="ms-3 mt-2 me-3 titlebox missionShortDescription" required>
						</div>
					</div>

					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Mission description</div>
							<div id="editor" class="missionDescription" name="storyDetails" class="w-100"></div>
						</div>
					</div>
					
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Country</div>
								<div class="col">
									<select name="country" id="country" class="countrySelector cmsStatus titlebox ms-3 mt-2 me-3">
										<option value="country" hidden>Country</option>
									</select>
								</div>
						</div>
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">City</div>
								<div class="col">
									<select name="city" id="city" class="citySelector cmsStatus titlebox ms-3 mt-2 me-3">
										<option value="city" hidden>City</option>
									</select>
								</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Mission organization name</div>
							<input type="text" name="employeeid" class="ms-3 mt-2 me-3 titlebox missionOrganizationName" required>
						</div>
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Mission organization detail</div>
							<input type="text" name="department" class="ms-3 mt-2 me-3 titlebox missionOrganizationDetail" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Mission start date</div>
							<input type="date" class="missionStartDate" id="missionStartDate" name="missionStartDate" placeholder="Select Date">
						</div>
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Mission end date</div>
							<input type="date" class="missionEndDate" id="missionEndDate" name="missionEndDate" placeholder="Select Date">
						</div>
					</div>

					<div class="col">
						<div class="ms-3 mt-3 titleOfAddbox">Mission type</div>
						<div class="col">
							<select name="Status" id="Status" class="cmsStatus missionType titlebox ms-3 mt-2 me-3" required>
									<option value="NONE" selected>Select mission type</option>
									<option value="TIME">TIME</option>
									<option value="GOAL">GOAL</option>
							</select>
						</div>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Total seats</div>
							<input type="number" id="quantity" class="missionSeats" name="quantity" min="1">
						</div>
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Registration deadline</div>
							<input type="date" class="registrationDeadline" id="registrationDeadline" name="registrationDeadline" placeholder="Select Date">
						</div>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Goal value</div>
							<input type="number" id="quantity" class="goalValue ms-3 mt-2 me-3 titlebox" name="quantity" min="1">
						</div>
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Goal objective</div>
							<input type="text" class="goalObjective ms-3 mt-2 me-3 titlebox" id="goalObjective" name="goalObjective" placeholder="Goal objective">
						</div>
					</div>
					
					<div class="d-flex EPnameSurname justify-content-around mt-1 row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Theme</div>
							<div class="col">
								<select name="theme" id="theme" class="missionTheme cmsStatus titlebox ms-3 mt-2 me-3">
									<option value="theme" hidden>Theme</option>
								</select>
							</div>
						</div>
						<div class="col">
						<div class="ms-3 mt-3 titleOfAddbox">Skill</div>
							<div class="col">
							
								<button class="btn btn-secondary dropdown-toggle skillbutton" type="button"
									id="dropdownMenuButton1" data-bs-toggle="dropdown"
									aria-expanded="false">
									<div class="d-flex justify-content-between align-items-center " style="margin-top:-3px;">
										<span style="color:black;">Skills</span> 
										<img src="images/drop-down.png">
									</div>
								</button> 	
								<ul class="dropdown-menu posStatic missionSkill cmsStatus" name="skill" id="skill" 
									aria-labelledby="dropdownMenuButton1">
					
								</ul>
			
<!-- 								<select name="skill" id="skill" class="missionSkill cmsStatus titlebox ms-3 mt-2 me-3"> -->
<!-- 									<option value="skill" hidden>Skill</option> -->
<!-- 								</select> -->
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Enter images</div>
								<div class="container strUploadBox">
									<fieldset class="d-flex justify-content-center">
										<a href="javascript:void(0)" onclick="$('#pro-image').click()">
											<div class="strUploadImg d-flex align-items-center flex-column">
												<i class="bi bi-plus"></i>
											</div>
											<div class="UploadText">Drag and drop pictures here</div>
										</a> 
										<input type="file" id="pro-image" name="pro-image" style="display: none;" class="form-control storyImages" multiple>
									</fieldset>
								</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="ms-3 mt-3 titleOfAddbox">Enter documents</div>
								<div class="container strUploadBox">
									<fieldset class="d-flex justify-content-center">
										<a href="javascript:void(0)" onclick="$('#pro-docs').click()">
											<div class="strUploadImg d-flex align-items-center flex-column">
												<i class="bi bi-plus"></i>
											</div>
											<div class="UploadText">Drag and drop documents here</div>
										</a> 
										<input type="file" id="pro-docs" name="pro-docs" style="display: none;" class="form-control storyImages" accept="image/*" multiple>
									</fieldset>
								</div>
						</div>
					</div>
					
					<div class="col">
						<div class="ms-3 mt-3 titleOfAddbox">Mission availability</div>
						<div class="col">
							<select name="Status" id="Status" class="cmsStatus missionAvailability titlebox ms-3 mt-2 me-3" required>
								<option value="DAILY">DAILY</option>
								<option value="WEEKLY">WEEKLY</option>
								<option value="MONTHLY">MONTHLY</option>
							</select>
						</div>
					</div>
					
					<div class="col">
					<div class="ms-3 mt-3 titleOfAddbox">Enter video url</div>
						<input type="text" name="videoURL" class="form-control videoURL" id="Videourl">
					</div>

					
					<button type="submit" class="addbutton d-flex align-items-center ms-3 mt-3 mb-3" onclick="addNewMission()">
						<i class="bi bi-plus"></i>ADD
					</button>
				</div>
			</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/rowreorder/1.3.2/js/dataTables.rowReorder.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.4.0/js/dataTables.responsive.min.js"></script>
    <script>
    let profilePic="";
    let city="";
	let country="";
	var selectedSkill=[];
	let missionTitle;
	let missionShortDescription;
	let missionDescription;
	let missionOrganizationName;
	let missionOrganizationDetail;
	let missionStartDate;
	let missionEndDate;
	let missionType;
	let missionSeats=0;
	let goalValue;
	let goalObjective="";
	let registrationDeadline=new Date();
	let missionTheme;
	let missionSkill;
	var files=[];
	var docs=[];
	let images=[];
	let documents=[];
	let missionAvailability;
	let videoURL;
    var myeditor;
        $(document).ready(function () {
        	
        	ClassicEditor
            .create(document.querySelector('#editor'))
            .then(editor => {
            	myeditor=editor;
            })
            .catch(error => {
            });
        	$.ajax({
				url : "loadListOfCountry",
				dataType : 'json',
				success : function(response) {
					countries = response;
					addCountryList(countries);
				}
			});
        	$.ajax({
				url : "loadListOfSkill",
				dataType : 'json',
				success : function(response) {
					addSkillList(response);
				}
			});
        	$.ajax({
				url : "loadListOfTheme",
				dataType : 'json',
				success : function(response) {
					themes = response;
					addThemeList(themes);
				}
			});
        	$('.missionTitle').on('change', function() {
        		missionTitle = $('.missionTitle').val();
        	});
        	$('.missionShortDescription').on('change', function() {
        		missionShortDescription = $('.missionShortDescription').val();
        	});
        	$('.missionDescription').on('change', function() {
        		missionDescription = $('.missionDescription').val();
        	});
			$('#country').on('change', function() {
				country = $(this).find("option:selected").val();
				getCityList(country);
			});
			$('#city').on('change', function() {
				city = $(this).find("option:selected").val();
			});
			$('.missionOrganizationName').on('change', function() {
				missionOrganizationName = $('.missionOrganizationName').val();
        	});
			$('.missionOrganizationDetail').on('change', function() {
				missionOrganizationDetail = $('.missionOrganizationDetail').val();
        	});
			$('.missionStartDate').on('change', function() {
				missionStartDate = $('.missionStartDate').val();
        	});
			$('.missionEndDate').on('change', function() {
				missionEndDate = $('.missionEndDate').val();
        	});
			$('.missionType').on('change', function() {
				missionType = $('.missionType').val();
				if(missionType=="GOAL"){
					$( ".missionSeats" ).prop( "disabled", true );
					$( ".registrationDeadline" ).prop( "disabled", true );
					$( ".goalValue" ).prop( "disabled", false );
					$( ".goalObjective" ).prop( "disabled", false );
				}
				else {
					$( ".goalValue" ).prop( "disabled", true );
					$( ".goalObjective" ).prop( "disabled", true );
					$( ".missionSeats" ).prop( "disabled", false );
					$( ".registrationDeadline" ).prop( "disabled", false );
				}
        	});
			$('.missionSeats').on('change', function() {
				missionSeats = $('.missionSeats').val();
        	});
			$('.registrationDeadline').on('change', function() {
				registrationDeadline = $('.registrationDeadline').val();
        	});
			$('.goalValue').on('change', function() {
				goalValue = $('.goalValue').val();
        	});
			$('.goalObjective').on('change', function() {
				goalObjective = $('.goalObjective').val();
        	});
			$('.missionTheme').on('change', function() {
				missionTheme = $('.missionTheme').val();
        	});
			$("#wizard-picture").change(function(){
			    readURL(this);
			});
			$("#wizard-documents").change(function(){
			    readURL(this);
			});
			$('.missionAvailability').on('change', function() {
				missionAvailability = $('.missionAvailability').val();
        	});
			$('.videoURL').on('change', function() {
				videoURL = $('.videoURL').val();
        	});
        	
        });
        function addNewMission(){
        	city=Number(city);
        	country=Number(country);
        	missionTheme=Number(missionTheme);
        	var formData = new FormData();
        	
        	var totalImages = files.length;
            for (var i = 0; i < totalImages; i++) {
                formData.append("images",files[i]);
            }
        	var totalDocFiles = docs.length;
            for (var i = 0; i < totalDocFiles; i++) {
                formData.append("documents",docs[i]);
            }
            	formData.append("missionId",0);
	        	formData.append("title", missionTitle);
	        	formData.append("shortDescription", missionShortDescription);
	        	formData.append("description", myeditor.getData());
	      		formData.append("country", country);
	        	formData.append("city", city);
	        	formData.append("organizationName", missionOrganizationName);
	        	formData.append("organizationDetail", missionOrganizationDetail);
	        	formData.append("startDate", new Date(missionStartDate));
	       		formData.append("endDate",new Date(missionEndDate));
	       		formData.append("type", missionType);
	        	formData.append("totalSeats", missionSeats);
	        	formData.append("registrationDeadline",new Date(registrationDeadline));	        	
	        	formData.append("goalValue",goalValue);
	        	formData.append("goalObjective",goalObjective);
	        	formData.append("themeId", missionTheme);
	        	formData.append("skill", selectedSkill);
	        	formData.append("availability", missionAvailability);
	        	formData.append("videoUrl", videoURL);
	        	formData.append("status","ACTIVE");
	        	
    			$.ajax({
    				url : "addNewMission",
    				dataType : 'json',
    				data:formData,
    	            type:"POST",
    	            processData: false,
    	            contentType: false,
    				success : function(response) {
    					if(response==1){
    						swal("Good job!", "Mission added successfully!", "success");
//     						window.location.reload();
    					}
    					else{
    						swal("Error!", "Email id already exists!", "error");
    					}
    				}
    			});
        }
        function addCountryList(country) {
			var data = "";
			for ( var i in country) {
				data += '<option value="'+country[i].country_id+'"> ' + country[i].name + '</option>';
			}
			$("#country").append(data);
		}
        function addSkillList(SkillList){
		    $("#skill").empty();
		   	var data="";
			for(var i in SkillList){
		    	data+='<input type="checkbox" onChange="skillCheckedClickEvent()" value="'+SkillList[i].skill_id+'"/> '+SkillList[i].skill_name+'<br>';
			}
		    $("#skill").html(data);
		}
        function skillCheckedClickEvent(){
			selectedSkill=[];
			$('#skill input:checked').each(function(){
       		if (!selectedSkill.includes($(this).attr('value'))) {
       			 selectedSkill.push($(this).attr('value'));
       			}
        	});
		}
        function addThemeList(themes) {
			var data = "";
			for ( var i in themes) {
				data += '<option value="'+themes[i].mission_theme_id+'"> ' + themes[i].title + '</option>';
			}
			$(".missionTheme").append(data);
		}
        function readURL(input) {
		    if (input.files && input.files[0]) {
		        var reader = new FileReader();

		        reader.onload = function (e) {
		            $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
		        }
		        reader.readAsDataURL(input.files[0]);
		    }
		    profilePic=input.files[0].name;
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
			
			for ( var i in cityList) {
				data +='<option value="' + cityList[i].city_id + '"> ' + cityList[i].name + '</option>';
			}
			$("#city").append(data);
		}
    </script>
    <script>
        
    </script>

	<script src="js/EditProfile.js"></script>
	<script src="js/AddMission.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
</body>

</html>