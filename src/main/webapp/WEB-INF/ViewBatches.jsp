<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/3/2021
  Time: 5:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/table.css">
    <title>View Batch</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/createBatch">Add Batches</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="#">View Batches</a>
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
    <form:form action="${pageContext.request.contextPath}/SearchBatchName" method="GET">
        <div class="search bar">
            <input type="text" name ="searchItem" placeholder="Search..">
        </div>
        <button type="submit">Search</button>
    </form:form>

    <table>
        <thead Class = "table-header">
        <tr>
            <th><span>Batch Name</span></th>
            <th><span>Commencing Date</span></th>
            <th><span>Concluding Date</span></th>
            <th><span>Update</span></th>
            <th><span>Delete</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="batch" items="${batch}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-2" style="width: 25%">${batch.batchName}</td>
                <td Class="col col-3" style="width: 25%"><fmt:formatDate value="${batch.startDate}" pattern="yyyy-MM-dd" /></td>
                <td Class="col col-4" style="width: 25%"><fmt:formatDate value="${batch.endDate}" pattern="yyyy-MM-dd" /></td>
                <td><button><a href="${pageContext.request.contextPath}/updateBatch/${batch.batchId}">Update</a></button></td>
                <td><button type="button" onclick="myFunction()"><a href="${pageContext.request.contextPath}/deleteBatch/${batch.batchId}">Delete</a></button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <div class="Message">
        <div>${success}${error}</div>
    </div>
</div>
<script>
    function myFunction() {
        confirm("Are you sure you want to delete this batch?");
    }
</script>
</body>
</html>
