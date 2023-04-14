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
<title>Story listing</title>
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


	<div class="container-fluid p-0">



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

					<div class="leftHeader ">
						<ul class="navbar-nav d-flex flex-row justify-content-between"
							style="padding-top: 7%;">
							<li class="nav-item dropdown upperButtons blocking"><a
								class="nav-link dropdown-toggle" href="#"
								id="navbarDropdownMenuLink" role="button"
								data-bs-toggle="dropdown" aria-expanded="false">
									&nbsp;Policy &nbsp; <img src="images/drop-down.png">
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

					<div class="d-flex ">
						<ul class="navbar-nav rightHeader align-items-between">
							<img class="rightbutton "
								style="padding-top: 22% !important; padding-right: 10%;"
								src="images/search.png">

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle d-flex align-items-center"
								href="#" id="navbarDropdownMenuLink" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"
								style="display: flex !important;"> <img
									src="images/<c:out value="${user.avatar}"></c:out>"
									class="userimage "> <span class="blocking uNameuImage">${user.first_name}
										${user.last_name}</span> <img src="images/drop-down.png"
									class="uNameuImage">
							</a>

								<ul class="dropdown-menu posAbsolute dropdown-menu-end"
									aria-labelledby="navbarDropdownMenuLink">
									<li><a class="dropdown-item" href="#">Action</a></li>
									<li><a class="dropdown-item" href="#">Another action</a></li>
									<li><a class="dropdown-item" href="#">Something else
											here</a></li>
								</ul></li>
						</ul>
					</div>


				</div>


			</div>
		</div>

		<!-- bigimage -->
		<div
			class="d-flex strmainimg align-items-center justify-content-center posRelative">
			<img src="images/Grow-Trees-2.png" class="w-100 " alt="">
			<div class="d-flex flex-column posAbsolute">
				<div class=" strShareStr1 ">Lorem, ipsum dolor sit amet
					consectetur adipisicing elit. Perspiciatis itaque sint voluptas
					iusto modi in harum aperiam ducimus, at error eos vitae atque vel
					voluptatibus aliquid minus inventore quaerat voluptate.</div>
				<div class="strShareStr2 justify-content-center">

					<form action="shareYourStory" method="POST" name="storiesLoader">
						<button type="submit" class="d-flex"
							style="background: none; border: none;">
							<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
							Share your story <i class="bi bi-arrow-right arrowright2"></i>
						</button>
					</form>
					
				</div>
			</div>
		</div>

		<div class="container grid-container">

			<!--         all stories -->
			<div class="row storycards"></div>

			<!-- 	pagination -->
			<div class="d-flex justify-content-center">
				<nav aria-label="Page navigation example">
					<ul class="pagination">

					</ul>
				</nav>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script>
	let stories=[];
	let currentPage=0;
	$(document).ready(function(){
		loadAllStories();
		loadNumberOfStoriesForPagination();
	});
	function loadNumberOfStoriesForPagination(){
		let STlength=0;
		$.ajax({
			url: "loadNumberOfStoriesForPagination",
			type: "POST",
            dataType: 'json',
            success: function(response){
            	STlength=response;
          		editpagination(STlength);
			}
		});
	}
	function loadAllStories(){
		$.ajax({
			url: "loadAllStories",
			type: "POST",
			data:	{'currentPage': currentPage},
            dataType: 'json',
            success: function(response){
            	stories=response;
          		updateStories(stories);
          		
			}
		});
	}
	function updateStories(story){
		let storyCards="";
		for (let i in story) {
			storyCards+=`<div class="col-12 col-md-6 col-lg-4">
				                <div class="card">
				                <div class="posRelative strCardBgBlack">
				                    <div class="strViewDetails posAbsolute"><button> View Details<i
				                                class="bi bi-arrow-right arrowright2"></i></button></div>
				                    <div class="strcategory posAbsolute">
				                        <p>Environment</p>
				                    </div>
				                    <img class="card-img-top img1"
				                        src="images/Grow-Trees-On-the-path-to-environment-sustainability-3.png">
				                </div>
				
				                <div class="card-body">
				
				                    <h5 class="card-title">`+story[i].title+`</h5>
				                    <p class="card-text">`+story[i].description+`</p>
				                    <div class="strCardFooter d-flex align-items-center">
				                        <img src="images/<c:out value="`+story[i].user.avatar+`"></c:out>" class="userimage">
				                        <p>`+story[i].user.first_name+story[i].user.last_name+`</p>
				                    </div>
				                </div>
				            </div>
				        </div>`;
				        
			
		}
		$(".storycards").html(storyCards);
		
	}
	function editpagination(totalMissions){
    	let pagination="";
    	let perPageMission=3;
    	let totalPages=totalMissions/perPageMission;
    	if(totalMissions>perPageMission){
    		pagination+=`<li class="page-item"><a class="page-link" onclick="setcurrentpage(`+(currentPage-1)+`,`+totalMissions+`)" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span></a></li>`;
    		for(i=1;i<totalPages+1;i++){
        		pagination+=`<li class="page-item"><a class="page-link" onclick="setcurrentpage(`+(i-1)+`,`+totalMissions+`)">`+i+`</a></li>`;		
    		}
			pagination+=`<li class="page-item"><a class="page-link" onclick="setcurrentpage(`+(currentPage+1)+`,`+totalMissions+`)" aria-label="Next"><span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span></a></li>`;
    	}
    	$(".pagination").html(pagination);
    }
	function setcurrentpage(CP,totalMissions){
		console.log(CP);
    	currentPage=CP;
    	if(currentPage<totalMissions/3){
    		loadAllStories(); 
    	}
    	else{
    		alert("Reached at the end of stories");
    	}
    }
</script>
</body>

</html>