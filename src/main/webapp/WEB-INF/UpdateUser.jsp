<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update User</title>

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
                <div class="smallBox">${UserDetails.firstName} ${UserDetails.lastName} ${UpdateUser.firstName} ${UpdateUser.lastName}</div>
                <div class="smallerBox">${UserDetails.batchId.batchName} ${UpdateUser.batchId}</div>
                <ul class = "lines">
                    <li>You cannot update initially provided name</li>
                    <li>Add students to batches</li>

                </ul>
            </div>
        </div>
        <div class = "requestForm">
            <form:form action="/AdminUpdateUser" method="POST" modelAttribute="UpdateUser">

                <h3>Update User</h3>

                <div class = "formBox">
                    <form:input path="firstName" value="${UserDetails.firstName}" type = "hidden" readonly="true" />
                    <form:input path="lastName" value="${UserDetails.lastName}" type = "hidden" readonly="true"/>

                    <div class="inputBox w50 single-select" style="width: 200px">
                        <label class = "label">Batch</label>
                        <div class = "selectBox w50">
                            <form:select path="batchId" type="text" style="border-color: black" cssClass="form-select"
                                         required="true">
                                <option selected disabled>Choose here</option>
                                <c:forEach var="listBatch" items="${listBatch}" varStatus="item">
                                    <form:option value="${listBatch.batchId}">
                                        ${listBatch.batchName}
                                    </form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>



                    <div class = "inputBox w50">
                        <form:input path="email" value="${UserDetails.email}" type = "text" readonly="true"/>
                        <span>Email</span>
                    </div>

                    <div class = "inputBox w50">
                        <form:input path="contactNumber" value="${UserDetails.contactNumber}" type = "text" minlength="10" maxlength="10" pattern="[0-9]+" title="Please be advised to only include numbers"/>
                        <span>Contact Number</span>
                    </div>

                    <div class = "inputBox w50">
                        <input type = "password" id="password"/>
                        <span>Password</span>
                    </div>

                    <div class = "inputBox w50">
                        <form:input path="password" value="" type = "password" id="confirm_password" required="true"/>
                        <span>Confirm Password</span>
                    </div>

                    <div class = "inputBox w100">
                        <input type="submit" value="Update">
                    </div>
                    <div class="Message">
                        <div>${success}${error}</div>
                    </div>
                </div>
            </form:form>
        </div>

    </div>
</section>
<script type="text/javascript">
    var password = document.getElementById("password")
        , confirm_password = document.getElementById("confirm_password");

    function validatePassword(){
        if(password.value != confirm_password.value) {
            confirm_password.setCustomValidity("Passwords Don't Match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>
</body>
</html>
