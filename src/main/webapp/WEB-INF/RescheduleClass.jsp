<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/9/2021
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
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
    <title>Reschedule Class</title>

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
<section>
    <div class = "container">
        <div class = "formInfo">
            <div>
                <div class="smallBox">${TimetableDetails.module.moduleName}${RescheduleClass.module.moduleName}</div>
                <div class="smallerBox">${TimetableDetails.date}${RescheduleClass.timetableDate}</div>
                <div class="smallerBox">${TimetableDetails.startTime}${RescheduleClass.startTime} - ${TimetableDetails.endTime}${RescheduleClass.endTime}</div>
                <ul class = "lines">
                    <li>Fill out all the fields</li>
                    <li>Include 4 hours per week for each module</li>
                </ul>
            </div>
        </div>
        <div class = "requestForm">
            <h3>Reschedule Lecture</h3>
            <form:form action="/AdminReschedule" method="POST" modelAttribute="RescheduleClass">
                <div class = "formBox">
                    <form:input path="timetableId" value="${TimetableDetails.timetableId}" type = "hidden"/>
                    <form:input path="module" value="${TimetableDetails.module.moduleID}" type = "hidden"/>

                    <div class="selectBox w50">
                        <label>Batch/Batches</label>
                        <form:select path="batchList" type="text" style="border-color: black" cssClass="form-control"
                                     required="true">
                            <c:forEach var="listBatch" items="${TimetableDetails.batchList}" varStatus="item">
                                <form:option value="${listBatch.batchId}">
                                    ${listBatch.batchName}
                                </form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class = "inputBox w50">
                        <form:input path="timetableDate" type = "date" required="true"/>
                        <span>Date</span>
                    </div>
                    <div class = "inputBox w50">
                        <form:input path="startTime" type = "time" required="true"/>
                        <span>Start Time</span>
                    </div>
                    <div class = "inputBox w50">
                        <form:input path="endTime" type = "time" required="true"/>
                        <span>End Time</span>
                    </div>
                    <div class = "inputBox w50">
                        <form:select path="classroom" type="text" style="border-color: black" cssClass="form-control" required="true">
                            <c:forEach var="listClassroom" items="${listClassroom}" varStatus="item">
                                <form:option value="${listClassroom.classroomId}">
                                    ${listClassroom.classroomId}
                                </form:option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class = "inputBox w100">
                        <input type="submit" value="Reschedule">
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
