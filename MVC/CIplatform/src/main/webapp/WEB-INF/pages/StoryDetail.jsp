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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Story Detail</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/MissionView.css">
<link rel="stylesheet" href="css/MissionView1.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css"
	integrity="sha512-wR4oNhLBHf7smjy0K4oqzdWumd+r5/+6QO/vDda76MW5iug4PT7v86FoEkySIJft3XA0Ae6axhIvHrqwm793Nw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.css"
	integrity="sha512-6lLUdeQ5uheMFbWm3CP271l14RsX1xtx+J5x2yeIDkkiBpeVTNhTqijME7GgRKKi6hCqovwCoBTlRBEC20M8Mg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
	integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>

	<!-- modal for change password -->
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
				<div class="modal-body d-flex justify-content-center">
					<label for="email">Enter email:</label> <input type="email"
						class="recommendEmail" id="email" name="email">
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn changepass"
						data-bs-dismiss="modal" onclick="recommendToCoworker()">Recommend</button>
				</div>
			</div>
		</div>
	</div>


	<div class="container-fluid p-0">
		<input type="text" class="userid" id="uidl" name="user_id"
			value="${user.user_id}" hidden> <input type="text"
			class="missionid" id="midl" name="mission_id"
			value="${story.mission.mission_id}" hidden>
		<!-- sidebar starts here -->
		<!-- by default sidebar is hidden -->

		<div class="sidebar" id="sidebar">

			<!-- image for closing the sidebar -->
			<div class="cross" id="cross"
				style="position: absolute; top: 15px; right: 10px;">
				<img src="images/cancel1.png" alt="" onclick="sidebarreveal()">
			</div>

			<!-- items that will be displayed inside the bar-->
			<div class="sidebar-content mt-5">
				<button class="btn stories">
					<a class="text-dark" href="/stories-landing.html" target="_self"
						style="text-decoration: none;">Stories</a>
				</button>

				<div class="accordion " id="accordionExample">
					<div class="accordion-item collapsed border-none">
						<div class="accordion-header" id="headingOne">
							<button class="accordion-button collapsed" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">
								Policy</button>
						</div>
						<div id="collapseOne" class="accordion-collapse collapse"
							aria-labelledby="headingOne" data-bs-parent="#accordionExample">
							<div class="mb-3 d-flex">
								<a class="text-dark px-4 pt-3" href="#">Volunteering</a>
							</div>

							<div class="my-3 d-flex">
								<a class="text-dark px-4 py-3" href="#">Sponsors</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- sidebar ends here -->



		<div id="midcontainer">
			<div class="navbar main-nav d-flex"
				style="box-shadow: none; border-bottom: 2px solid rgba(128, 128, 128, 0.679);">

				<div class="leftside d-flex" style="text-transform: capitalize;">

					<img src="images/list.png" alt="hamberger" class="hambergericon"
						onclick="sidebarreveal()"
						style="display: none; width: 2.5rem; height: 1.5rem; padding-right: 15px;">
					<img src="images/logo.png" alt="optimylogo">


					<button class="btn common-hide" style="box-shadow: none;">
						<a href=""
							style="text-decoration: none; color: rgba(0, 0, 0, 0.66);">Stories</a>
					</button>

					<div class="dropdown common-hide">
						<a class="btn dropdown-toggle" href="#" style="box-shadow: none;"
							role="button" id="dropdownMenuLink" data-mdb-toggle="dropdown"
							aria-expanded="false"> policy </a>

						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<li><a class="dropdown-item" href="#">Volunteering</a></li>
							<li><a class="dropdown-item" href="#">Sponsors</a></li>
						</ul>
					</div>


				</div>

				<div class="rightside d-flex align-items-center">



					<button class="btn dropdown d-flex align-items-center  userprofile"
						type="button" id="dropdownMenuButton" data-mdb-toggle="dropdown"
						aria-expanded="false"
						style="box-shadow: none; text-transform: capitalize; width: 12rem;">

						<img src="images/<c:out value="${user.avatar}"></c:out>"
							class="userimage"> <span class="blocking uNameuImage">${user.first_name}
							${user.last_name}</span> <img src="images/drop-down.png" alt=""
							class="user-image-downarrow">
					</button>

					<ul class="dropdown-menu user" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="#">Dashboard</a></li>
						<li><a class="dropdown-item" href="#">My Account</a></li>
						<li><a class="dropdown-item" href="#">Help Center</a></li>
						<li><a class="dropdown-item" href="#">LogOut</a></li>
					</ul>
				</div>
			</div>


			<div class="main-content mb-6" style="margin-bottom: 0 !important;">

				<div class="row mx-4 gx-5">

					<div class="col-xl-6 col-lg-12 col-12 col-md-12 px-1 cars">
						<div id="wrap">
							<ul id="slider" class="slider">
								<li class="slide-item"><img
									src="images/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
									alt="画像"></li>
								<li class="slide-item"><img
									src="images/CSR-initiative-stands-for-Coffee--and-Farmer-Equity-4.png"
									alt="画像"></li>
								<li class="slide-item"><img
									src="images/Education-Supplies-for-Every--Pair-of-Shoes-Sold-2.png"
									alt="画像"></li>
								<li class="slide-item"><img
									src="images/Plantation-and-Afforestation-programme-1.png"
									alt="画像"></li>
								<li class="slide-item"><img
									src="images/Nourish-the-Children-in--African-country-1.png"
									alt="画像"></li>
							</ul>
							<ul id="thumbnail_slider" class="thumbnail_slider">
								<li class="thumbnail-item"><img
									src="images/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
									alt="画像"></li>
								<li class="thumbnail-item"><img
									src="images/CSR-initiative-stands-for-Coffee--and-Farmer-Equity-1.png"
									alt="画像"></li>
								<li class="thumbnail-item"><img
									src="images/Education-Supplies-for-Every--Pair-of-Shoes-Sold-1.png"
									alt="画像"></li>
								<li class="thumbnail-item"><img
									src="images/Plantation-and-Afforestation-programme-1.png"
									alt="画像"></li>
								<li class="thumbnail-item"><img
									src="images/Nourish-the-Children-in--African-country-1.png"
									alt="画像"></li>
							</ul>
						</div>
					</div>

					<!-- carousel ends here *bottom of carousel working*-->


					<div class="col-xl-6 col-lg-12 col-md-12 col-12 px-6 right-content">

						<!-- story details 1 here -->


						<div class="SDimg d-flex justify-content-start">
							<img src="images/<c:out value="${user1.avatar}"></c:out>"
								class="userimage">
						</div>
						<div class="SDunameNviews d-flex justify-content-between">
							<div class="SDuname">${user1.first_name}${user1.last_name}</div>
							<div class="SDviews">
								<img src="images/eye.png" alt="">12000 Views
							</div>
						</div>
						<div class="SDdetails1">
							<p style="margin-top: 4%;">Lorem ipsum dolor, sit amet
								consectetur adipisicing elit. sed doLorem ipsum dolor, sit amet
								consectetur adipisicing elit. sed do</p>
							<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
								sed doLorem ipsum dolor, sit amet consectetur adipisicing elit.
								sed do</p>
							<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
								sed doLorem ipsum dolor, sit amet consectetur adipisicing elit.
								sed doLorem ipsum dolor, sit amet consectetur adipisicing elit.
								sed doLorem ipsum dolor, sit amet consectetur adipisicing elit.
								sed do</p>
						</div>
						<div
							class="d-flex justify-content-around flex-column flex-sm-column  flex-md-row gap-2">

							<button class="SDRecommend" data-bs-toggle="modal"
								data-bs-target="#exampleModal1">
								<i class="bi bi-person-add"></i> Recommend to a co-worker
							</button>

							<form action="openMission" method="GET">
								<button
									class="SDOpenMission d-flex align-items-center justify-content-center">
									<input type="text" class="userid" id="uidl" name="user_id"
										value="${story.user.user_id}" hidden> <input
										type="text" class="missionid" id="midl" name="mission_id"
										value="${story.mission.mission_id}" hidden> Open
									mission <i class="bi bi-arrow-right"></i>
								</button>
							</form>
						</div>
					</div>
				</div>


				<!-- down content -->

				<div class="SDdetaisTitle container">
					<h4>${story.mission.title}</h4>
				</div>


			</div>

			<!-- Related missionlist starts here` -->
			<div class="related-missions d-flex justify-content-center"
				style="border-top: 1px solid rgba(128, 128, 128, 0.495);"></div>

			<div class="container">
				<p style="margin-top: 4%;">Lorem ipsum dolor, sit amet
					consectetur adipisicing elit. sed doLorem ipsum dolor, sit amet
					consectetur adipisicing elit. sed do Lorem ipsum dolor, sit amet
					consectetur adipisicing elit. sed doLorem ipsum dolor, sit amet
					consectetur adipisicing elit. sed do</p>
				<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. sed
					doLorem ipsum dolor, sit amet consectetur adipisicing elit. sed
					doLorem ipsum dolor, sit amet consectetur adipisicing elit. sed
					doLorem ipsum dolor, sit amet consectetur adipisicing elit. sed do
				</p>
				<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. sed
					doLorem ipsum dolor, sit amet consectetur adipisicing elit. sed
					doLorem ipsum dolor, sit amet consectetur adipisicing elit. sed
					doLorem ipsum dolor, sit amet consectetur adipisicing elit. sed do
				</p>
			</div>


			<!-- mission list ends here -->
			<div class="footer mt-3 d-flex container">
				<a href="#" class="px-3 text-black">Privacy Policy</a> <a href="#"
					class="px-2 text-black">Contact Us</a>
			</div>
		</div>



	</div>
</body>

<script src="js/bootstrap.min.js"></script>
<!--<script src="/js/missionview.js"></script>-->

<!-- slick-carousel -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
	integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
	integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<!-- slick carsousel -->


<script>
	let user_id=$('.userid').val();
	let mission_id=$('.missionid').val();
	
	$(document).ready(function(){
		
		$("#slider").slick({
            autoplay: true,
            speed: 800,
            arrows: false,
            asNavFor: "#thumbnail_slider"
        });
        $("#thumbnail_slider").slick({
            slidesToShow: 4,
            speed: 800,
            arrows: true,
            focusOnSelect: true,
            asNavFor: "#slider"
        });
        loadMedia(mission_id);
	});
	 function loadMedia(mission_id){
	    $.ajax({
	        url: "loadDraftMedia",
	    	dataType: 'json',
	        data:{'user_id': user_id,
	           	  'mission_id':mission_id},
	        success: function(response){
	        	console.log(response);
	           	setDraftMedia(response);
	    	}
		});
	}
	function setDraftMedia(draftedMedia){
		let data1="";
		let data2="";
	    for(i in draftedMedia){
	    	data1+=`<li class="slide-item">
	    			<img src="<c:out value="images/`+draftedMedia[i].path+`"/>" alt="画像"></li>`;
	    	data2+=`<li class="thumbnail-item">
	    			<img src="<c:out value="images/`+draftedMedia[i].path+`"/>" alt="画像"></li>`;
		}
	    console.log(data1);
	    console.log(data2);
	  	$(".slider").html(data1);
	  	$(".thumbnail_slider").html(data2);
	}
	function recommendToCoworker(){
		let recommendEmail=$('.recommendEmail').val();
		$.ajax({
            url: "recommendMissionFromStory",
    		dataType: 'json',
            data:{'mid':mission_id,
            	  'email':recommendEmail,
            	  'from':user_id},
            type:"GET",
            success: function(response){
            	console.log(response);
        	}
		});
	}

</script>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.js"></script>
<script>
	var side = document.getElementById("sidebar")
	var sidefilter = document.getElementById("sidebar-filters")
	var search = document.getElementById("searchbutton")
	var inputbox = document.getElementById("search")
	
// 	search.addEventListener("click", () => {
// 	    inputbox.focus();
// 	})
// 	search1.addEventListener("click", () => {
// 	    inputbox.focus();
// 	})
    function sidebarreveal() {
        side.classList.toggle("sidebar-show")
        document.getElementById("midcontainer").classList.toggle("blur")

    }

    function filterreveal() {
        sidefilter.classList.toggle("filter-show")
        document.getElementById("midcontainer").classList.toggle("blur")
    }

</script>

</html>