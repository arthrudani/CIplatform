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
<title>Share your story</title>
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
<link rel="stylesheet" href="css/ShareYourStory.css">
<script
	src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/home.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>


	<div class="container p-0">


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
		<div class=" container-fluid col borderH2 d-flex ">
			<div class="container d-flex justify-content-around  ">

				<div class="d-flex ">
					<button class="w3-button " onclick="openRightMenu()">
						<img class="rightbutton" src="images/filter.png">
					</button>
				</div>
				<div class="col d-flex justify-content-between">


					<div class="leftHeader d-flex align-items-center">
						<ul
							class="navbar-nav d-flex flex-row justify-content-between align-items-center">
							<li class="nav-item upperButtons blocking"><a
								class="nav-link" href="#">&nbsp;Stories</a></li>
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
						<ul class="navbar-nav rightHeader d-flex align-items-center">
							<img class="rightbutton" src="images/search.png">

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle d-flex align-items-center"
								href="#" id="navbarDropdownMenuLink" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> <input
									type="text" class="userid" id="uidl" name="mid"
									value="${user.user_id}" hidden> <img
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

		<!-- Share your story -->
		<div class=" title1">
			<div>Share your story</div>
		</div>

		<!-- select mission my story title date -->
		<div class="d-flex row missionStoryDate" style="margin-top: 10px;">

			<div class="col">
				<div>Select mission</div>
				<div>
					<select name="Mission" id="mission" class="missionSelect">
						<option value="missionSelect" hidden>Select mission</option>
					</select>
				</div>
			</div>
			<div class="col">
				<div>My story title</div>
				<input type="text" class="form-control storyTitle" name="title"
					id="Storytitle">
			</div>
			<div class="col">
				<div>Date</div>
				
					<input type="date" class="storyDate" id="birthday" name="storydate"
						placeholder="Select Date">
				
			</div>

		</div>

		<!-- My story editor -->
		<div class="title2">
			<div>My story</div>
		</div>
		<div id="editor" class="description" name="storyDetails" class="w-100"></div>

		<!-- Enter video url -->
		<div class="title2">
			<div>Enter video url</div>
				<input type="text" name="videoURL" class="form-control videoURL"
					id="Videourl">
			
		</div>

		<!-- Drag and drop -->
		<div class="title2">
			<div>Enter images here</div>
			<div class="container strUploadBox">
				<fieldset class="d-flex justify-content-center">
					<a href="javascript:void(0)" onclick="$('#pro-image').click()">
						<div class="strUploadImg d-flex align-items-center flex-column">
							<i class="bi bi-plus"></i>
						</div>
						<div class="UploadText">Drag and drop pictures and videos here</div>
					</a> 
					<input type="file" id="pro-image" name="pro-image" style="display: none;" class="form-control storyImages" multiple>
				</fieldset>
				<div class="preview-images-zone" id="preview-images-zone"></div>
			</div>
		</div>

		<!-- save submit cancel  -->
		<div>
			<div class="d-flex justify-content-between"
				style="padding-top: 20px;">
				<div class="strLeft">
					<button class="strCancel" onclick="clearAllData()">cancel
					</button>
				</div>
				<div class="strRight d-flex"></div>
			</div>
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


	</div>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script> 
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
	var files=[];
    var approvedMission=[];
    let CheckedMission="";
    let storyTitle="";
    let storyDate="";
    let description="";
    let videoURL="";
    let storyStatus="";
    var myeditor;
    let timedate;
    let user_id=$('.userid').val();
    
    $(document).ready(function(){
    	
    	ClassicEditor
        .create(document.querySelector('#editor'))
        .then(editor => {
        	myeditor=editor;
        })
        .catch(error => {
        });
    	
    	$('.missionSelect').on('change', function () {
           	CheckedMission = $(this).find("option:selected").val();
           	clearAllDataExceptTitle();
            getDraftDetails(CheckedMission);
            getDraftMedia(CheckedMission);
        });
    	$('.storyTitle').on('change', function () {
    		storyTitle = $('.storyTitle').val();
        });
    	$('.storyDate').on('change', function () {
    		storyDate = $('.storyDate').val();
        });
    	$('.description').on('change', function () {
    		description = $('.description').val();
        });
    	$('.videoURL').on('change', function () {
    		videoURL = $('.videoURL').val();
        });
    	
    	loadApprovedMissions();
    	
	});
    function loadStoryStatus(){
    	let storystatus="";
    	let classOfStatus="";
    	storyStatus="DRAFT";
    	$.ajax({
            url: "loadStoryStatus",
    		dataType: 'json',
            data:{'missionSelect':CheckedMission,
            	  'user_id':user_id},
            type:"POST",
            success: function(response){
            	storystatus=response;
            	
            	if(storystatus=="DRAFT"){
            		classOfStatus+=`<div><button class="strSave" onclick="saveDraft()">
                        save
                    </button></div>
                    <div><button class="strSubmit" onclick="submit()">
                         submit
                    </button></div>
                    <div>
	                    <form action="previewStory" method="POST" name="storiesLoader">
		                    <button class="strSubmit">
		                    <input type="text" class="userid" id="uidl" name="user_id" value="${user.user_id}" hidden>
		                    <input type="text" class="sharedby_user_id" id="uidl" name="sharedby_user_id" value="${user.user_id}" hidden>
		                    <input type="text" class="selectedMission" name="missionSelect" value="0" hidden>
		                         Preview
		                    </button>
	                    </form>
                    </div>`;
            	}
            	else{
            		classOfStatus+=`<button class="strSave" onclick="saveDraft()">
				                        save
				                    </button>`;
            	}
            	$(".strRight").html(classOfStatus);
            	$(".selectedMission").val(CheckedMission);
            }
    	});
    }
    function clearAllDataExceptTitle(){
    	$('.storyTitle').val('');
    	$('.storyDate').val('');
    	$('.description').val('');
    	$('.videoURL').val('');
    	myeditor.setData('');
    }
    function clearAllData(){
    	$(".preview-images-zone").empty();
    	$('.missionSelect').val('');
    	$('.storyTitle').val('');
    	$('.storyDate').val('');
    	$('.description').val('');
    	$('.videoURL').val('');
    	myeditor.setData('');
    }
    function saveDraft(){
    	
    	var formData = new FormData();
    	
    	var totalFiles = files.length;
        for (var i = 0; i < totalFiles; i++) {
            formData.append("files",files[i]);
        }
    	storyStatus="DRAFT";
    	formData.append("title", storyTitle);
    	formData.append("chekedMission", CheckedMission);
    	formData.append("date", new Date(storyDate));
    	formData.append("description", myeditor.getData());
    	formData.append("videoUrl", videoURL);
    	formData.append("user_id", user_id);
    	formData.append("status", storyStatus);

    	$.ajax({
            url: "saveStoryToDraft",
    		dataType: 'json',
            data:formData,
            type:"POST",
            processData: false,
            contentType: false,
            success: function(response){
            	if(response)
            	{
            		swal("Sucsess!", "Story shared successfully!", "success");
                	clearAllData();
                	loadStoryStatus();
            	}
            	else{
            		swal("Error!", "success");
            	}
            }
    	});
    }
    function submit(){
    	storyStatus="PENDING";
    	$.ajax({
            url: "submitStory",
    		dataType: 'json',
            data:{'missionSelect':CheckedMission,
            	  'user_id':user_id},
            type:"POST",
           
            success: function(response){
            	
            	if(response)
            	{
                	clearAllData();
            	}
            	loadStoryStatus();
            }
    	});
    }
    
    function getDraftMedia(CheckedMission){
    	$.ajax({
            url: "loadDraftMedia",
    		dataType: 'json',
            data:{'user_id': user_id,
            	  'mission_id':CheckedMission},
            success: function(response){
            	if(response==null){
            		clearAllDataExceptTitle();
            	}
            	loadStoryStatus();
            	setDraftMedia(response);
            }
       	});
    }
    function setDraftMedia(draftedMedia){
    	$(".preview-images-zone").empty();
    	for(i in draftedMedia){
    		if(draftedMedia[i].type=="Image"){
    			var html =  '<div class="preview-image preview-show-' + i + '">' +
			                '<div class="image-cancel" data-no="' + i + '">x</div>' +
			                '<div class="image-zone"><img id="pro-img-' + i + '" src="' + draftedMedia[i].path + '"></div>' +
			                '<div class="tools-edit-image"><a href="javascript:void(0)" data-no="' + i + '" class="btn btn-light btn-edit-image">edit</a></div>' +
			                '</div>';
    			$(".preview-images-zone").append(html);
    		}
    		else{
    			$('.videoURL').val(draftedMedia[i].path);
    		}
    	}
    }
    function getDraftDetails(CheckedMission){
    	$.ajax({
            url: "loadDraft",
    		dataType: 'json',
            data:{'user_id': user_id,
            	  'mission_id':CheckedMission},
            success: function(response){
            	if(response==null){
            		clearAllDataExceptTitle();
            	}
            	loadStoryStatus();
            	setDraftStory(response);
            }
       	});
    }
    
    
    function setDraftStory(draftedStory){
    	timedate= new Date(draftedStory.created_at);
    	$('.storyDate').get(0).valueAsDate=timedate;
    	myeditor.setData(draftedStory.description);
    	$('.storyTitle').val(draftedStory.title);
    	storyTitle = $('.storyTitle').val();
    	$('.description').val(draftedStory.decription);
    	description = $('.description').val();
    	loadStoryStatus();
    }
    
    function loadApprovedMissions(){
    	$.ajax({
            url: "loadApprovedMissions",
    		dataType: 'json',
            data:{'user_id': user_id},
            success: function(response){
            	approvedMission=response;
            	setMissions(approvedMission);
            }
       	});
    }
    function setMissions(mission){
    	var data="";
    	for(var i in mission){
    		data+='<option value="'+mission[i].mission.mission_id+'"> '+mission[i].mission.title+'</option>';
    	}
    	$(".missionSelect").append(data);
    }
    
    
        
    </script>
</body>

</html>