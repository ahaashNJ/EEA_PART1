<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/3/2021
  Time: 5:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/AdminHome.css">
    <title>Admin Home</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item"href="${pageContext.request.contextPath}/ViewTodayTimetable/">Today Lectures</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item"href="${pageContext.request.contextPath}/getAdminAccount/">My Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/logout">Sign Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</head>
<body>
<section class="wrapper">
    <div class="container-fostrap">
        <div>
            <h1 class="heading">
                ADMIN DASHBOARD
            </h1>
        </div>
        <div class="content">
                <div class="row">
                    <div class="col-xs-12 col-md-2">
                        <div class="card" style="margin-left: 40px">
                            <a class="img-card">
                                <img src="https://tophat.com/wp-content/uploads/BLOG_how-to-motivate-students.jpg" />
                            </a>
                            <div class="card-content">
                                <h4 class="card-title">User Handler</h4>
                            </div>
                            <div class="card-read-more">
                                <a href="${pageContext.request.contextPath}/createUser" class="btn btn-link btn-block">Add Users</a>
                            </div>
                            <div class="card-read-more">
                                <a href="ViewUsers" class="btn btn-link btn-block">View All Users</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-2">
                        <div class="card" style="margin-left: 70px">
                            <a class="img-card">
                                <img src="https://i.cbc.ca/1.5551862.1591358948!/cumulusImage/httpImage/graduation.jpg" />
                            </a>
                            <div class="card-content">
                                <h4 class="card-title">Batch Handler</h4>
                            </div>
                            <div class="card-read-more">
                                <a href="${pageContext.request.contextPath}/createBatch" class="btn btn-link btn-block">Create Batch</a>
                            </div>
                            <div class="card-read-more">
                                <a href="ViewBatches" class="btn btn-link btn-block">View All Batches</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-2">
                        <div class="card" style="margin-left: 100px">
                            <a class="img-card">
                                <img src="https://images.shiksha.com/mediadata/images/articles/1591256045php3DZNwb.jpeg"/>
                            </a>
                            <div class="card-content">
                                <h4 class="card-title">Module Handler</h4>
                            </div>
                            <div class="card-read-more">
                                <a href="${pageContext.request.contextPath}/createModule" class="btn btn-link btn-block">Create Module</a>
                            </div>
                            <div class="card-read-more">
                                <a href="ViewModules" class="btn btn-link btn-block">View All Modules</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-2">
                        <div class="card card" style="margin-left: 130px">
                            <a class="img-card">
                                <img src="https://images.unsplash.com/photo-1518607692857-bff9babd9d40?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=967&q=80"/>
                            </a>
                            <div class="card-content">
                                <h4 class="card-title">Lecture Handler</h4>
                            </div>
                            <div class="card-read-more">
                                <a href="${pageContext.request.contextPath}/ViewBatchesForSchedule" class="btn btn-link btn-block">Schedule Class</a>
                            </div>
                            <div class="card-read-more">
                                <a href="viewTimeTable" class="btn btn-link btn-block">View Timetable</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-2">
                        <div class="card" style="margin-left: 160px">
                            <a class="img-card">
                                <img src="https://www.eschoolnews.com/files/2017/07/classroom.jpg"/>
                            </a>
                            <div class="card-content">
                                <h4 class="card-title">Classroom Handler</h4>
                            </div>
                            <div class="card-read-more">
                                <a href="${pageContext.request.contextPath}/createClassroom" class="btn btn-link btn-block">Add Classroom</a>
                            </div>
                            <div class="card-read-more">
                                <a href="ViewClassrooms" class="btn btn-link btn-block">View All Classrooms</a>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</section>
</body>
</html>
