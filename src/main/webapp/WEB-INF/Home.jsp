<!DOCTYPE html>

<html lang="en">
<head>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Home.css">
    <title>Home</title>

    <nav class="navbar navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#">TIMETABLE SYSTEM</a>
        </div>
    </nav>

</head>
<body>

<div class = "bg-image" style="background-image: url('Images/HomeBg1.jpg'); height: 100vh;"></div>
<form  class="box" action="${pageContext.request.contextPath}/authenticate" method="post">
    <h1>Login Here</h1>
    <input type="text" name="email" placeholder="Email" required>
    <input type="password" name="password" placeholder="Password" required>
    <input type="submit" name="" value="Login">
</form>
<div class="Message">
    <div>${error}</div>
</div>
</body>
</html>