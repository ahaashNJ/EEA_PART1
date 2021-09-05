<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/3/2021
  Time: 5:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/table.css">
    <title>View Modules</title>

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
<div class="container">
    <h2>Modules</h2>

    <table>
        <thead Class = "table-header">
        <tr>
            <th><span>Module ID</span></th>
            <th><span>Module Name</span></th>
            <th><span>Batch Name</span></th>
            <th>Lecturer</th>
            <th><span>Delete</span></th>
            <th><span>Update</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="module" items="${module}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-1" style="width: 25%">${module.moduleID}</td>
                <td Class="col col-2" style="width: 25%">${module.moduleName}</td>
                <td Class="col col-2" style="width: 25%">
                    <c:forEach items="${module.batchList}" var="batch">
                        ${batch.batchName}
                    </c:forEach>
                </td>
                <td Class="col col-2" style="...">${module.lecturerEmail.firstName} ${module.lecturerEmail.lastName}</td>
                <td><button type="button" onclick="myFunction()"><a href="${pageContext.request.contextPath}/deleteModule/${module.moduleID}">Delete</a></button></td>
                <td><button type="button"><a href="${pageContext.request.contextPath}/updateModule/${module.moduleID}">Update</a></button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script>
    function myFunction() {
        confirm("Are you sure you want to delete this module?");
    }
</script>
</body>
</html>
