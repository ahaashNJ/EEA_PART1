<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 5/1/2021
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Inquiry.css">
    <title>Add User</title>

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
<section>
    <div class = "container">
        <div class = "formInfo">
            <div>
                <h2>Guidelines</h2>
                <ul class = "lines">
                    <li>Fill out all the fields</li>
                    <li>A default password will be given to the user</li>
                    <li>Assign batches via the update user</li>
                </ul>
            </div>
        </div>
        <div class = "requestForm">
            <h3>Add User</h3>
<form:form action="${pageContext.request.contextPath}/AddUser" method="POST" modelAttribute="AddUsers">
            <div class = "formBox">
                <div class = "inputBox w50">
                    <label class = "label">User Type</label>
                    <div class = "selectBox w50">
                        <form:select path="userType" type="text"  style="border-color: black" cssClass="form-control">
                            <form:option value="Student"></form:option>
                            <form:option value="Lecturer"></form:option>
                        </form:select>
                </div>
                </div>
                <div class = "inputBox w50">
                    <form:input path="firstName" type = "text" required="true" maxlength="50"/>
                    <span>First Name</span>
                </div>
                <div class = "inputBox w50">
                    <form:input path="lastName" type = "text" required="true" maxlength="50"/>
                    <span>Last Name</span>
                </div>
                <div class = "inputBox w50">
                    <form:input path="email" type = "email" required="true" maxlength="50" pattern=".+@gmail.com" title="The email should contain '@gmail.com' werbserver"/>
                    <span>Email</span>
                </div>
                <div class = "inputBox w50">
                    <form:input path="contactNumber" type = "text" required="true" minlength="10" maxlength="10" pattern="[0-9]+" title="Please be advised to only include numbers"/>
                    <span>Contact number</span>
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
