<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 4/28/2021
  Time: 5:52 PM
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
    <title>Lectures For Today</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item"href="${pageContext.request.contextPath}/ViewTodayTimetable/">Today Lectures</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item"href="${pageContext.request.contextPath}/ViewTodayTimetable/">My Account</a>
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
    <h2>Lectures For Today</h2>

    <table>
        <thead Class = "table-header">
        <tr>
            <th><span>Module Name</span></th>
            <th><span>Batch Name</span></th>
            <th><span>Lecturer Name</span></th>
            <th><span>Date</span></th>
            <th><span>Start Time</span></th>
            <th><span>End Time</span></th>
            <th><span>Classroom</span></th>
            <th><span>Update</span></th>
            <th><span>Delete</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="timetables" items="${timetables}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-2" style="width: 25%">${timetables.module.moduleName}</td>
                <td Class="col col-2" style="width: 25%">
                    <c:forEach items="${timetables.batchList}" var="batch">
                        ${batch.batchName}
                    </c:forEach></td>
                <td Class="col col-4" style="width: 25%">${timetables.module.lecturerEmail.firstName} ${timetables.module.lecturerEmail.lastName}</td>
                <td Class="col col-3" style="width: 25%"><fmt:formatDate value="${timetables.date}" pattern="yyyy-MM-dd" /></td>
                <td Class="col col-4" style="width: 25%">${timetables.startTime}</td>
                <td Class="col col-4" style="width: 25%">${timetables.endTime}</td>
                <td Class="col col-2" style="width: 25%">${timetables.classroom.classroomID}</td>
                <td><button type="button"><a href="${pageContext.request.contextPath}/RescheduleClass/${timetables.timetableId}">Update</a></button></td>
                <td><button onclick="myFunction()"><a href="${pageContext.request.contextPath}/deleteTimetable/${timetables.timetableId}">Delete</a></button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script>
    function myFunction() {
        confirm("Are you sure you want to delete this lecture?");
    }
</script>
</body>
</html>
