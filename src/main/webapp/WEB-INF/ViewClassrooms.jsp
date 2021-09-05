<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/table.css">
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
<div class="container">
    <h2>Batches</h2>
    <div class="Message">
        <div>${success}${error}</div>
    </div>
    <table>
        <thead Class = "table-header">
        <tr>
            <th><span>Classroom ID</span></th>
            <th><span>Floor Number</span></th>
            <th><span>Number of Seats</span></th>
            <th><span>Update</span></th>
            <th><span>Delete</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="classroom" items="${classrooms}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-2" style="width: 25%">${classroom.classroomID}</td>
                <td Class="col col-3" style="width: 25%">${classroom.floorNum}</td>
                <td Class="col col-4" style="width: 25%">${classroom.numOfSeats}</td>
                <td><button><a href="${pageContext.request.contextPath}/updateClassroom/${classroom.classroomID}">Update</a></button></td>
                <td><button type="button" onclick="myFunction()"><a href="${pageContext.request.contextPath}/deleteClassroom/${classroom.classroomID}">Delete</a></button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script>
    function myFunction() {
        confirm("Are you sure you want to delete this Classroom?");
    }
</script>
</body>
</html>
