<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/3/2021
  Time: 4:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Inquiry.css">
    <title>Add Batch</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/ViewBatches">Add Batches</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/ViewBatches">View Batches</a>
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
                <h2>Guidelines</h2>
                <ul class = "lines">
                    <li>Fill out all the fields</li>
                    <li>Add extra 3 months for delaying purposes</li>

                </ul>
            </div>
        </div>
        <div class = "requestForm">
            <h3>Create Batch</h3>
            <form:form action="/AdminAddBatch" method="POST" modelAttribute="AddBatches">
            <div class = "formBox">

                <div class = "inputBox w50">
                    <form:input path="batchName" type = "text" required="true" maxlength="20"/>
                    <span>Batch Name</span>
                </div>

                <div class = "inputBox w50">
                    <form:input path="startDate" type = "date" required="true"/>
                    <span>Commencing Date</span>
                </div>
                <div class = "inputBox w50">
                    <form:input path="endDate" type = "date" required="true"/>
                    <span>Concluding Date</span>
                </div>

                <div class = "inputBox w100">
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