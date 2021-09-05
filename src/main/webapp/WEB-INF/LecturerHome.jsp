<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/table.css">
    <title>Lecturer Home</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/LecturerHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item"href="${pageContext.request.contextPath}/getLecturerHome/">My Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item"href="${pageContext.request.contextPath}/LecturerModules/">My Modules</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item"href="${pageContext.request.contextPath}/ViewTodayLecturerLectures/">Today Lectures</a>
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
            <th><span>Reschedule</span></th>
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
                <td Class="col col-4" style="width: 25%">${timetables.module.lecturerEmail.firstName} ${timetables.module.lecturerEmail.firstName}</td>
                <td Class="col col-3" style="width: 25%"><fmt:formatDate value="${timetables.date}" pattern="yyyy-MM-dd" /></td>
                <td Class="col col-4" style="width: 25%">${timetables.startTime}</td>
                <td Class="col col-4" style="width: 25%">${timetables.endTime}</td>
                <td Class="col col-2" style="width: 25%">${timetables.classroom.classroomID}</td>
                <td><button type="button"><a href="${pageContext.request.contextPath}/RescheduleClass/${timetables.timetableId}">Update</a></button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
