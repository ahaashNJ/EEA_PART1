<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/28/2021
  Time: 10:07 PM
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
                        <a class="nav-link item"href=${pageContext.request.contextPath}/StudentHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="${pageContext.request.contextPath}/getStudentHome/">My Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" href="${pageContext.request.contextPath}/StudentModules/">My Modules</a>
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
<div class="container">
    <h2>Modules</h2>

    <table>
        <thead Class = "table-header">
        <tr>
            <th><span>Module ID</span></th>
            <th><span>Module Name</span></th>
            <th>Lecturer Name</th>
            <th colspan="2">Contact lecturer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="modules" items="${modules}" varStatus="item">
            <tr class="lalign">
                <td Class="col col-1" style="width: 25%">${modules.moduleID}</td>
                <td Class="col col-2" style="width: 25%">${modules.moduleName}</td>
                <td Class="col col-2" style="...">${modules.lecturerEmail.firstName} ${modules.lecturerEmail.lastName}</td>
                <td class="col col-2" style="width: 25%"><a href="mailto:${modules.lecturerEmail.email}"><button>Email</button></a></td>
                <td class="col col-2" style="width: 25%"><a href="tel:${modules.lecturerEmail.contactNumber}"><button>Call</button></a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</body>
</html>
