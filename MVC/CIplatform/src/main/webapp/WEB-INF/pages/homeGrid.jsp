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
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;900&display=swap"
	rel="stylesheet">
<title>Home Grid</title>
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
<link rel="stylesheet" href="css/HomeGrid.css">
<script src="js/home.js"></script>
</head>

<body>

	<!-- lower side open bar -->
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
		style="display: none;" id="leftMenu">
		<button onclick="closeLeftMenu()"
			class="w3-bar-item w3-button w3-large ">
			<img src="images/left.png">
		</button>

		<div class="dropdown button1">
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">
				City <img src="images/drop-down.png">
			</button>
			<ul class="dropdown-menu posStatic"
				aria-labelledby="dropdownMenuButton1">
				<li><input type="checkbox">Ahmedabad</li>
				<li><input type="checkbox">Surat</li>
				<li><input type="checkbox">Mumbai</li>
				<li><input type="checkbox">New york</li>
				<li><input type="checkbox">London</li>
			</ul>
			<br />
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">
				Country <img src="images/drop-down.png">
			</button>
			<ul class="dropdown-menu posStatic"
				aria-labelledby="dropdownMenuButton1">
				<li><input type="checkbox">USA</li>
				<li><input type="checkbox">India</li>
				<li><input type="checkbox">UK</li>
			</ul>
			<br />
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">
				Theme <img src="images/drop-down.png">
			</button>
			<ul class="dropdown-menu posStatic"
				aria-labelledby="dropdownMenuButton1">
				<li><input type="checkbox">Action1</li>
				<li><input type="checkbox">Action2</li>
				<li><input type="checkbox">Action3</li>
			</ul>
			<br />
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">
				Skills <img src="images/drop-down.png">
			</button>
			<ul class="dropdown-menu posStatic"
				aria-labelledby="dropdownMenuButton1">
				<li><input type="checkbox">Action</li>
				<li><input type="checkbox">Action</li>
				<li><input type="checkbox">Action</li>
			</ul>
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
				<li class="nav-item upperButtons"><a class="nav-link" href="#">&nbsp;Stories</a>
				</li>

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




			<div class="col d-flex spacearound">
				<div class="d-flex align-items-center">
					<img src="images/logo.png" class="blocking">
				</div>

				<div class="leftHeader ">
					<ul class="navbar-nav d-flex flex-row justify-content-between"
						style="padding-top: 7%;">
						<li class="nav-item upperButtons blocking"><a
							class="nav-link" href="#">&nbsp;Stories</a></li>
						<li class="nav-item dropdown upperButtons blocking"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> &nbsp;Policy
								&nbsp; <img src="images/drop-down.png">
						</a>
							<ul class="dropdown-menu  posAbsolute"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
					</ul>
				</div>

				<ul class="d-flex navbar-nav rightHeader align-items-between">
					<img class="rightbutton "
						style="padding-top: 22% !important; padding-right: 10%;"
						src="images/search.png">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle d-flex align-items-center g-2"
						href="#" id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"
						style="display: flex !important">
							<div>
								<img src="images/<c:out value="${avatar}"></c:out>"
									class="userimage ">
							</div>
							<div>
								<span class="blocking uNameuImage" class="uNameuImage"><c:out
										value="${first_name} ${last_name}"></c:out></span>
							</div>
							<div>
								<img src="images/drop-down.png" class="uNameuImage">
							</div>
					</a>

						<ul class="dropdown-menu posAbsolute dropdown-menu-end"
							aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="#">Edit Profile</a></li>
							<li><a class="dropdown-item" href="#">Volunteering
									timesheet</a></li>
							<li><a class="dropdown-item" href="login">Logout</a></li>
						</ul></li>
				</ul>



			</div>


		</div>
	</div>

	<!-- lower nav bar -->
	<div class="container-fluid borderH2">
		<div class="d-flex justify-content-around">

			<div class="d-flex">

				<button class="w3-button ">
					<img class="blocking " src="images/search.png">
				</button>

				<input type="text" placeholder=" Search missions..."
					name="mySearchInput" class="mySearchInput searchBoxPh">

				<button class="w3-button rightbutton" onclick="openLeftMenu()">
					<img src="images/filter.png">
				</button>

			</div>

			<div class="dropdown d-flex blocking">

				<button class="btn btn-secondary dropdown-toggle dropdownCity"
					type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">
					City <img src="images/drop-down.png">
				</button>
				<ul class="dropdown-menu posStatic city"
					aria-labelledby="dropdownMenuButton1" name="city" id="totalCitiesOfCountry  city">
					<c:forEach var="city" items="${citylist}">
						<li>
							<input type="checkbox" class="citycheckbox" value="${city.name}"> 
							<c:out value="${city.name}"></c:out>
						</li>
					</c:forEach>
				</ul>
				<br /> <select name="country" id="country" class="country">
					<option value="${usercountry}" selected disabled hidden>
						<c:out value="${usercountry}"></c:out>
					</option>
					<c:forEach var="country" items="${countrylist}">
						<option>
							<c:out value="${country.name}"></c:out>
						</option>
					</c:forEach>
				</select> <br />


				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">
					Theme <img src="images/drop-down.png">
				</button>
				<ul class="dropdown-menu posStatic"
					aria-labelledby="dropdownMenuButton1">
					<li><input type="checkbox">Action1</li>
					<li><input type="checkbox">Action2</li>
					<li><input type="checkbox">Action3</li>
				</ul>
				<br />


				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">
					Skills <img src="images/drop-down.png">
				</button>
				<ul class="dropdown-menu posStatic"
					aria-labelledby="dropdownMenuButton1">
					<li><input type="checkbox">Action</li>
					<li><input type="checkbox">Action</li>
					<li><input type="checkbox">Action</li>
				</ul>

			</div>
		</div>
	</div>

	<!-- selected filters -->
	<div class="container filters w-100">
		<div class="row d-flex justify-content-center ">

			<div class="col filter justify-content-between">
				<span>&nbsp; tree plantation
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>

			<div class="col filter justify-content-between">
				<span>&nbsp; tree plantation
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>

			<div class="col filter justify-content-between">
				<span>&nbsp; tree plantation
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>
			<div class="col filter justify-content-between">
				<span>&nbsp; tree
					<button type="button" class="btn-close" aria-label="Close"></button>
				</span>
			</div>


		</div>
	</div>

	<!-- missions sort and grid list button-->
	<div class="container mb-3 mt-3 d-flex justify-content-end">

		<div class="dropdown sortbybutton">
			<button class="btn dropdown-toggle " type="button"
				data-toggle="dropdown">
				Sort By &nbsp; &nbsp; &nbsp; &nbsp;<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#">HTML</a></li>
				<li><a href="#">CSS</a></li>
				<li><a href="#">JavaScript</a></li>
			</ul>
		</div>

		<button class="gridimg" onclick="gridlist()">
			<img src="images/grid.png" alt="">
		</button>
		<button class="listimg" onclick="listgrid()">
			<img src="images/list.png" alt="">
		</button>
	</div>


	<!-- explore all mission -->
	<div class="container" id="totalmission">
		Explore all
		<c:out value="${fn:length(missionlist)}"></c:out>
		missions
	</div>

	<div class="container grid-container">

		<div class="row" id="listgrid">
			<c:forEach var="mission" items="${missionlist}">
				<div class="col-12 col-md-6 col-lg-4">
					<div class="card ">
						<img class="card-img-top"
							src="images/Grow-Trees-On-the-path-to-environment-sustainability-3.png">
						<div class="posAbsolute locationBox d-flex ">
							<i class="bi bi-geo-alt locicon"></i>
							<p>
								<c:out value="${mission.city.name}"></c:out>
							</p>
						</div>
						<div class="posAbsolute likeBox">
							<img src="images/heart.png" alt="">
						</div>
						<div class="posAbsolute addBox">
							<i class="bi bi-person-plus"></i>
						</div>
						<div class="card-body">
							<div class="d-flex justify-content-center">
								<div class="category">
									<c:out value="${mission.mission_theme.title}"></c:out>
								</div>
							</div>
							<h5 class="card-title">
								<c:out value="${mission.title}"></c:out>
							</h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
							<div class="d-flex justify-content-between"
								style="margin-bottom: 5%;">
								<div>
									<p class="card-text">Tree canada</p>
								</div>
								<div>
									<button class="starbutton">
										<img src="images/star.png" alt="">
									</button>
									<button class="starbutton">
										<img src="images/star.png" alt="">
									</button>
									<button class="starbutton">
										<img src="images/star.png" alt="">
									</button>
									<button class="starbutton">
										<img src="images/star.png" alt="">
									</button>
									<button class="starbutton">
										<img src="images/star.png" alt="">
									</button>
								</div>
							</div>
							<hr class="lineintext">
							<div class="d-felx durationofmission">
								<div>
									<p>
										from
										<fmt:formatDate pattern="dd-MM-yyyy"
											value="${mission.start_date}" />
										untill
										<fmt:formatDate pattern="dd-MM-yyyy"
											value="${mission.end_date}" />
									</p>
								</div>
							</div>

							<div class="d-flex justify-content-between "
								style="margin-top: 2%;">
								<div class="d-flex seatsleft">
									<div>
										<img src="images/Seats-left.png" alt="">
									</div>
									<div>
										<div class="seatleftcontent11">10</div>
										<div class="seatleftcontent12">seats left</div>
									</div>
								</div>
								<div class="d-flex seatsleft">
									<div>
										<img src="images/deadline.png" alt="">
									</div>
									<div>
										<div class="seatleftcontent11">10-10-2023</div>
										<div class="seatleftcontent12">Deadline</div>
									</div>
								</div>
							</div>
							<hr class="cardfooterline">
							<div class="d-flex justify-content-center">
								<button class="d-flex apply ">
									<div>Apply</div>
									<div>
										<img src="images/right-arrow.png" alt="">
									</div>
								</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<div class="row" id="gridlist">
			<c:forEach var="mission" items="${missionlist}">
				<div class="row ListViewCard">
					<div class="card">
						<div class="row g-0">
							<div class="col-md-3 missionImg">
								<p class="missionCityListView">
									<i class="bi bi-geo-alt"></i>
									<c:out value="${mission.city.name}"></c:out>
								</p>
								<!-- 								<p class="missionAppliedListView">Applied</p> -->
								<div class="missionLikeListView d-flex flex-column">
									<i class="bi bi-heart"></i><i class="bi bi-person-plus"></i>
								</div>
								<div
									class="d-flex justify-content-center missionCategoryListView">
									<c:out value="${mission.mission_theme.title}"></c:out>
								</div>
								<img
									src="images/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
									class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-md-9">
								<div class="card-body">
									<div class="row w-100 d-flex ">
										<div class="col">
											<div
												class="row d-flex justify-content-start firstInfoContainerListView">
												<div class="col d-flex">
													<i class="bi bi-geo-alt"> </i>
													<p>Atlanta</p>
												</div>
												<div class="col d-flex">
													<i class="bi bi-globe"> </i>
													<p>Environment</p>
												</div>
												<div class="col d-flex">
													<i class="bi bi-people"> </i>
													<p>Smith Caring Foundation</p>
												</div>
											</div>
										</div>
										<div class="col d-flex justify-content-end">
											<div class="row ratingDivGridView">
												<div class="col">
													<div class="row d-flex flex-row ratingStar flex-nowrap">
														<div class="col">
															<img src="images/selected-star.png" alt="" srcset="">
														</div>
														<div class="col">
															<img src="images/selected-star.png" alt="" srcset="">
														</div>
														<div class="col">
															<img src="images/selected-star.png" alt="" srcset="">
														</div>
														<div class="col">
															<img src="images/star.png" alt="" srcset="">
														</div>
														<div class="col">
															<img src="images/star.png" alt="" srcset="">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<h5 class="card-title">
										<c:out value="${mission.title}"></c:out>
									</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.</p>
									<div
										class="d-flex justify-content-between viewdetailsandfourbutton"
										style="margin-top: 7%;">
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center HLfouricon">
												<img src="images/Seats-left.png" alt="">
											</div>
											<div class="HLfouricontext">
												<div>397</div>
												<div>seats left</div>
											</div>
											<div class="d-flex align-items-center HLfouricon">
												<img src="images/achieved.png" alt="">
											</div>
											<div class="HLfouricontext">
												<div>397</div>
												<div>Achieved</div>
											</div>
											<div class="d-flex align-items-center HLfouricon">
												<img src="images/calender.png" alt="">
											</div>
											<div class="HLfouricontext">
												<div>
													from
													<fmt:formatDate pattern="dd-MM-yyyy"
														value="${mission.start_date}" />
												</div>
												<div>
													untill
													<fmt:formatDate pattern="dd-MM-yyyy"
														value="${mission.end_date}" />
												</div>
											</div>
											<div class="d-flex align-items-center HLfouricon">
												<i class="fa-solid fa-screwdriver-wrench"></i>
											</div>
											<div class="HLfouricontext">
												<div>Skills</div>
												<div>botany</div>
											</div>
										</div>
										<div class="d-flex HLviewdetailslist">
											View details <img src="images/right-arrow.png" alt="">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>


	<!-- footer -->
	<div class="container">
		<div class="EPfooterline "></div>
		<div class="EPprivacypolicy d-flex justify-content-start mt-3 gap-3">
			<div class="privacypolicy">
				<a href="#">Privacy policy</a>
			</div>
			<div class="contactus">
				<a href="#"> Contact us</a>
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

	<script src="https://code.jquery.com/jquery-3.6.4.js"
		integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- 	search filter scripts -->
	<script>
		$(document).ready(function() {
			$("#gridlist").hide();
			$("#loader").hide();
			
			var allfilters={
					searchedKeyword="";
					country_id="";
					searchedcities=[];
					searchedthemes=[];
					searchedskills=[];
			}
			
// 			ajax for search bar
			$(".searchBoxPh").keyup(function() {
				$("#loader").show();
				allfilters.searched
				var data1 = {
					key : $(allfilters).val()
				};
				console.log(data1)
// 				$.ajax({
// 					url : "searchMissions",
// 					type : "POST",
// 					data : data1,
// 					dataType : 'json',
// 					success : function(response) {
// 						$("#loader").hide();
// 						missions = response;
// 						loopForFetchingMissionDetails(missions);
// 						totalMissionCounter(missions);
// 					}
// 				});
			});
			
// 			ajax for country filter
			$(".country").on('change', function()  {
				var data1 = {
						key : $(this).val()
					};
				$.ajax({
					url : "searchMissionsByCountry",
					type : "POST",
					data : data1,
					dataType : 'json',
					success : function(response) {
						missions = response;
						cityOfSelectedCountry(data1);
						loopForFetchingMissionDetails(missions);
						totalMissionCounter(missions);
					}
				});
			});
			
//			ajax for city filter
			$(".citycheckbox").on('click', function()  {
				var chkArray = [];
				$(".citycheckbox:checked").each(function() {
		            chkArray.push($(this).val());
		        });
				var data1 = {
						key : $(".citycheckbox:checked").val()
					};
				console.log(data1);
				$.ajax({
					url : "searchMissionsByCity",
					type : "POST",
					data : data1,
					dataType : 'json',
					success : function(response) {
						missions = response;
						console.log(response);
						loopForFetchingMissionDetails(missions);
						totalMissionCounter(missions);
					}
				});
			});
		});
		
	
		
		function totalMissionCounter(missions){
			var totalmissions = "";
			var count = missions.length;
			if(count>0){
				totalmissions =`Explore all `+missions.length+` missions`;
			}
			else{
				totalmissions =`<div class="d-flex justify-content-center"><h2><b>NO MISSION FOUND</b></h2></div>`;
			}
			
			$("#totalmission").html(totalmissions);
		}

		function cityOfSelectedCountry(countryname){
			var citiesOfSelectedCountry="";
			citiesOfSelectedCountry=`1234`;
// 			for (let i = 0; i < missions.length; i++){
// 				citiesOfSelectedCountry+=`
// 						<li><input type="checkbox" class="citycheckbox"
// 							value=`+missions[i].city.name+`> `+missions[i].city.name+`</li>`;
// 			}
			$("#totalCitiesOfCountry").html(citiesOfSelectedCountry);
		}
		
		function loopForFetchingMissionDetails(missions) {
			var htmlPageGrid = "";
			var htmlPageList = "";
			
			for (let i = 0; i < missions.length; i++) {
				
				htmlPageGrid+=
				`<div class="col-12 col-md-6 col-lg-4">
				<div class="card ">
					<img class="card-img-top"
						src="images/Grow-Trees-On-the-path-to-environment-sustainability-3.png">
					<div class="posAbsolute locationBox d-flex ">
						<i class="bi bi-geo-alt locicon"></i>
						<p>
						`+missions[i].city.name+`
						</p>
					</div>
					<div class="posAbsolute likeBox">
						<img src="images/heart.png" alt="">
					</div>
					<div class="posAbsolute addBox">
						<i class="bi bi-person-plus"></i>
					</div>
					<div class="card-body">
					<div class="d-flex justify-content-center">
						<div class="category">
							`+missions[i].mission_theme.title+`
						</div>
					</div>
						<h5 class="card-title">
						`+missions[i].title+`
						</h5>
						<p class="card-text">This is a wider card with supporting
							text below as a natural lead-in to additional content. This
							content is a little bit longer.</p>
						<div class="d-flex justify-content-between"
							style="margin-bottom: 5%;">
							<div>
								<p class="card-text">Tree canada</p>
							</div>
							<div>
								<button class="starbutton">
									<img src="images/star.png" alt="">
								</button>
								<button class="starbutton">
									<img src="images/star.png" alt="">
								</button>
								<button class="starbutton">
									<img src="images/star.png" alt="">
								</button>
								<button class="starbutton">
									<img src="images/star.png" alt="">
								</button>
								<button class="starbutton">
									<img src="images/star.png" alt="">
								</button>
							</div>
						</div>
						<hr class="lineintext">
						<div class="d-felx durationofmission">
							<div>
								<p>
									from
									21-04-2023
									untill
									21-05-2023
								</p>
							</div>
						</div>

						<div class="d-flex justify-content-between "
							style="margin-top: 2%;">
							<div class="d-flex seatsleft">
								<div>
									<img src="images/Seats-left.png" alt="">
								</div>
								<div>
									<div class="seatleftcontent11">10</div>
									<div class="seatleftcontent12">seats left</div>
								</div>
							</div>
							<div class="d-flex seatsleft">
								<div>
									<img src="images/deadline.png" alt="">
								</div>
								<div>
									<div class="seatleftcontent11">10-10-2023</div>
									<div class="seatleftcontent12">Deadline</div>
								</div>
							</div>
						</div>
						<hr class="cardfooterline">
						<div class="d-flex justify-content-center">
							<button class="d-flex apply ">
								<div>Apply</div>
								<div>
									<img src="images/right-arrow.png" alt="">
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>`;
			
			
				htmlPageList+=
				`<div class="card">
				<div class="row g-0">
					<div class="col-md-3 missionImg">
						<p class="missionCityListView">
							<i class="bi bi-geo-alt"></i>
							`+missions[i].city.name+`
						</p>
						
						<div class="missionLikeListView d-flex flex-column">
							<i class="bi bi-heart"></i><i class="bi bi-person-plus"></i>
						</div>
						<div
							class="d-flex justify-content-center missionCategoryListView">
						`+missions[i].mission_theme.title+`
						</div>
						<img
							src="images/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
							class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-9">
						<div class="card-body">
							<div class="row w-100 d-flex ">
								<div class="col">
									<div
										class="row d-flex justify-content-start firstInfoContainerListView">
										<div class="col d-flex">
											<i class="bi bi-geo-alt"> </i>
											<p>Atlanta</p>
										</div>
										<div class="col d-flex">
											<i class="bi bi-globe"> </i>
											<p>`+missions[i].title+`</p>
										</div>
										<div class="col d-flex">
											<i class="bi bi-people"> </i>
											<p>Smith Caring Foundation</p>
										</div>
									</div>
								</div>
								<div class="col d-flex justify-content-end">
									<div class="row ratingDivGridView">
										<div class="col">
											<div class="row d-flex flex-row ratingStar flex-nowrap">
												<div class="col">
													<img src="images/selected-star.png" alt="" srcset="">
												</div>
												<div class="col">
													<img src="images/selected-star.png" alt="" srcset="">
												</div>
												<div class="col">
													<img src="images/selected-star.png" alt="" srcset="">
												</div>
												<div class="col">
													<img src="images/star.png" alt="" srcset="">
												</div>
												<div class="col">
													<img src="images/star.png" alt="" srcset="">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<h5 class="card-title">
								<c:out value="${mission.title}"></c:out>
							</h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
							<div
								class="d-flex justify-content-between viewdetailsandfourbutton"
								style="margin-top: 7%;">
								<div class="d-flex justify-content-between">
									<div class="d-flex align-items-center HLfouricon">
										<img src="images/Seats-left.png" alt="">
									</div>
									<div class="HLfouricontext">
										<div>397</div>
										<div>seats left</div>
									</div>
									<div class="d-flex align-items-center HLfouricon">
										<img src="images/achieved.png" alt="">
									</div>
									<div class="HLfouricontext">
										<div>397</div>
										<div>Achieved</div>
									</div>
									<div class="d-flex align-items-center HLfouricon">
										<img src="images/calender.png" alt="">
									</div>
									<div class="HLfouricontext">
										<div>
											from
											<fmt:formatDate pattern="dd-MM-yyyy"
												value="${mission.start_date}" />
										</div>
										<div>
											untill
											<fmt:formatDate pattern="dd-MM-yyyy"
												value="${mission.end_date}" />
										</div>
									</div>
									<div class="d-flex align-items-center HLfouricon">
										<i class="fa-solid fa-screwdriver-wrench"></i>
									</div>
									<div class="HLfouricontext">
										<div>Skills</div>
										<div>botany</div>
									</div>
								</div>
								<div class="d-flex HLviewdetailslist">
									View details <img src="images/right-arrow.png" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>`;
		
			}
			$("#listgrid").html(htmlPageGrid);
			$("#gridlist").html(htmlPageList);
			
		}
	</script>
</body>

</html>