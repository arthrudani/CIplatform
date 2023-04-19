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
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;900&display=swap" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Noto Sans' rel='stylesheet'>
    <title>Edit profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="icon" href="" type="images/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="css/EditProfile.css">

</head>

<body>


    <!-- modal for change password -->
    <div class="modal " id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Change password</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body ">
                    <input type="password" name="oldpass" class="form-control my-3" id="oldpass"
                        aria-describedby="emailHelp" placeholder="Enter old password">
                    <input type="password" name="newpass" class="form-control my-3" id="newpass"
                        aria-describedby="emailHelp" placeholder="Enter new password">
                    <input type="password" name="confpass" class="form-control my-3" id="confpass"
                        aria-describedby="emailHelp" placeholder="Confirm new password">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" class="btn changepass" data-bs-dismiss="modal"
                    aria-label="Close">Change password</button>
                </div>
            </div>
        </div>
    </div>

    <!-- modal for add skills -->
    <div class="modal " id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add your skills</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body ">
                    <div class="approveTermsContainer">
                        <div class="newItems">
                            <br />
                            <select multiple="multiple" id='lstBox1'>
                                <option value="Anthropology">Anthropology</option>
                                <option value="Archeology">Archeology</option>
                                <option value="Astronomy">Astronomy</option>
                                <option value="Computer Science">Computer Science</option>
                                <option value="Environmental Science">Environmental Science</option>
                                <option value="History">History</option>
                                <option value="IT">IT</option>
                                <option value="EC">EC</option>
                                <option value="EE">EE</option>

                            </select>
                        </div>
                        <div class="transferBtns">
                            <input type='button' id='btnRight' value='  >  ' />
                            <br /><input type='button' id='btnLeft' value='  <  ' />
                        </div>
                        <div class="approvedItems">
                            <br />
                            <select multiple="multiple" id='lstBox2'>
                            </select>
                        </div>
                    </div>

                </div>
                <div class="modal-footer justify-content-start">
                    <button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" id="saveSkills" class="btn changepass" data-bs-dismiss="modal"
                        aria-label="Close">Save</button>
                </div>
            </div>
        </div>
    </div>

    <!-- modal for contact us -->
    <div class="modal " id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Contact us</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Name*</p>
                    <input type="text" name="cname" class="form-control " id="cname"
                        aria-describedby="emailHelp" placeholder="Enter username">
                    <p>Email address*</p>
                    <input type="email" name="email" class="form-control " id="email"
                        aria-describedby="emailHelp" placeholder="Enter email address">
                    <p>Subject*</p>
                    <input type="text" name="subject" class="form-control " id="subject"
                        aria-describedby="emailHelp" placeholder="Enter your subject">
                    <p>Message*</p>
                    <textarea name="subject" id="message" class="form-control  " aria-describedby="emailHelp" placeholder="Enter your message"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn cancel" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" class="btn changepass" data-bs-dismiss="modal"
                    aria-label="Close">Save</button>
                </div>
            </div>
        </div>
    </div>

    <!-- upper nav side open bar -->
    <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none;" id="rightMenu">
        <button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-large "><img src="images/left.png"></button>

        <div class="dropdown button1">
            <ul class="navbar-nav">
                <li class="nav-item dropdown upperButtons">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                        data-bs-toggle="dropdown" aria-expanded="false">&nbsp;Stories&nbsp;
                        <img src="images/drop-down.png"></a>
                    <ul class="dropdown-menu  posAbsolute" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown upperButtons">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                        data-bs-toggle="dropdown" aria-expanded="false">
                        &nbsp;Policy &nbsp;
                        <img src="images/drop-down.png">
                    </a>
                    <ul class="dropdown-menu  posAbsolute" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
        </div>


    </div>

    <!-- upper nav bar -->
    <div class="container-fluid borderH2 d-flex ">
        <div class="container d-flex justify-content-around  ">

            <div class="d-flex ">

                <button class="w3-button " onclick="openRightMenu()"><img class="rightbutton"
                        src="images/filter.png"></button>
            </div>




            <div class="col d-flex justify-content-around">
                <div class=" d-flex align-items-center">
                    <img src="images/logo.png" class="blocking">
                </div>

                <div class="leftHeader ">
                    <ul class="navbar-nav d-flex flex-row justify-content-between" style="padding-top: 7%;">
                        <li class="nav-item upperButtons blocking">
                            <a class="nav-link" href="#">&nbsp;Stories</a>
                        </li>
                        <li class="nav-item dropdown upperButtons blocking">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                &nbsp;Policy &nbsp;
                                <img src="images/drop-down.png">
                            </a>
                            <ul class="dropdown-menu  posAbsolute" aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

                <div class="d-flex ">
                    <ul class="navbar-nav rightHeader align-items-between">
                        <img class="rightbutton " style="padding-top: 22% !important; padding-right: 10%; "
                            src="images/search.png">

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle d-flex align-items-center" href="#"
                                id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false" style="display: flex !important ;">
                                <img src="images/user-img.png" class="userimage ">
                                <span class="blocking uNameuImage"> Evan Donohue</span>
                                <img src="images/drop-down.png" class="uNameuImage">
                            </a>

                            <ul class="dropdown-menu posAbsolute dropdown-menu-end"
                                aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>


            </div>


        </div>
    </div>

    <!-- edit profile -->
    <div class="container mt-5 ">

        <div class=" d-flex row ">

            <!-- sideimage -->
            <div class=" EPuserimg col-md-3 ">
                <div class="d-flex justify-content-center"><img src="images/user-img.png" alt=""></div>
                <div class="EDchangepass d-flex justify-content-center mt-3">Evan Donohue</div>
                <div class="EDchangepass d-flex justify-content-center mt-2"><a href="#" data-bs-toggle="modal"
                        data-bs-target="#exampleModal1">Change password</a></div>
            </div>


            <!-- rightcontent -->
            <div class="EPbasicInformation col-md-9 ">

                <!-- basic Information -->
                <div class="EPbasicInfo">
                    <p> Basic Information</p>
                </div>
                <div class="form-group ">
                    <div class="d-flex EPnameSurname justify-content-around mt-1 row">
                        <div class="col"><span>Name*</span>
                            <input type="text" name="name" class="form-control" id="name" aria-describedby="emailHelp"
                                placeholder="Enter name">
                        </div>
                        <div class="col"><span>Surname*</span>
                            <input type="text" name="surname" class="form-control" id="surname"
                                aria-describedby="emailHelp" placeholder="Enter surname">
                        </div>
                    </div>
                    <div class="d-flex EPnameSurname justify-content-around mt-1 row">
                        <div class="col"><span>Employee Id</span>
                            <input type="text" name="employeeId" class="form-control" id="employeeID"
                                aria-describedby="emailHelp" placeholder="Enter employee Id">
                        </div>
                        <div class="col"><span>Manager</span>
                            <input type="text" name="manager" class="form-control" id="manager"
                                aria-describedby="emailHelp" placeholder="Enter manager">
                        </div>
                    </div>
                    <div class="d-flex EPnameSurname justify-content-around mt-1 row">
                        <div class="col"><span>Title</span>
                            <input type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp"
                                placeholder="Enter title">
                        </div>
                        <div class="col"><span>Department</span>
                            <input type="text" name="department" class="form-control" id="department"
                                aria-describedby="emailHelp" placeholder="Enter department">
                        </div>
                    </div>
                    <div class="d-flex EPnameSurname justify-content-around mt-1 row">
                        <div class="col"><span>My profile*</span>
                            <div class="EPnameSurname mt-1">
                                <textarea name="skills" id="skills" class="w-100 "
                                    placeholder=" Enter your comments"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex EPnameSurname justify-content-around mt-1 row">
                        <div class="col"><span>My profile*</span>
                            <div class="EPnameSurname mt-1">
                                <textarea name="skills" id="profile" class="w-100 "
                                    placeholder=" Enter your comments"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Address Information -->
                <div class="EPbasicInfo">
                    <p> Address Information</p>
                </div>
                <div class="form-group ">
                    <div class="d-flex EPnameSurname justify-content-around mt-1 row">
                        <div class="col"><span>City*</span>
                            <input type="email" name="city" class="form-control" id="city" aria-describedby="emailHelp"
                                placeholder="Enter name">
                        </div>
                        <div class="col"><span>Country*</span>
                            <div class="dropdown">
                                <button class="btn dropdown-toggle EPddborder col" type="button"
                                    id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="d-flex justify-content-between">
                                        <p>Select your country </p> <img src="images/drop-down.png" alt="">
                                    </span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>

                <!-- personal Information -->
                <div class="EPbasicInfo">
                    <p> Professional Information</p>
                </div>
                <div class="form-group ">
                    <div class="d-flex EPnameSurname justify-content-around mt-1 row">
                        <div class="col"><span>Availability</span>
                            <div class="dropdown">
                                <button class="btn dropdown-toggle EPddborder col" type="button"
                                    id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="d-flex justify-content-between">
                                        <p>Select your availability </p> <img src="images/drop-down.png" alt="">
                                    </span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col"><span>LinkedIn</span>
                            <input type="email" name="linkedINUrl" class="form-control" id="linkedINUrl" aria-describedby="emailHelp"
                                placeholder="Enter LinkedIn url">
                        </div>

                    </div>
                </div>

                <!-- my skill -->
                <div class="EPbasicInfo">
                    <p>My skills</p>
                </div>
                <div class="EPmyskill mt-4">
                    <div class="EPmyskilltextarea">
                        <select multiple="multiple" id="selectedSkills">
                        </select>
                    </div>
                </div>

                <!-- footer button -->
                <div class="EPaddskill mt-3">
                    <button data-bs-toggle="modal" data-bs-target="#exampleModal2" id="addSkillButton">Add
                        skill</button>
                </div>
                <div class="d-flex justify-content-end EPsave mt-3">
                    <button>Save</button>
                </div>

            </div>

        </div>

        <!-- footer -->
        <div class="EPfooterline "></div>
        <div class="EPprivacypolicy d-flex justify-content-start mt-3 gap-3">
            <div class="privacypolicy"><a href="#">Privacy policy</a></div>
            <div class="contactus"><a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal3" id="contactus">
                    Contact us</a></div>
        </div>


    </div>

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

    <script src="js/EditProfile.js"></script>
    <script src="js/home.js"></script>
</body>

</html>