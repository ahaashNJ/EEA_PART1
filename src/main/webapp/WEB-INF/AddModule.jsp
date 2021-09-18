<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/3/2021
  Time: 4:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Inquiry.css">
    <title>Add Module</title>

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
</head>
<body>
<section>
    <div class="container">
        <div class="formInfo">
            <div>
                <h2>Guidelines</h2>
                <ul class="lines">
                    <li>Fill out all the fields</li>
                    <li>Select the initial lecturer</li>
                    <li>Can select multiple batches</li>
                </ul>
            </div>
        </div>
        <div class="requestForm">
            <h3>Add Module</h3>
            <form:form action="${pageContext.request.contextPath}/AddModule" method="POST" modelAttribute="AddModules">
                <div class="formBox">
                    <div class="inputBox w50">
                        <form:input path="moduleName" type="text" required="true" maxlength="50"/>
                        <span>Module Name</span>
                    </div>

                    <div class="selectBox w50 multi-select">
                        <label>Batch/Batches</label>
                        <form:select path="batchList" type="text" style="border-color: black" cssClass="form-control"
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
                        <form:select path="lecturer" type="text" style="border-color: black" cssClass="form-control"
                                     required="true">
                            <c:forEach var="listLecturer" items="${listLecturer}" varStatus="item">
                                <form:option value="${listLecturer.email}">
                                    ${listLecturer.firstName} ${listLecturer.lastName}
                                </form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="inputBox w100">
                        <input type="submit" value="Create">
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
