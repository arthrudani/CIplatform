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
<title>Volunteering Timesheet</title>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/VolunteeringTimesheet.css">

</head>

<body>

	<!-- modal for volunteering hours -->
	<div class="modal " id="exampleModal1" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Please input
						below Volunteering Hours</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body ">

					<div class="margin2">Mission</div>
					<div>
						<select name="Mission" id="mission" class="missionSelectTime missionSelect">
							<option value="missionSelect" hidden>Select mission</option>
						</select>
					</div>

					<div class="margin2">Date</div>
					<input type="date" id="birthday" name="birthday"
						placeholder="Select Date" class="datetime" style="width: 100%;">

					<div class="row margin2">
						<div class="col-6 textarea">
							Hours <input type="number" name="Hours" class="form-control hours"
								id="hours quantity" aria-describedby="emailHelp"
								placeholder="Enter spent hours">
						</div>
						<div class="col-6 textarea">
							Minutes <input type="number" name="Minutes"
								class="form-control minutes" id="minutes quantity"
								aria-describedby="emailHelp" placeholder="Enter spent minutes">
						</div>
					</div>

					<div class="margin2">Message*</div>
					<textarea name="subject" id="subject"
						class="form-control textarea messagetime" aria-describedby="emailHelp"
						placeholder="Enter your message" required></textarea>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
					<button type="button" class="btn changepass"
						data-bs-dismiss="modal" aria-label="Close"
						onclick="validateData()">Save</button>
				</div>
			</div>
		</div>
	</div>

	<!-- modal for volunteering goals -->
	<div class="modal " id="exampleModal2" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Please input
						below Volunteering goals</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body ">

					<div class="margin2">Mission</div>
					<div>
						<select name="Mission" id="mission" class="missionSelectGoal missionSelect">
							<option value="missionSelect" hidden>Select mission</option>
						</select>
					</div>

					<div class="margin2">Actions</div>
					<input type="text" name="Actions" class="form-control action"
						id="hours" aria-describedby="emailHelp"
						placeholder="Enter actions" required>

					<div class="margin2">Date</div>
					<input type="date" placeholder="Select Date" class="dategoal"
						style="width: 100%;">

					<div class="margin2">Message*</div>
					<textarea name="subject" id="subject"
						class="form-control textarea messagegoal" aria-describedby="emailHelp"
						placeholder="Enter your message"></textarea>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
					<button type="button" class="btn changepass"
						data-bs-dismiss="modal" aria-label="Close"
						onclick="validateData()">Save</button>
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
			<div class="col d-flex justify-content-around align-items-center">
				<div class="d-flex justify-content-around align-items-center">
					<div>
						<form action="storiesLoader" method="POST" name="storiesLoader">
							<button type="submit" style="background: none; border: none; min-width: 120px;">
								<input type="text" class="userIdforNextpage" name="uid" value="${user.user_id}" hidden>
								<li class="nav-item upperButtons blocking ">Stories</li>
							</button>
						</form>
					</div>
					<div>
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
					</div>
				</div>
				<div class="d-flex ">
					<ul class="d-flex navbar-nav rightHeader align-items-center">
						<img class="rightbutton " src="images/search.png">

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
								<input type="text" class="usernameforlike" id="fname" name="fname" value="${user.user_id}" hidden>
								<div>
									<img src="images/drop-down.png" class="uNameuImage">
								</div>
							</a>

							<ul class="dropdown-menu dropdown-menu-end"
								aria-labelledby="navbarDropdownMenuLink" >
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

	<!-- main content -->
	<div class="VTheading container mt-5">Volunteering Timesheet</div>
	<div class="container grid-container">
		<div class="row">
			<!-- Volunteering hours  -->
			<div class="col-12 col-xl-6 mt-2">
				<div class="card">
					<div class="d-flex justify-content-between">
						<div class="title">Volunteering hours</div>
						<div class="modal-footer">
							<button type="button" class="btn changepass"
								data-bs-toggle="modal" data-bs-target="#exampleModal1"
								onclick="newTimesheet()">
								<i class="bi bi-plus"></i>Add
							</button>
						</div>
					</div>

					<table class="table table-borderless">
						<thead>
							<tr>
								<th scope="col">Mission</th>
								<th scope="col">Date</th>
								<th scope="col">Hours</th>
								<th scope="col">Minutes</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody class="timeBased">

						</tbody>
					</table>
				</div>
			</div>
			<!-- volunteering goals  -->
			<div class="col-12 col-xl-6 ">
				<div class="card ">
					<div class="d-flex justify-content-between">
						<div class="title">Volunteering goals</div>
						<div class="modal-footer">
							<button type="button" class="btn changepass"
								data-bs-toggle="modal" data-bs-target="#exampleModal2"
								onclick="newTimesheet()">
								<i class="bi bi-plus"></i>Add
							</button>
						</div>
					</div>
					<table class="table table-borderless">
						<thead>
							<tr>
								<th scope="col">Mission</th>
								<th scope="col">Date</th>
								<th scope="col">Action</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody class="goalBased">

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<div class="EPfooterline"></div>
	<div
		class="container EPprivacypolicy d-flex justify-content-start mt-3 gap-3">
		<div class="privacypolicy">
			<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
		</div>
		<div class="contactus">
			<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
		</div>
		<div class="contactus">
			<a href="PrivacyPolicy?uid=${user.user_id}">Privacy policy</a>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

	<script>
		var approvedMission = [];
		let CheckedMission;
		let date="";
		let hours=0;
		let minutes=0;
		let message="";
		let action=0;
		let user_id=$('.userIdforNextpage').val();
		let timesheetid=0;
		$(document).ready(function() {
			
			$('.missionSelectTime').on('change', function () {
	           	CheckedMission = $(this).find("option:selected").val();
	        });
			$('.missionSelectGoal').on('change', function () {
	           	CheckedMission = $(this).find("option:selected").val();
	        });
			$('.dategoal').on('change', function () {
				date = $('.dategoal').val();
	        });
			$('.datetime').on('change', function () {
				date = $('.datetime').val();
	        });
			$('.hours').on('change', function () {
				hours = $('.hours').val();
	        });
			$('.minutes').on('change', function () {
				minutes = $('.minutes').val();
	        });
			$('.messagegoal').on('change', function () {
				message = $('.messagegoal').val();
	        });
			$('.messagetime').on('change', function () {
				message = $('.messagetime').val();
	        });
			$('.action').on('change', function () {
				action = $('.action').val();
	        });
			$.ajax({
                url: "loadAllSlugs",
                dataType: 'json',
                success: function(response){
               		addSlugs(response);
                }
            });
			loadApprovedMissionsTimebased();
			loadApprovedMissionsGoalbased();
			loadAllTimesheetsByUser();
		});
		function addSlugs(slugs){
	     	var data="";
	     	for(var i in slugs){
	     		data+=`<li><a class="dropdown-item" href="PrivacyPolicy?uid=${user.user_id}">`+slugs[i].title+`</a></li>`;
	     	}
	     	$(".slugs").html(data);
	     }
		function validateData(){
			if(hours>23){
				swal("Error!", "Hours must be less than 24!", "error");
				return;
			}
			else if(minutes>59){
				swal("Error!", "Minutes must be less than 60!", "error");
				return;
			}
			else{
				saveTimesheet();
			}
		}
		function saveTimesheet(){
			ShareTimesheetObject={
					timesheetId:timesheetid,
					chekedMission :CheckedMission ,
					user_id:user_id,
					date:new Date(date),
					hours:hours,
					minutes:minutes,
					message:message,
					action:action
	   		}	
			$.ajax({
				url : "saveTimesheet",
				dataType : 'json',
				data : ShareTimesheetObject,
				type : "POST",
				success : function(response) {
					swal("Sucsess!", "Timesheet added successfully!", "success");
					loadAllTimesheetsByUser();
					newTimesheet();
				}
			});
		}
		function newTimesheet(){
			timesheetid=0;
			$('.missionSelect').val('');
			$('.datetime').val('');
			$('.dategoal').val('');
			$('.hours').val('');
			$('.minutes').val('');
			$('.messagegoal').val('');
			$('.messagetime').val('');
			$('.action').val('');
		}
		
		function loadAllTimesheetsByUser() {
			$.ajax({
				url : "loadTimesheetsByUser",
				dataType : 'json',
				data : {'user_id' : user_id},
				success : function(response) {
					setAllTimesheet(response);
				}
			});
		}
		function deleteTimeTimesheet(tid){
			$.ajax({
				url : "deleteTimesheet",
				dataType : 'json',
				data : {'timesheetId' : tid},
				type : "POST",
				success : function(response) {
					swal("Sucsess!", "Timesheet deleted successfully!", "success");
					loadAllTimesheetsByUser();
				}
			});
		}
		function setAllTimesheet(timesheet){
			var data1= "";
			var data2= "";
			for (var i in timesheet) {
				var todate=new Date(timesheet[i].dateVolunteered).getDate();
			    var tomonth=new Date(timesheet[i].dateVolunteered).getMonth()+1;
			    var toyear=new Date(timesheet[i].dateVolunteered).getFullYear();
			    var d=todate+'/'+tomonth+'/'+toyear;
				if(timesheet[i].mission.mission_type=="TIME"){
					data1+=`<tr>
								<td>`+timesheet[i].mission.title+`</td>
								<td>`+d+`</td>
								<td>`+timesheet[i].time[0]+`</td>
								<td>`+timesheet[i].time[1]+`</td>
								<td><button onclick='editTimeTimesheet(`+timesheet[i].timesheetId+`,`+timesheet[i].mission.mission_id+`,`+timesheet[i].dateVolunteered+`,`+timesheet[i].time[0]+`,`+timesheet[i].time[1]+`,\``+timesheet[i].notes+`\`)'>
										<img src="images/editing.png" alt="" data-bs-toggle="modal"
											data-bs-target="#exampleModal1">
									</button></td>
								<td><button onclick="deleteTimeTimesheet(`+timesheet[i].timesheetId+`)">
										<img src="images/delete.png" alt="">
									</button></td>
							</tr>`;
				}
				else{
					data2+= `<tr>
								<td>`+timesheet[i].mission.title+`</td>
								<td>`+d+`</td>
								<td>`+timesheet[i].action+`</td>
								<td><button onclick='editGoalTimesheet(`+timesheet[i].timesheetId+`,`+timesheet[i].mission.mission_id+`,`+timesheet[i].action+`,`+timesheet[i].dateVolunteered+`,\``+timesheet[i].notes+`\`)'>
										<img src="images/editing.png" alt="" data-bs-toggle="modal"
											data-bs-target="#exampleModal2  ">
									</button></td>
								<td><button  onclick="deleteTimeTimesheet(`+timesheet[i].timesheetId+`)">
										<img src="images/delete.png" alt="">
									</button></td>
							</tr>`;
				}
				
			}
			$(".timeBased").html(data1);
			$(".goalBased").html(data2);
		}
		function editTimeTimesheet(sheetid,mission_id,datee,hour,minute,message){
			newTimesheet();
			timesheetid=sheetid;
			timedate= new Date(datee);
			$('.datetime').get(0).valueAsDate=timedate;
			date=datee;
			$('.missionSelectTime').val(mission_id);
			CheckedMission=$('.missionSelectTime').val();
			$('.hours').val(hour);
			hours = $('.hours').val();
			$('.minutes').val(minute);
			minutes = $('.minutes').val();
			$('.messagetime').val(message);
			message = $('.messagetime').val();
		}
		function editGoalTimesheet(sheetid,mission_id,action,datee,message){
			newTimesheet();
			timesheetid=sheetid;
			$('.missionSelectGoal').val(mission_id);
			CheckedMission=$('.missionSelectGoal').val();
			timedate= new Date(datee);
			date=datee;
	    	$('.dategoal').get(0).valueAsDate=timedate;
			date=$('.dategoal').val();
			$('.action').val(action);
			action = $('.action').val();
			$('.messagegoal').val(message);
			message = $('.messagegoal').val();
		}
		function loadApprovedMissionsTimebased() {
			$.ajax({
				url : "loadApprovedMissionsTimebased",
				dataType : 'json',
				data : {'user_id' : user_id},
				success : function(response) {
					approvedMission = response;
					setMissionsTimeBased(approvedMission);
				}
			});
		}
		function loadApprovedMissionsGoalbased() {
			$.ajax({
				url : "loadApprovedMissionsGoalbased",
				dataType : 'json',
				data : {'user_id' : user_id},
				success : function(response) {
					approvedMission = response;
					setMissionsGoalBased(approvedMission);
				}
			});
		}
		function setMissionsGoalBased(mission) {
			var data = "";
			for ( var i in mission) {
				data += '<option value="'+mission[i].mission.mission_id+'"> '
						+ mission[i].mission.title + '</option>';
			}
			$(".missionSelectGoal").append(data);
		}
		function setMissionsTimeBased(mission) {
			var data = "";
			for ( var i in mission) {
				data += '<option value="'+mission[i].mission.mission_id+'"> '
						+ mission[i].mission.title + '</option>';
			}
			$(".missionSelectTime").append(data);
		}
	</script>


	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
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
</body>

</html>