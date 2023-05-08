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
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;900&display=swap" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Noto Sans' rel='stylesheet'>
    <title>Admin Mission</title>
    <link rel="stylesheet" href="css/Admin.css">
    <script src="js/time.js"></script>
    <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="icon" href="" type="images/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/rowreorder/1.3.2/css/rowReorder.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.dataTables.min.css">
</head>

<body onload=display_ct();>
    <div class="container-fluid">
        <div class="row flex-nowrap">

            <!-- sidebar -->
            <div class="col-auto col-md-3 col-lg-3 col-xl-2 sidebar">
                <div class="d-flex flex-column align-items-center align-items-sm-start pt-2 text-white min-vh-100">
                    <a href="/" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-decoration-none">
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
            <div class="col py-3">
                <div class="headerbar d-flex justify-content-between">
                    <div class="d-flex align-items-center" id="ct"></div>
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

                <div class="EPbasicInfo">
                    <p>Mission</p>
                </div>
                <div class="userborder"></div>

                <!-- searchbar -->
                <div class="d-flex justify-content-between">
                    <div class="searchBoxborder">
                        <div class="searchboxh2">
                            <button class="w3-button">
                                <img src="images/search.png">
                            </button>
                            <input type="search" placeholder=" Search missions..." id="searchboxing" name="search"
                                class="searchBoxPh">
                        </div>
                    </div>
                    <button class="addbutton">
                    	<a class="d-flex align-items-center btn" href="addNewMissionPage?uid=${user.user_id}">
                    	<i class="bi bi-plus"></i>ADD</a>
                    </button>
                </div>

                <!-- table -->
                <table id="example" class="display mt-4" style="width:100%">
                    <thead>
                        <tr>
                            <th>Mission Title</th>
                            <th>Mission type</th>
                            <th>Start date</th>
                            <th>End date</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                    </tbody>
                </table>

            </div>
        </div>
    </div>
    <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
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
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/rowreorder/1.3.2/js/dataTables.rowReorder.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.4.0/js/dataTables.responsive.min.js"></script>
    <script>
    	let table;
        $(document).ready(function () {
            table = $('#example').DataTable({
                rowReorder: {
                    selector: 'td:nth-child(2)'
                },
                responsive: true,
                aoColumnDefs: [
  	        	  {
  	        	     bSortable: false,
  	        	     aTargets: [ -1 ]
  	        	  }
  	        	]
            });
            $('#searchboxing').on('keyup', function () {
                table.search(this.value).draw();
            });
            loadAllMissionForAdmin();
        });
        function loadAllMissionForAdmin(){
        	$.ajax({
				url : "loadAllMissionForAdmin",
				dataType : 'json',
				type : "GET",
				success : function(response) {
					console.log(response);
					setAllMissionForAdmin(response);
				}
			});
        }
        function setAllMissionForAdmin(missions){
        	let data="";
        	let GEB="";
        	
        	for(var i in missions){
        		const dateObject1 = new Date(missions[i].start_date)
        		const humanDateFormat1 = dateObject1.toLocaleDateString("default");
        		const dateObject2 = new Date(missions[i].end_date)
        		const humanDateFormat2 = dateObject2.toLocaleDateString("default");
        		GEB=`<div class="d-flex gap-2">
        				<a type="submit" class="d-flex btn" href="editMissionPage?mid=`+missions[i].mission_id+`&auid=${user.user_id}"><img src="images/editing.png" alt=""></a>
   	            	 <button onclick="deleteMission(`+missions[i].mission_id+`)"><img src="images/delete.png" alt="" ></button></div>`;
        		table.row.add([
        			missions[i].title,
        			missions[i].mission_type,
        			humanDateFormat1,
        			humanDateFormat2,
        			GEB
        		]).draw(false);
        	}
        }
        function deleteMission(uid){
        	swal({
    	        title: "Warning",
    	        text: "Are you sure you want to delete this mission?",
    	        type: "warning",
    	        showCancelButton: true,
    	        confirmButtonColor: "#DD6B55",
    	        confirmButtonText: "Ok ",
    	        closeOnConfirm: false
    	    }, function (isConfirm) {
    	        if (!isConfirm) return;
    	        $.ajax({
						url : "deleteMission",
						dataType : 'json',
						data : {'mission_id' : uid},
						type : "GET",
						success : function(response) {
							swal("Success!", "Successfully deleted!", "success");
							loadAllMissionForAdmin();
						}
				});
    	    });
        }
    </script>

    <script src="js/EditProfile.js"></script>
</body>

</html>