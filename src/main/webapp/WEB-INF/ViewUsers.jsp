<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/3/2021
  Time: 5:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/table.css">
    <title>View Users</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item"href="/AdminHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/createUser">Add User</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="/ViewUsers">View Users</a>
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
    <h2>All Users</h2>

    <div class="searchFunction" style="align-items: center">
        <form:form action="${pageContext.request.contextPath}/SearchUserName" method="GET">
            <div class="searchBar">
                <input type="text" name ="searchName" placeholder="Search..">
            </div>
            <button class="searchButton" type="submit">Search</button>
        </form:form>
    </div>



    <table>
        <thead Class = "table-header">
        <tr>
            <th><span>Email</span></th>
            <th><span>Name</span></th>
            <th><span>Contact Number</span></th>
            <th><span>Type</span></th>
            <th><span>Batch</span></th>
            <th><span>Update</span></th>
            <th><span>Delete</span></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${user}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-1" style="width: 25%">${user.email}</td>
                <td Class="col col-2" style="width: 25%">${user.firstName} ${user.lastName}</td>
                <td Class="col col-2" style="width: 25%">${user.contactNumber}</td>
                <td Class="col col-2" style="width: 25%">${user.userType}</td>
                <td Class="col col-2" style="width: 25%">${user.batchId.batchName}</td>
                <td Class="col col-2" style="width: 25%"><button type="button"><a href="${pageContext.request.contextPath}/updateUser/${user.email}">Update</a></button></td>
                <td Class="col col-2" style="width: 25%"><button type="button" onclick="myFunction()"><a href="${pageContext.request.contextPath}/deleteUser/${user.email}">Delete</a></button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script>
    function myFunction() {
        confirm("Are you sure you want to delete this user?");
    }
</script>
</body>
</html>
