<%--
  Created by IntelliJ IDEA.
  User: AHAASH
  Date: 4/28/2021
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<html lang="en">
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Inquiry.css">
    <title>Inquiry</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link item" aria-current="page" [routerLink]="['/home']" routerLinkActive="active" >Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" aria-current="page" [routerLink]="['/services']" routerLinkActive="active">Request Change</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link item" aria-current="page" [routerLink]="['/aboutUs']" routerLinkActive="active">Profile</a>
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
                    <li>Fill out the form and submit</li>
                    <li>Wait for the admin to approve</li>
                    <li>You will be notified with an email</li>
                </ul>
            </div>
        </div>
        <div class = "requestForm">
            <h3>Request Change</h3>
            <div class = "formBox">
                <div class = "inputBox w50">
                    <label>Choose batch:</label>
                    <select id="batch" required>
                        <option value="volvo">Volvo</option>
                        <option value="saab">Saab</option>
                        <option value="opel">Opel</option>
                        <option value="audi">Audi</option>
                    </select>
                </div>
                <div class = "inputBox w50">
                    <label>Choose module:</label>
                    <select id="module" required>
                        <option value="volvo">Volvo</option>
                        <option value="saab">Saab</option>
                        <option value="opel">Opel</option>
                        <option value="audi">Audi</option>
                    </select>
                </div>
                <div class = "inputBox w50">
                    <input type = "date" required>
                    <span>Initial Date</span>
                </div>
                <div class = "inputBox w50">
                    <input type = "time" required>
                    <span>Initial Time</span>
                </div>
                <div class = "inputBox w50">
                    <input type = "date" required>
                    <span>Request Date</span>
                </div>
                <div class = "inputBox w50">
                    <input type = "time" required>
                    <span>Request Time</span>
                </div>
                <div class = "inputBox w50">
                    <textarea required></textarea>
                    <span>Write your message</span>
                </div>
                <div class = "inputBox w100">
                    <input type="submit" value="Request">
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
