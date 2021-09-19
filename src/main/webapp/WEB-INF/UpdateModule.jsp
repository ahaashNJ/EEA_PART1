<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/9/2021
  Time: 12:44 PM
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
    <title>Update Module</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/createModule">Add Modules</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/ViewModules">View Modules</a>
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
                <div class="smallBox">${ModuleDetails.moduleName}${UpdateModule.moduleName}</div>
                <div class="smallerBox">${ModuleDetails.lecturerEmail.firstName} ${ModuleDetails.lecturerEmail.lastName}</div>
                <div class="smallerBox" style="font-size: medium">${UpdateModule.lecturer}</div>
            </div>
        </div>
        <div class = "requestForm">


                <h3>Update Module</h3>
            <form:form action="/AdminUpdateModule" method="POST" modelAttribute="UpdateModule">
                <div class = "formBox">
                    <form:input path="moduleId" value="${ModuleDetails.moduleID}" type = "hidden" readonly="true"/>
                    <div class = "inputBox w50">
                        <form:input path="moduleName" value="${ModuleDetails.moduleName}" type = "text" maxlength="100"/>
                        <span>Module Name</span>
                    </div>

                    <div class="selectBox w50 multi-select">
                    <label>Batch/Batches</label>
                        <form:select multiple="true" path="batchList" type="text" style="border-color: black"
                                     required="true">
                            <c:forEach var="listBatch" items="${listBatch}" varStatus="item">
                                <form:option value="${listBatch.batchId}">
                                    ${listBatch.batchName}
                                </form:option>
                            </c:forEach>
                        </form:select>.
                    </div>

                    <div class="selectBox w50 single-select">
                    <label>Lecturer</label>
                    <div class = "inputBox w50">
                        <form:select path="lecturer" type="text" style="border-color: black" cssClass="form-control"
                                     required="true">
                            <c:forEach var="listLecturer" items="${listLecturer}" varStatus="item">
                                <form:option value="${listLecturer.email}">
                                    ${listLecturer.firstName} ${listLecturer.lastName}
                                </form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    </div>

                    <div class = "inputBox w100">
                        <input type="submit" value="Update">
                    </div>
                </div>
            </form:form>
        </div>

    </div>
</section>
</body>
</html>
