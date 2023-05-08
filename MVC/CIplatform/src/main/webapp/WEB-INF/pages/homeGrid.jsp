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
 <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>
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
<%-- 	<jsp:include page="Loader.jsp"></jsp:include> --%>
	<!-- modal for recommend mission -->
	<div class="modal " id="exampleModal1" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Recommend to
						co-worker</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body d-flex justify-content-center gap-5">
					<label for="email">Enter your email:</label> <input type="email"
						id="email" name="email" class="recommendToEmail">
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn changepass"
						data-bs-dismiss="modal"
						onclick="recommend()">Recommend</button>
				</div>
			</div>
		</div>
	</div>

	<!-- lower side open bar -->
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
		style="display: none;" id="leftMenu">
		<button onclick="closeLeftMenu()"
			class="w3-bar-item w3-button w3-large ">
			<img src="images/left.png">
		</button>

		<div class="dropdown button1">
			<button class="btn btn-secondary dropdown-toggle dropdownCity"
				type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">
				City <img src="images/drop-down.png">
			</button>
			<ul class="dropdown-menu posStatic citySelectorSidebar"
				aria-labelledby="dropdownMenuButton1" name="city">

			</ul>

			<br /> <br /> <select name="country" id="country"
				class="countrySelectSidebar">
				<input type="text" class="defaultCountry" hidden
				value="${user.country.country_id}">
				<option value="country" hidden>Country</option>
			</select> <br />

			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">
				Theme <img src="images/drop-down.png">
			</button>
			<ul class="dropdown-menu posStatic themeSelectorSidebar"
				aria-labelledby="dropdownMenuButton1">

			</ul>
			<br />

			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">
				Skills <img src="images/drop-down.png">
			</button>
			<ul class="dropdown-menu posStatic skillSelectorSidebar"
				aria-labelledby="dropdownMenuButton1">

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


				<form action="storiesLoaderSide" method="POST" name="storiesLoader">
					<button class="d-flex"
						style="background: none; border: none; min-width: 120px;"
						type="submit">
						<input type="text" class="userIdforNextpage" name="uid"
							value="${user_id}" hidden>
						<li class="nav-item upperButtons"><a class="nav-link"
							href="#">&nbsp;Stories</a></li>
					</button>
				</form>



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
	<div class="container-fluid borderH2 d-flex " style="border: 0;"> 
		<div class="container d-flex justify-content-around  ">

			<div class="d-flex ">

				<button class="w3-button " onclick="openRightMenu()">
					<img class="rightbutton" src="images/filter.png">
				</button>
			</div>




			<div class="col d-flex spacearound">

				<div class="leftHeader d-flex align-items-center">
					<ul
						class="navbar-nav d-flex flex-row justify-content-between align-items-center">
						<form action="storiesLoader" method="POST" name="storiesLoader">
							<button type="submit" class="d-flex"
								style="background: none; border: none; min-width: 120px;">
								<input type="text" class="userIdforNextpage" name="uid"
									value="${user_id}" hidden>
								<li class="nav-item upperButtons blocking">Stories</li>
							</button>
						</form>
						<li class="nav-item dropdown upperButtons blocking">
							<a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> &nbsp;Policy
								&nbsp; <img src="images/drop-down.png">
							</a>
							<ul class="dropdown-menu slugs posAbsolute"
								aria-labelledby="navbarDropdownMenuLink">
								
							</ul>
						</li>
					</ul>
				</div>

				<ul class="d-flex navbar-nav rightHeader align-items-between">
					<img class="rightbutton "
						style="padding-top: 22% !important; padding-right: 10%;"
						src="images/search.png">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle d-flex align-items-center gap-2"
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
							</div> <input type="text" class="usernameforlike" id="fname"
							name="fname" value="${user_id}" hidden>
							<div>
								<img src="images/drop-down.png" class="uNameuImage">
							</div>
					</a>

						<ul class="dropdown-menu posAbsolute dropdown-menu-end"
							aria-labelledby="navbarDropdownMenuLink">
							<form action="editProfile" method="POST" name="storiesLoader">
								<input type="text" class="userIdforNextpage" name="uid"
									value="${user_id}" hidden>
								<li><button type="submit" class="dropdown-item">Edit
										Profile</button></li>
							</form>
							<form action="volunteeringTimesheet" method="POST"
								name="storiesLoader">
								<input type="text" class="userIdforNextpage" name="uid"
									value="${user_id}" hidden>
								<li><button type="submit" class="dropdown-item">Volunteering
										timesheet</button></li>
							</form>

							<li><a class="dropdown-item" href="login">Logout</a></li>
						</ul></li>
				</ul>



			</div>


		</div>
	</div>

	<!-- lower nav bar -->
	<div class="container-fluid borderH2">
		<div class="d-flex justify-content-around" style="height:50px;">

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
				<ul class="dropdown-menu posStatic citySelector"
					aria-labelledby="dropdownMenuButton1" name="city">
				</ul>
				<br /> <select name="country" id="country" class="countrySelect">
					<input type="text" class="defaultCountry" hidden value="${user.country.country_id}">
					<option hidden>Country</option>
				</select> <br />


				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">
					Theme <img src="images/drop-down.png">
				</button>
				<ul class="dropdown-menu posStatic themeSelector"
					aria-labelledby="dropdownMenuButton1">

				</ul>
				<br />


				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton2" data-bs-toggle="dropdown"
					aria-expanded="false">
					Skills <img src="images/drop-down.png">
				</button>
				<ul class="dropdown-menu posStatic skillSelector"
					aria-labelledby="dropdownMenuButton1">

				</ul>

			</div>
		</div>
	</div>

	<!-- selected filters -->
	<div class="container filters w-100">
		<div class="row d-flex justify-content-center chips"></div>
	</div>

	<!-- missions sort and grid list button-->
	<div class="container mb-3 mt-3 d-flex justify-content-end">

		<div style="padding-right: 25px; height: 35px;">
			<select name="sortby" id="sortby" aria-label="Default select example"
				class="sortby form-select sortbybutton">
				<option value="sortBy" hidden>Sort by</option>
				<option value="Newest">Newest</option>
				<option value="Oldest">Oldest</option>
				<option value="LowestAvailable">Lowest available seats</option>
				<option value="HighestAvailable">Highest available seats</option>
				<option value="RegistrationDeadline">Registration deadline</option>
			</select> <br />
		</div>

		<button class="gridimg" onclick="gridlist()">
			<img src="images/grid.png" alt="">
		</button>
		<button class="listimg" onclick="listgrid()">
			<img src="images/list.png" alt="">
		</button>
	</div>


	<!-- explore all mission -->
	<div class="container">
		<p class="noOfMission">
			Explore <b id="noOfMission">${fn:length(missions)}</b> Mission
		</p>
	</div>

	<!-- clearall button  -->
	<div class="container">
		<div class="clearAll d-flex justify-content-end"></div>
	</div>
	
	<!-- 	total missions -->
	<div class="container grid-container gridListView">
		<div class="row" id="listgrid"></div>
		<div class="row" id="gridlist"></div>
	</div>

	<!-- 	pagination -->
	<div class="d-flex justify-content-center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">

			</ul>
		</nav>
	</div>


	<!-- footer -->
	<div class="container">
		<div class="EPfooterline "></div>
		<div class="EPprivacypolicy d-flex justify-content-start mt-3 gap-3">
			<div class="privacypolicy">
				<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
			</div>
			<div class="contactus">
				<a href="#"> Contact us</a>
			</div>
		</div>
	</div>

    <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
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
		let userId=$('.userIdforNextpage').val();
		let searchWord="";
		let missions="";
		let country="";
		let CheckedCountry="";
		let CheckedSortby="";
		let cityList="";
		let themeList=[];
		let skills=[];
		var CountryOfUser="";
		var selectedCity =[];
		var selectedTheme=[];
		var selectedSkill=[];
		let selecttedCityString="";
		let ThemeList="";
		let SkillList="";
		let UserList="";
		let likedMissionId=[];
		let totalmission="";
		let currentPage=0;
		let pagination="";
		let recommendToEmail="";
		let missionIdForRecommendation="";
	 
		$(document).ready(function() {
			$("#gridlist").hide();
			getLikedMission();
			updateMissionsOnChange();
			CountryOfUser=$(".defaultCountry").val;
	       	 /* Initial Mission Loading Function */     		 
	       	 $.ajax({
	                url: "loadAllMission",
	                dataType: 'json',
	                success: function(response){
		               	missions=response;
		               	var a=Object.keys(missions).length;
		               	editUpdatedMission(a);
		               	if(a==0){
		               		if($(".noMissionFound").length==0){
		               			noMissionFound();
		               		}
		               	}
		               	else{
		               		$(".noMissionFound").remove();
		               	}
		               	
		               	editpagination(a);             	                 	 
	                }
	            });
	       	 $.ajax({
	                url: "loadListOfCountry",
	                dataType: 'json',
	                success: function(response){
	               	country=response;
	               	addCountryList(country);
	                }
	            });
	       	 
	       	 $.ajax({
	                url: "loadListOfTheme",
	                dataType: 'json',
	                success: function(response){
	               	ThemeList=response;
	               	addThemeList(ThemeList);
	                }
	            });
	       	 
	       	$.ajax({
                url: "loadListOfSkill",
                dataType: 'json',
                success: function(response){
               	SkillList=response;
               	addSkillList(SkillList);
                }
            });
	       	
	       	$.ajax({
                url: "loadAllSlugs",
                dataType: 'json',
                success: function(response){
               		addSlugs(response);
                }
            });
	       	

	       	/* Search Mission Logic */
			$('.mySearchInput').keyup(function(){
	           	currentPage=0;
	         	updateMissionsOnChange();
	        });
			$('.recommendToEmail').keyup(function(){
				recommendToEmail=$('.recommendToEmail').val();
	        });
	       	 
	        $('.countrySelect, .countrySelectSidebar').on('change', function () {
	           	CheckedCountry = $(this).find("option:selected").val();
	            getCityList(CheckedCountry);
	           	currentPage=0;
	            updateMissionsOnChange();
	        });
	            
	        $('.sortby, .sortbySidebar').on('change', function () {
		        CheckedSortby = $(this).find("option:selected").val();
		       	currentPage=0;
		        updateMissionsOnChange();
		    });
	        
		});
		
		function addSlugs(slugs){
	     	var data="";
	     	for(var i in slugs){
	     		data+=`<li><a class="dropdown-item" href="PrivacyPolicy?uid=${user.user_id}">`+slugs[i].title+`</a></li>`;
	     	}
	     	$(".slugs").html(data);
	     }
		function getLikedMission(){
			let LikedMission=[];
			let user_id=$('.usernameforlike').val();
			let id=0;
			$.ajax({
                url: "loadAllMissionLikedByUser",
                type:"GET",
                data:{'uid':user_id},
                success: function(response){
                	const income=JSON.parse(response);
                   	for(var a in income){
                   		totallikedMission=a;
                   		LikedMission.push(income[a]);
                   		updateMissionsOnChange();
                   	}
                   	for (var a in LikedMission) {
                   		id=LikedMission[a].mission.mission_id;
                   		likedMissionId.push(id);       				
        			}
                }
            });
		}
		function cityCheckedClickEvent(){
			selectedCity=[];
			$('.citySelector input:checked , .citySelectorSidebar input:checked').each(function(){
				if($(this).attr('checked',true)){
					if (!selectedCity.includes($(this).attr('value'))) {
				     	selectedCity.push($(this).attr('value'));
		        		}
				}
            });
			 $('.citySelector input:checked , .citySelectorSidebar input:checked').each(function(){
					 if (!selectedCity.includes($(this).attr('value'))) {
		        		 	selectedCity.push($(this).attr('value'));
		        		 }
             });
			 currentPage=0;
			 updateMissionsOnChange();
        	 
		 }
		 
		 function themeCheckedClickEvent(){
			 selectedTheme=[];
			 $('.themeSelector input:checked , .themeSelectorSidebar input:checked').each(function(){
        		 if (!selectedTheme.includes($(this).attr('value'))) {
        			 selectedTheme.push($(this).attr('value'));
        		 }
             });
			 currentPage=0;
			 updateMissionsOnChange();
        	 
		 }
		 
		 function skillCheckedClickEvent(){
			 selectedSkill=[];
			 $('.skillSelector input:checked , .skillSelectorSidebar input:checked').each(function(){
        		 if (!selectedSkill.includes($(this).attr('value'))) {
        			 selectedSkill.push($(this).attr('value'));
        		 }
             });
			 currentPage=0;
			 updateMissionsOnChange();
        	 
		 }
		 
		 function addCityList(cityList){
	     	$(".citySelector").empty();
	     	$(".citySelectorSidebar").empty();
	     	var data="";
	     	let status=0;
	     	for(var i in cityList){
	     		status=1;
	     		data+='<input type="checkbox" onChange="cityCheckedClickEvent()" value="'+cityList[i].city_id+'"/> '+cityList[i].name+'<br>';
	     	}
	     	if(status==0){
	     		data+="No City Found";
	     	}
	     	$(".citySelector").append(data);
	     	$(".citySelectorSidebar").append(data);
	     }
		 
	     function addThemeList(ThemeList){
	     	$(".themeSelector").empty();
	     	$(".themeSelectorSidebar").empty();
	     	var data="";
	     	let status=0;
	     	for(var i in ThemeList){
	     		status=1;
	     		data+='<input type="checkbox" onChange="themeCheckedClickEvent()" value="'+ThemeList[i].mission_theme_id+'"/> '+ThemeList[i].title+'<br>';
	     	}
	     	if(status==0){
	     		data+="No Theme Found";
	     	}
	     	$(".themeSelector").append(data);
	    	$(".themeSelectorSidebar").append(data);
	    }

		function addSkillList(SkillList){
		    $(".skillSelector").empty();
		   	$(".skillSelectorSidebar").empty();
		   	var data="";
	     	let status=0;
			for(var i in SkillList){
		    	status=1;
		    	data+='<input type="checkbox" onChange="skillCheckedClickEvent()" value="'+SkillList[i].skill_id+'"/> '+SkillList[i].skill_name+'<br>';
		    }
		    if(status==0){
		    	data+="No Skill Found";
		    }
		    $(".skillSelector").append(data);
		    $(".skillSelectorSidebar").append(data);
		}
		function clearAllFilters(){
			CheckedCountry="";
			$('.citySelector input').prop('checked',false);
			$('.themeSelector input').prop('checked',false);
			$('.skillSelector input').prop('checked',false);
			$('.countrySelect').val('Country');
			$('.sortby').val('sortBy');
	        selectedCity.length=0;
			selectedTheme.length=0;
			selectedSkill.length=0;
			CheckedSortby="";
			$('.clearAll').html("");
			updateMissionsOnChange();
		}
		function  updateMissionsOnChange(){
       	let searchWord=$('.mySearchInput').val();
       	var selectedchips=""
       	
       	FilterObject={
       			searchedKeyword :searchWord ,
				country_id:CheckedCountry,
   				searchedcities:selectedCity,
   			 	searchedthemes:selectedTheme,
   				searchedskills:selectedSkill,
   				sortby:CheckedSortby,
   				currentPage:currentPage
   		}
       		
			$.ajax({
            	url: "searchMission",
                type: "POST",
                data:	{'Filters': JSON.stringify(FilterObject)},
                dataType: 'json',
                success: function(response){
               	const income=JSON.parse(response);
               	let totalMission=0;
               	for(var a in income){
               		totalMission=a;
               		missions=income[a];
               	}
               	if(FilterObject.searchedcities.length>0 || FilterObject.searchedskills.length>0 || FilterObject.searchedthemes.length>0 || FilterObject.sortby!="" || FilterObject.country_id!=""){
					let data=`<button class="clearAllButton" onclick="clearAllFilters()">Clear all<i class="bi bi-x"></i></button>`;
               		$('.clearAll').html(data);
               	}
               	else{
               		$('.clearAll').html("");
               	}
				editpagination(a);
               	editUpdatedMission(a);
               	loopForFetchingMissionDetails(missions);
               	if(a==0){
               		if($(".noMissionFound").length==0){
               			noMissionFound();
               		}
               	}
               	else{
               		$(".noMissionFound").remove();
               	}
                }
            });  
			
        }
		function getCityList(CheckedCountry){
        	//get City List
        	$.ajax({
                url: "loadListOfCity",
        		dataType: 'json',
                data:{countryId: CheckedCountry},
                type:"POST",
                success: function(response){
                	cityList=response;
                  	addCityList(cityList);
                   	}
               	});
        	}
        function editUpdatedMission(a){
        	$("#noOfMission").html(a);
        }
        function editpagination(totalMissions){
        	pagination="";
        	let perPageMission=3;
        	let totalPages=totalMissions/perPageMission;
        	if(totalMissions>perPageMission){
        		if(currentPage>0){
        			pagination+=`<li class="page-item"><a class="page-link" onclick="setcurrentpage(`+(currentPage-1)+`,`+totalMissions+`)" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span></a></li>`;
        		}
        		for(i=1;i<totalPages+1;i++){
        			if(i==currentPage+1){
        				pagination+=`<li class="page-item"><a class="page-link" onclick="setcurrentpage(`+(i-1)+`,`+totalMissions+`)" style="background-color: #f88634; color: white;">`+i+`</a></li>`;		
        			}
        			else{
	        			pagination+=`<li class="page-item"><a class="page-link" onclick="setcurrentpage(`+(i-1)+`,`+totalMissions+`)">`+i+`</a></li>`;		
        			}
        		}
        		if(currentPage<totalPages-1){
        			pagination+=`<li class="page-item"><a class="page-link" onclick="setcurrentpage(`+(currentPage+1)+`,`+totalMissions+`)" aria-label="Next"><span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span></a></li>`;
        		}
        	}
        	$(".pagination").html(pagination);
        }
        function setcurrentpage(CP,totalMissions){
        	currentPage=CP;
        	if(currentPage<totalMissions/3){
        		updateMissionsOnChange(); 
        	}
        }
        
        function noMissionFound(){
     		$(".gridListView").append('<h1 class="noMissionFound">No Mission Found</h1>');
     	}
        
        function addCountryList(country){
        	var data="";
        	data+='<option value="Country" hidden> Country</option>';
        	for(var i in country){
        		data+='<option value="'+country[i].country_id+'"> '+country[i].name+'</option>';
        	}
        	$(".countrySelect").append(data);
        	$(".countrySelectSidebar").append(data);
        }
        
        function likeMission(missionID,userID){
        	$.ajax({
                url: "likemission",
        		dataType: 'json',
                data:{'mid':missionID,
                	  'uid':userID},
                type:"GET",
                success: function(response){
                	likedMissionId=[];
                	getLikedMission();
                	updateMissionsOnChange();
                   	}
               	});
        	}
        function recommend(){
    		$.ajax({
                url: "recommendMission",
        		dataType: 'json',
                data:{'mid':missionIdForRecommendation,
                	  'email':recommendToEmail,
                	  'from':userId},
                type:"GET",
                success: function(response){
                	if(response==true){
                		swal("Success!", "Successfully recommended!", "success");
                	}
                	else if(response==false){
                		swal("Error!", "Email does not exists in database!", "error");
                	}
            	}
    		});
    	}
        
        function loopForFetchingMissionDetails(missions) {
        	$("#spinner-div").show();
			var htmlPageGrid = "";
			var htmlPageList = "";
			let sum=0;
			let average=0;
			
			for (let i = 0; i < missions.length; i++) {
				sum=0;
				for (let j = 0; j < missions[i].mission_ratings.length; j++) {
					if(missions[i].mission_ratings[j].rating==1){
						sum=sum+1;
					}
					if(missions[i].mission_ratings[j].rating==2){
						sum=sum+2;
					}
					if(missions[i].mission_ratings[j].rating==3){
						sum=sum+3;
					}
					if(missions[i].mission_ratings[j].rating==4){
						sum=sum+4;
					}
					if(missions[i].mission_ratings[j].rating==5){
						sum=sum+5;
					}
					else{
						sum=sum+0;	
					}
				}
				average=sum/missions[i].mission_ratings.length;
				let mytag="";
				if(!likedMissionId.includes(missions[i].mission_id)){
					mytag=`<i class="bi bi-heart"></i>`;
				}
				else{
					mytag=`<i class="bi bi-heart-fill" style="color:red;"></i>`;
				}
				var date_ob = new Date(missions[i].deadline);
				var year = date_ob.getFullYear();
				var month = ("0" + (date_ob.getMonth() + 1)).slice(-2);
				var date = ("0" + date_ob.getDate()).slice(-2);
				let timedate=year+"-"+month+"-"+date;
				let TimeOrGoal="";
				if(missions[i].mission_type=="TIME"){
					TimeOrGoal=`<div class="d-flex seatsleft align-items-center">
									<div>
										<img src="images/Seats-left.png" alt="">
									</div>
									<div>
										<div class="seatleftcontent11">`+missions[i].seatsLeft+`</div>
										<div class="seatleftcontent12">seats left</div>
									</div>
								</div>
								<div class="d-flex seatsleft align-items-center">
									<div>
										<img src="images/deadline.png" alt="">
									</div>
									<div>
										<div class="seatleftcontent11">`+timedate+`</div>
										<div class="seatleftcontent12">Deadline</div>
									</div>
								</div>`;
				}
				else{
					let progress=0;
					let volunteers=0;
					$.ajax({
						url : "loadGoalMission",
						dataType : 'json',
						data : {'mid' : missions[i].mission_id},
						type : "GET",
						success : function(response) {
							let x=response.goalValue;
							volunteers=response.alreadyVolunteer;
							$.ajax({
								url : "loadTotalActions",
								dataType : 'json',
								data : {'mid' : missions[i].mission_id},
								type : "GET",
								success : function(response) {
									progress=response;
									let j=(100*progress)/x;
									let progressbar=`<div class="progress-bar bg-warning" role="progressbar"
														style="width: `+j+`%; height: 10px;"
														aria-valuemin="0" aria-valuemax="100"></div>`;
									$(".progress"+missions[i].mission_id+"").html(progress);
									$(".volunteers"+missions[i].mission_id+"").html(volunteers);
									$(".progressbar"+missions[i].mission_id+"").html(progressbar);
								}
							});
						}
					});
					TimeOrGoal=`<div class="d-flex seatsleft align-items-center">
									<div>
										<img src="images/Seats-left.png" alt="">
									</div>
									<div>
										<div class="seatleftcontent11 volunteers`+missions[i].mission_id+`"></div>
										<div class="seatleftcontent12">Volunteered</div>
									</div>
								</div>
								<div class="d-flex seatsleft align-items-center">
									<div>
										<img src="images/deadline.png" alt="">
									</div>
									<div class="ms-3 deadlineOrProgress d-flex align-items-center" style="flex-direction: column;"> 
										<div class="progress margin-remove progressbar`+missions[i].mission_id+`" style="height: 10px; border-radius: 10px; width: 10rem;">
											
										</div>
										<div class="d-flex justify-content-between gap-3">
											<div class="progress`+missions[i].mission_id+`"></div>
											<div>Achieved</div>
										</div></div>
								</div>`;
				}
				
				let myrating="";
				if(average>4){
					myrating=`<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow"></i>
								</span>`;
					
				}
				else if(average>3){
					myrating=`<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>`;
				}
				else if(average>2){
					myrating=`<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>`;
				}
				else if(average>1){
					myrating=`<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>`;
				}
				else if(average>0){
					myrating=`<span class="starbutton">
									<i class="bi bi-star-fill" style="color:yellow  !important;"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>`;
				}
				else{
					myrating=`<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>
								<span class="starbutton">
									<i class="bi bi-star"></i>
								</span>`;
				}
				let imagepath="";
				if(missions[i].missionMedias.length>0){
					imagepath=missions[i].missionMedias[0].name;
				}
				else{
					imagepath="noImageFound.png";
				}
				let appliedOrClosed="";
				
				$.ajax({
	                url: "loadAppliedMissions",
	                type:"GET",
	                dataType: 'json',
	                data:{'uid':userId,
	                	  'mid':missions[i].mission_id},
	                success: function(response){
	                	
	                	if(response==true){
							appliedOrClosed=`<div class="posAbsolute appliedBox">
												Applied
											</div>`;
						}
						else if(response==false){
							appliedOrClosed=`<div class="posAbsolute openBox">
												Open
											</div>`;
						}
	                	if(missions[i].end_date<new Date()){
	                		appliedOrClosed=`<div class="posAbsolute closedBox">
												Closed
											</div>`;
	                	}
// 						$('.appliedOrClosed').html(appliedOrClosed);
	                }
	                
	            });
				
				var fromDate = new Date(missions[i].start_date);
				var toDate = new Date(missions[i].end_date);
				var fromyear = fromDate.getFullYear();
				var toyear = toDate.getFullYear();
				var frommonth = ("0" + (fromDate.getMonth() + 1)).slice(-2);
				var tomonth = ("0" + (fromDate.getMonth() + 1)).slice(-2);
				var fromdate = ("0" + toDate.getDate()).slice(-2);
				var todate = ("0" + toDate.getDate()).slice(-2);
				let finalFromDate=fromyear+"-"+frommonth+"-"+fromdate;
				let finalToDate=toyear+"-"+tomonth+"-"+todate;
				
				htmlPageGrid+=
				`<div class="col-12 col-md-6 col-lg-4">
				<div class="card ">
				<input type="text" class="missionIdForRecommendation" value="`+missions[i].mission_id+`" hidden>
					<img class="card-img-top" style="height:250px"
						src="images/`+imagepath+`">
					<div class="posAbsolute locationBox d-flex ">
						<i class="bi bi-geo-alt locicon"></i>
						<p>
						`+missions[i].city.name+`
						</p>
					</div>
					<div class="appliedOrClosed"></div>
					
					<div class="Favourite">
                	<button onclick="likeMission(`+missions[i].mission_id+`,`+${user_id}+`)" style="border:0; background:none;">
						<input type="text" class="userid" id="userid" name="uid" value="${user_id}" hidden>
					`+mytag+`</button>
                	</div>
                	<div class="Recommend " data-bs-toggle="modal" data-bs-target="#exampleModal1">
	                    <img src="images/user.png" alt="Favourite" srcset="">
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
							<input type="text" class="userid" name="mid" value="${average}" hidden>
							<div class="stars">
							`+myrating+`
							</div>
						</div>
						<hr class="lineintext">
						<div class="d-felx durationofmission">
							<div>
								<p>
									from
									`+finalFromDate+`
									untill
									`+finalToDate+`
								</p>
							</div>
						</div>

						<div class="d-flex justify-content-between TimeOrGoal"
							style="margin-top: 2%;">
							`+TimeOrGoal+`
						</div>
						<hr class="cardfooterline">
						<div class="d-flex justify-content-center mt-3">
							<form action="VolunteeringMission" method="GET" name="VolunteeringMission">
								<button class="d-flex apply " type="submit" style="min-width:120px";>
									<input type="text" class="missionIdforNextpage" name="mid" value="`+missions[i].mission_id+`" hidden>
									<input type="text" class="userIdforNextpage" name="uid" value="${user_id}" hidden>
									<div>Apply</div>
									<div>
										<img src="images/right-arrow.png" alt="">
									</div>
								</button>
							</form>
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
							<button onclick="likeMission(`+missions[i].mission_id+`,`+${user_id}+`)" style="border:0; background:none;">
							<input type="text" class="userid" name="mid" value="${user_id}" hidden>
							`+mytag+`</button>
						</div>
						
						<div class="missionLikeListView HLaddBox" data-bs-toggle="modal" data-bs-target="#exampleModal1">
							<i class="bi bi-person-plus"></i>
						</div>
						
						<div
							class="d-flex justify-content-center missionCategoryListView">
						`+missions[i].mission_theme.title+`
						</div>
						<img src="images/`+imagepath+`"
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
											<p>`+missions[i].city.name+`</p>
										</div>
										<div class="col d-flex">
											<i class="bi bi-globe"> </i>
											<p>`+missions[i].title+`</p>
										</div>
										<div class="col d-flex">
											<i class="bi bi-people"> </i>
											<p>`+missions[i].organization_name+`</p>
										</div>
									</div>
								</div>
								<div class="col d-flex justify-content-end">
									<div class="row ratingDivGridView">
										<div class="col">
										<input type="text" class="userid" name="mid" value="${average}" hidden>
											<div class="stars">
											`+myrating+`
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
									<div class="d-flex justify-content-between TimeOrGoal"
										style="margin-top: 2%;">
										`+TimeOrGoal+`
									</div>
									<div class="d-flex align-items-center HLfouricon">
										<img src="images/calender.png" alt="">
									</div>
									<div class="HLfouricontext">
										<div>
										from
										`+finalFromDate+`
										
										</div>
										<div>
										untill
										`+finalToDate+`
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
								<div class="d-flex">
									<form action="VolunteeringMission" method="POST" name="VolunteeringMission">
										<button class="d-flex apply " type="submit" style="min-width:120px";>
											<input type="text" class="missionIdforNextpage"  name="mid" value="`+missions[i].mission_id+`" hidden>
											<input type="text" class="userIdforNextpage" name="uid" value="${user_id}" hidden>
											<div>View Details</div>
											<div style="min-width: fit-content;">
												<img src="images/right-arrow.png" alt="">
											</div>
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>`;
		
			}
			$("#listgrid").html(htmlPageGrid);
			$("#gridlist").html(htmlPageList);
			$('.recommendButton').click(function(){
	        	missionIdForRecommendation=$('.missionIdForRecommendation').val();
	        });
		}
       
	</script>
</body>

</html>