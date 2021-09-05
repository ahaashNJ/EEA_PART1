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
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/table.css">
    <title>Admin View Timetable</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/ViewBatchesForSchedule">Schedule Class</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/viewTimeTable">View Timetable</a>
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
    <h2>Timetable</h2>

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
        <c:forEach var="timetable" items="${timetable}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-2" style="width: 25%">${timetable.module.moduleName}</td>
                <td Class="col col-2" style="width: 25%">
                    <c:forEach items="${timetable.batchList}" var="batch">
                    ${batch.batchName}
                    </c:forEach></td>
                <td Class="col col-4" style="width: 25%">${timetable.module.lecturerEmail.firstName} ${timetable.module.lecturerEmail.lastName}</td>
                <td Class="col col-3" style="width: 25%"><fmt:formatDate value="${timetable.date}" pattern="yyyy-MM-dd" /></td>
                <td Class="col col-4" style="width: 25%">${timetable.startTime}</td>
                <td Class="col col-4" style="width: 25%">${timetable.endTime}</td>
                <td Class="col col-2" style="width: 25%">${timetable.classroom.classroomID}</td>
                <td><button type="button"><a href="${pageContext.request.contextPath}/RescheduleClass/${timetable.timetableId}">Update</a></button></td>
                <td><button onclick="myFunction()"><a href="${pageContext.request.contextPath}/deleteLecture/${timetable.timetableId}">Delete</a></button></td>
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
