<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/28/2021
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Inquiry.css">
    <title>Add Classroom</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/createClassroom">Add Classroom</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/ViewClassrooms">View Classrooms</a>
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
<section>
    <div class = "container">
        <div class = "formInfo">
            <div>
                <h2>${ClassroomDetails.classroomId}${UpdateClassroom.classroomId}</h2>
                <ul class = "lines">
                    <li>You cannot update the Classroom ID</li>
                    <li></li>
                </ul>
            </div>
        </div>
        <div class = "requestForm">
            <form:form action="/AdminUpdateClassroom" method="POST" modelAttribute="UpdateClassroom">

                <h3>Update Classroom</h3>

                <div class = "formBox">
                    <form:input path="classroomId" value="${ClassroomDetails.classroomId}" type = "hidden" readonly="true" />

                    <div class = "inputBox w50">
                        <form:input path="noOfSeats" value="${ClassroomDetails.noOfSeats}" maxlength="5" patter="[0-9]+" type = "text" required="true"/>
                        <span>Number of Seats</span>
                    </div>

                    <div class = "inputBox w50">
                        <form:input path="floor" value="${ClassroomDetails.floor}" type = "text" maxlength="5" patter="[0-9]+" title="Please be advised to only include numbers" required="true"/>
                        <span>Floor Number</span>
                    </div>
                    <div class = "inputBox w100">
                        <input type="submit" value="Update">
                    </div>
                    <div class="Message">
                        <div>${success}${error}</div>
                    </div>
                </div>
            </form:form>
        </div>

    </div>
</section>
</body>
</html>
