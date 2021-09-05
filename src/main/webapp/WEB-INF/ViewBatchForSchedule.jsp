<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/25/2021
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/table.css">
    <title>View For Schedule</title>

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
    <h2>Select to schedule</h2>

    <table>
        <thead Class = "table-header">
        <tr>
            <th><span>Module Name</span></th>
            <th><span>Batch Name</span></th>
            <th><span>Lecturer</span></th>
            <th><span>Schedule</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="module" items="${module}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-2" style="width: 25%">${module.moduleName}</td>
                <td Class="col col-2" style="width: 25%">
                    <c:forEach items="${module.batchList}" var="batch">
                        ${batch.batchName}
                    </c:forEach>
                </td>
                <td Class="col col-2" style="...">${module.lecturerEmail.firstName} ${module.lecturerEmail.lastName}</td>
                <td><button type="button"><a href="${pageContext.request.contextPath}/ScheduleClass/${module.moduleID}">Schedule</a></button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
