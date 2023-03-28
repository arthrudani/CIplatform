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
    <title>Mission Page</title>

    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/MissionView.css">
    <link rel="stylesheet" href="CSS/MissionView1.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.1.0/mdb.min.css" rel="stylesheet" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css"
        integrity="sha512-wR4oNhLBHf7smjy0K4oqzdWumd+r5/+6QO/vDda76MW5iug4PT7v86FoEkySIJft3XA0Ae6axhIvHrqwm793Nw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.css"
        integrity="sha512-6lLUdeQ5uheMFbWm3CP271l14RsX1xtx+J5x2yeIDkkiBpeVTNhTqijME7GgRKKi6hCqovwCoBTlRBEC20M8Mg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
        integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />






</head>

<body>
    <div class="container-fluid p-0">

        <!-- sidebar starts here -->
        <!-- by default sidebar is hidden -->

        <div class="sidebar" id="sidebar">

            <!-- image for closing the sidebar -->
            <div class="cross" id="cross" style="position:absolute; top:15px; right: 10px;">
                <img src="images/cancel1.png" alt="" onclick="sidebarreveal()">
            </div>

            <!-- items that will be displayed inside the bar-->
            <div class="sidebar-content mt-5">
                <button class="btn stories">
                    <a class="text-dark" href="/stories-landing.html" target="_self" style="text-decoration: none;">Stories</a>
                </button>

                <div class="accordion " id="accordionExample">
                    <div class="accordion-item collapsed border-none">
                        <div class="accordion-header" id="headingOne">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Policy
                            </button>
                        </div>
                        <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne"
                            data-bs-parent="#accordionExample">
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

                    <img src="images/list.png" alt="hamberger" class="hambergericon" onclick="sidebarreveal()"
                        style="display: none; width: 2.5rem; height: 1.5rem; padding-right:15px;">
                    <img src="images/logo.png" alt="optimylogo">


                    <button class="btn common-hide" style="box-shadow: none;"><a href=""
                            style="text-decoration: none; color:rgba(0, 0, 0, 0.66);">Stories</a></button>

                    <div class="dropdown common-hide">
                        <a class="btn dropdown-toggle" href="#" style="box-shadow: none;" role="button"
                            id="dropdownMenuLink" data-mdb-toggle="dropdown" aria-expanded="false">
                            policy
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="#">Volunteering</a></li>
                            <li><a class="dropdown-item" href="#">Sponsors</a></li>
                        </ul>
                    </div>


                </div>

                <div class="rightside d-flex align-items-center">

                    <button><img src="images/search.png" alt="" class="nav-search btn " id="search1">
                    </button>

                    <button class="btn dropdown d-flex align-items-center  userprofile" type="button"
                        id="dropdownMenuButton" data-mdb-toggle="dropdown" aria-expanded="false"
                        style=" box-shadow: none; text-transform: capitalize; width: 12rem;">

                        <img src="images/user-img.png" alt="" class="userimage">
                        <span class="username">Evan Donohue</span>
                        <img src="images/drop-down.png" alt="" class="user-image-downarrow">
                    </button>

                    <ul class="dropdown-menu user" aria-labelledby="dropdownMenuLink">
                        <li><a class="dropdown-item" href="#">Dashboard</a></li>
                        <li><a class="dropdown-item" href="#">My Account</a></li>
                        <li><a class="dropdown-item" href="#">Help Center</a></li>
                        <li><a class="dropdown-item" href="#">LogOut</a></li>
                    </ul>
                </div>
            </div>

            <div class="main-content mb-6">

                <div class="row mx-4 gx-5">

                    <div class="col-xl-6 col-lg-12 col-12 col-md-12 px-1 cars">
                        <div id="wrap">
                            <ul id="slider">
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
                            <ul id="thumbnail_slider">
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

                        <!-- mission details here -->

                        <p class="fs-1">CSR Initiative stands for coffee and farmer equity</p>

                        <p class="fs-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Numquam necessitatibus, ab harum recusandae tempora sint porro inventore nihil nemo aliquid quisquam?</p>

                        <div class="deadline d-flex align-items-center justify-content-between flex-wrap">

                            <div class=" px-3 seat-deadline d-flex align-items-center justify-content-between">
                                <img src="images/Seats-left.png" alt="" class="px-3">
                                <div>10 <p>Seats left</p></div>
                            </div>

                            <div class=" px-3 seat-deadline d-flex align-items-center justify-content-between">
                                <img src="images/mission.png" alt="">
                                <div class="ms-3">
                                    <div class="progress" style="height: 10px;border-radius: 10px;width: 10rem;">
                                        <div class="progress-bar bg-warning" role="progressbar" style="width: 75%;height: 10px;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" ></div>
                                      </div>
                                    <p class="remove-margin">Deadline</p>
                                </div>
                            </div>

                            <p class="fromto">Plant 1000 Trees</p>

                        </div>

                        <div class="d-flex recommendation justify-content-between flex-wrap" style="border-bottom:1px solid gray; padding-top: 20px; padding-bottom: 30px;">

                            <div role="button" class="d-flex recommend-items align-items-center justify-content-center twobutton" style="width: 40%;">
                                <img src="images/heart1.png" alt="" style="padding: 7px;">
                                Add To Favourite
                            </div>
                            <div role="button" class="d-flex recommend-items align-items-center justify-content-center twobutton" style="width: 40%;">
                                <img src="images/add1.png" alt="" style="padding: 7px;">
                                Recommend To Co-Worker
                            </div>

                            <div class="rating">
                                <img role="button" src="images/star-empty.png" alt="">
                                <img role="button" src="images/star-empty.png" alt="">
                                <img role="button" src="images/star-empty.png" alt="">
                                <img role="button" src="images/star-empty.png" alt="">
                                <img role="button" src="images/star-empty.png" alt="">
                            </div>

                        </div>

                        <div class="locations d-flex justify-content-between flex-wrap">
                            <div class="common-loc">
                                <img src="images/pin1.png" alt="">
                                <p style="margin-bottom: 0; margin-top: 20px;">city</p>
                                <p style="margin-bottom: 0;"><strong>London</strong></p>
                            </div>
                            <div class="common-loc">
                                <img src="images/web.png" alt="">
                                <p style="margin-bottom: 0; margin-top: 20px;">Theme</p>
                                <p style="margin-bottom: 0;"><strong>Environment</strong></p>
                            </div>
                            <div class="common-loc">
                                <img src="images/calender.png" alt="">
                                <p style="margin-bottom: 0; margin-top: 20px;">Date</p>
                                <p style="margin-bottom: 0;"><strong>Ongoing</strong></p>
                            </div>
                            <div class="common-loc">
                                <img src="images/organization.png" alt="">
                                <p style="margin-bottom: 0; margin-top: 20px;">Organisation</p>
                                <p style="margin-bottom: 0;"><strong>CSE Network</strong></p>
                            </div>
                        </div>

                        <button class="Apply__Mission">Apply&nbsp;&nbsp;&nbsp;&nbsp;<img
                            src="images/right-arrow.png" alt=""></button>
                    </div>
                </div>

                <div class="row mx-4">

                    <div class="col-xl-8 px-5 py-4">
                        <nav>
                            <div class="nav nav-tabs" id="nav-tab" role="tablist" style="border-bottom: 1px solid rgba(128, 128, 128, 0.62);">
                              <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Mission</button>
                              <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Organizations</button>
                              <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">Comments</button>
                            </div>
                          </nav>
                          <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" style="text-align: justify;" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                <br>
                                <h3>Introduction</h3>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis accusantium sit ullam inventore explicabo a aliquid totam error quasi atque at quo cum id eveniet, sint, illum voluptatem reprehenderit iure animi? Pariatur expedita culpa neque adipisci cumque debitis. Aliquid, praesentium. Laudantium aut consequatur ad at veritatis debitis magni ea harum?L <br><br> orem ipsum dolor sit amet consectetur adipisicing elit. Sit error ea corrupti, placeat nisi obcaecati odit in quisquam repudiandae, possimus pariatur quam cum omnis nesciunt veritatis aliquam? Maxime corrupti, quam quia nemo, sapiente fugiat vitae labore pariatur itaque dicta totam eligendi possimus reprehenderit quasi provident assumenda amet odio repellendus quo. <br><br>

                                <h3>Challenge</h3>
                                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Doloremque, libero sapiente! Alias commodi eveniet expedita culpa atque officia, incidunt quisquam, exercitationem nihil tempore voluptatem veritatis sed quae consectetur rem mollitia eum in cum illo obcaecati nisi illum esse dolorem sint. Molestias rem mollitia, ab quibusdam totam iusto sed quis soluta. <br>

                                <h3>Documents</h3>
                                <div class="d-flex docs" style="border: 1px solid gray; border-radius: 50px;width: 25%;">
                                    <img src="images/pdf.png" alt="" class="mx-2">
                                     ipsum dolor.
                                </div>
                            </div>


                            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                <br>
                                <h3>Introduction</h3>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis accusantium sit ullam inventore explicabo a aliquid totam error quasi atque at quo cum id eveniet, sint, illum voluptatem reprehenderit iure animi? Pariatur expedita culpa neque adipisci cumque debitis. Aliquid, praesentium. Laudantium aut consequatur ad at veritatis debitis magni ea harum?L <br><br> orem ipsum dolor sit amet consectetur adipisicing elit. Sit error ea corrupti, placeat nisi obcaecati odit in quisquam repudiandae, possimus pariatur quam cum omnis nesciunt veritatis aliquam? Maxime corrupti, quam quia nemo, sapiente fugiat vitae labore pariatur itaque dicta totam eligendi possimus reprehenderit quasi provident assumenda amet odio repellendus quo. <br><br>

                                <h3>Challenge</h3>
                                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Doloremque, libero sapiente! Alias commodi eveniet expedita culpa atque officia, incidunt quisquam, exercitationem nihil tempore voluptatem veritatis sed quae consectetur rem mollitia eum in cum illo obcaecati nisi illum esse dolorem sint. Molestias rem mollitia, ab quibusdam totam iusto sed quis soluta.
                            </div>


                            <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                <br>
                                <textarea name="Comment" id="comm" class="w-100" placeholder="Comment Here..." style="border-radius: 5px;"></textarea>
                                <button class="btn btn-outline-warning">Post Comment</button>

                                <div class="prev-comments mt-2" style="background-color: rgba(128, 128, 128, 0.503); padding: 5px; height: 23rem; overflow-y: scroll;">
                                    <div class="usercomment d-flex mt-2 align-items-center" style="background-color: white; border-radius: 10px; padding: 5px;">
                                        <img src="images/volunteer1.png" alt="" style="border-radius: 50%; width: 3rem; padding-right: 5px;">
                                        <div>
                                            Andrew Tate
                                            <p>Monday, October 21, 2019, 4:00 am</p>
                                            <p>This is a comment</p>
                                        </div>
                                    </div>

                                    <div class="usercomment d-flex mt-2 align-items-center" style="background-color: white; border-radius: 10px; padding: 5px;">
                                        <img src="images/volunteer1.png" alt="" style="border-radius: 50%; width: 3rem; padding-right: 5px;">
                                        <div>
                                            Andrew Tate
                                            <p>Monday, October 21, 2019, 4:00 am</p>
                                            <p>This is a comment</p>
                                        </div>
                                    </div>

                                    <div class="usercomment d-flex mt-2 align-items-center" style="background-color: white; border-radius: 10px; padding: 5px;">
                                        <img src="images/volunteer1.png" alt="" style="border-radius: 50%; width: 3rem; padding-right: 5px;">
                                        <div>
                                            Andrew Tate
                                            <p>Monday, October 21, 2019, 4:00 am</p>
                                            <p>This is a comment</p>
                                        </div>
                                    </div>

                                    <div class="usercomment d-flex mt-2 align-items-center" style="background-color: white; border-radius: 10px; padding: 5px;">
                                        <img src="images/volunteer1.png" alt="" style="border-radius: 50%; width: 3rem; padding-right: 5px;">
                                        <div>
                                            Andrew Tate
                                            <p>Monday, October 21, 2019, 4:00 am</p>
                                            <p>This is a comment</p>
                                        </div>
                                    </div>
                                   
                                </div>
                            </div>

                          </div>
                    </div>
                    <div class="col-xl-4 pt-5">

                        <div class="Information">
                            <div>
                                <h3>Information</h3>
                            </div>
                            <div class="d-flex flex-wrap border-bottom py-1">
                                <p style="padding-right:50px">Skills</p>
                                <p>Botany</p>
                            </div>
                            <div class="d-flex flex-wrap border-bottom py-2">
                                <p style="padding-right:50px">Days</p>
                                <p>daily</p>
                            </div>
                            <div class="d-flex flex-wrap py-2">
                                <p style="padding-right:40px">Rating</p>
                                <div>
                                    <img src="images/selected-star.png" alt="">
                                    <img src="images/selected-star.png" alt="">
                                    <img src="images/selected-star.png" alt="">
                                    <img src="images/selected-star.png" alt="">
                                    <img src="images/selected-star.png" alt="">
                                    <img src="images/star.png" alt=""> &nbsp;(by 5 Volunteer)
                                </div>

                            </div>
                        </div>

                        <div class="Information mt-2">
                            <h3 class="border-bottom">Recent Volunteer</h3>

                            <div class="row">
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer1.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Andrew Tate</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer2.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Miley Cirus</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer3.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Drake Ramouray</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer4.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Kate Martin</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer5.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Jhon doe</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer6.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Maggy Robert</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer7.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Mark stein</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer8.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>stacy brooke</p>
                                </div>
                                <div class="col-4 d-flex flex-column align-items-center">
                                    <img src="images/volunteer9.png" alt="" style="border-radius: 50%; width: 50px;">
                                    <p>Hena wright</p>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
                

            </div>

            <!-- Related missionlist starts here` -->
            <div class="related-missions d-flex justify-content-center"
                style="border-top: 2px solid rgba(128, 128, 128, 0.495);">
                <h4 style="padding:2rem 0rem 1rem 0rem;">Related missions</h4>
            </div>

            <div class="row row-cols-1 row-cols-md-3 mission-container g-4 ">
                <div class="col col-md-6 col-xl-4 card-col mb-2 ">
                    <div class="card">
                        <div class="image-container">
                            <img class="w-100" src="images/Grow-Trees-On-the-path-to-environment-sustainability.png"
                                alt="Grow Trees" srcset="">
                            <div class="location d-flex align-items-center text-white">
                                <img src="images/pin.png" alt="" srcset=""> &nbsp;&nbsp;&nbsp;
                                Toronto
                            </div>
                            <div class="Favourite">
                                <img src="images/heart.png" alt="Favourite" srcset="">
                            </div>
                            <div class="Recommend">
                                <img src="images/user.png" alt="Favourite" srcset="">
                            </div>
                            <p class="mission-type">Environment</p>
                        </div>
                        <div class="bottom-content">
                            <div class="mission-content">
                                <p class="mt-4 mb-0 fs-3 titleColor">Grow Trees - On the Path to Environment
                                    sustainibility
                                </p>
                                <p class="descColor"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis
                                    eaque
                                    et
                                    dolorem ducimus, odit debitis ... </p>
                                <div class="mission-name__Dates">
                                    <div class="d-flex justify-content-between align-items-center flex-wrap">
                                        <p class="descColor mb-0">Tree Canada</p>
                                        <div class="d-flex">
                                            <img src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/star.png" alt="">
                                            <img class="ms-1" src="images/star.png" alt="">
                                        </div>
                                    </div>
                                    <p class='fromTo'>From 10/10/2019 until 25/02/2019</p>
                                </div>
                            </div>
                            <div class="info__Apply">
                                <div class="d-flex justify-content-between flex-wrap px-4 seats-deadline">
                                    <div class="d-flex align-items-start">
                                        <img src="images/Seats-left.png" class="mt-2 seats-img" alt="">
                                        <div class="ms-3">
                                            <p class="mb-0 fs-5">100</p>
                                            <p class="mt-0 remove-margin">Seats Left</p>
                                        </div>
                                    </div>
                                    <div class="d-flex align-items-start">
                                        <img src="images/deadline.png" class="" alt="">
                                        <div class="ms-3">
                                            <p class="mb-0 fs-5">29/11/2020</p>
                                            <p class="remove-margin">Deadline</p>
                                        </div>
                                    </div>
                                </div>
                                <hr className='custom-hr m-0' style="margin: 0;" />
                                <button class="Apply__Mission">Apply&nbsp;&nbsp;&nbsp;&nbsp;<img
                                        src="images/right-arrow.png" alt=""></button>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col col-md-6 col-xl-4 card-col mb-2 ">
                    <div class="card h-100">
                        <div class="image-container">
                            <img class="w-100" src="images/Grow-Trees-On-the-path-to-environment-sustainability.png" alt="Grow Trees"
                                srcset="">
                            <div class="location d-flex align-items-center text-white">
                                <img src="images/pin.png" alt="" srcset=""> &nbsp;&nbsp;&nbsp;
                                Toronto
                            </div>
                            <div class="Favourite">
                                <img src="images/heart.png" alt="Favourite" srcset="">
                            </div>
                            <div class="Recommend">
                                <img src="images/user.png" alt="Favourite" srcset="">
                            </div>
                            <p class="mission-type">Animals</p>
                        </div>
                        <div class="bottom-content">
                            <div class="mission-content">
                                <p class="mt-4 mb-0 fs-3 titleColor">Animal Welfare & Save Birds Campaign
                                </p>
                                <p class="descColor"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis
                                    eaque
                                    et
                                    dolorem ducimus, odit debitis ... </p>
                                <div class="mission-name__Dates">
                                    <div class="d-flex justify-content-between align-items-center flex-wrap">
                                        <p class="descColor mb-0">Tree Canada</p>
                                        <div class="d-flex">
                                            <img src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/star.png" alt="">
                                            <img class="ms-1" src="images/star.png" alt="">
                                        </div>
                                    </div>
                                    <p class='fromTo'>From 10/10/2019 until 25/02/2019</p>
                                </div>
                            </div>
                            <div class="info__Apply">
                                <div class="d-flex justify-content-between flex-wrap px-4 seats-deadline">
                                    <div class="d-flex align-items-start">
                                        <img src="images/Seats-left.png" class="mt-2 seats-img" alt="">
                                        <div class="ms-3">
                                            <p class="mb-0 fs-5">10</p>
                                            <p class="mt-0 remove-margin">Seats Left</p>
                                        </div>
                                    </div>
                                    <div class="d-flex align-items-start">
                                        <img src="images/deadline.png" class="" alt="">
                                        <div class="ms-3">
                                            <p class="mb-0 fs-5">09/01/2019</p>
                                            <p class="remove-margin">Deadline</p>
                                        </div>
                                    </div>
                                </div>
                                <hr className='custom-hr m-0' style="margin: 0;" />
                                <button class="Apply__Mission">Apply&nbsp;&nbsp;&nbsp;&nbsp;<img
                                        src="images/right-arrow.png" alt=""></button>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col col-md-6 col-xl-4 card-col mb-2 ">
                    <div class="card">
                        <div class="image-container">
                            <img class="w-100" src="images/CSR-initiative-stands-for-Coffee--and-Farmer-Equity.png"
                                alt="Grow Trees" srcset="">
                            <div class="location d-flex align-items-center text-white">
                                <img src="images/pin.png" alt="" srcset=""> &nbsp;&nbsp;&nbsp;
                                Toronto
                            </div>
                            <div class="Favourite">
                                <img src="images/heart.png" alt="Favourite" srcset="">
                            </div>
                            <div class="Recommend">
                                <img src="images/user.png" alt="Favourite" srcset="">
                            </div>
                            <p class="mission-type">Environment</p>
                        </div>
                        <div class="bottom-content">
                            <div class="mission-content">
                                <p class="mt-4 mb-0 fs-3 titleColor">CSR initiative stands for Coffee and Farmer Equity
                                </p>
                                <p class="descColor"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis
                                    eaque
                                    et
                                    dolorem ducimus, odit debitis ... </p>
                                <div class="mission-name__Dates">
                                    <div class="d-flex justify-content-between align-items-center flex-wrap">
                                        <p class="descColor mb-0">Tree Canada</p>
                                        <div class="d-flex">
                                            <img src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/selected-star.png" alt="">
                                            <img class="ms-1" src="images/star.png" alt="">
                                            <img class="ms-1" src="images/star.png" alt="">
                                        </div>
                                    </div>
                                    <p class='fromTo'>Ongoing opportunity</p>
                                </div>
                            </div>
                            <div class="info__Apply">
                                <div class="d-flex justify-content-between flex-wrap px-4 seats-deadline">
                                    <div class="d-flex align-items-start">
                                        <img src="images/Seats-left.png" class="mt-2 seats-img" alt="">
                                        <div class="ms-3">
                                            <p class="mb-0 fs-5">210</p>
                                            <p class="mt-0 remove-margin">Already Volunteered</p>
                                        </div>
                                    </div>

                                </div>
                                <hr className='custom-hr m-0' style="margin: 0;" />
                                <button class="Apply__Mission">Apply&nbsp;&nbsp;&nbsp;&nbsp;<img
                                        src="images/right-arrow.png" alt=""></button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <!-- mission list ends here -->
            <div class="footer mt-3 d-flex">
                <a href="#" class="px-3  text-black">Privacy Policy</a>
                <a href="#" class="px-2 text-black">Contact Us</a>
            </div>
        </div>



    </div>
</body>

<script src="js/bootstrap.min.js"></script>

<!-- slick-carousel -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
    integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
    integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
    integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
    integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<!-- slick carsousel -->


<script>
    $(function () {
        $("#slider").slick({
            autoplay: true,
            speed: 100,
            arrows: false,
            asNavFor: "#thumbnail_slider"
        });
        $("#thumbnail_slider").slick({
            slidesToShow: 4,
            speed: 100,
            arrows: true,
            focusOnSelect:true,
            asNavFor: "#slider"
        });
    });

</script> 


</html>