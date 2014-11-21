<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StartUp Page</title>
<script>
function validateForm() {
    var v1 = document.forms["signupform"]["firstname"].value;
    if (v1 == null || v1 == "") {
        alert("First name cannot be left blank");
        return false;
    }
    var v2 = document.forms["signupform"]["lastname"].value;
    if (v2 == null || v2 == "") {
        alert("Last name cannot be left blank");
        return false;
    }
    var v3 = document.forms["signupform"]["username"].value;
    if (v3 == null || v3 == "") {
        alert("First name cannot be left blank");
        return false;
    }
    var v4 = document.forms["signupform"]["password"].value;
    if (v4 == null || v4 == "") {
        alert("Password cannot be left blank");
        return false;
    }
    var v5 = document.forms["signupform"]["cfpassword"].value;
    if (v5 == null || v5 == "") {
        alert("Confirm Password cannot be left blank");
        return false;
    }
    var v6 = document.forms["signupform"]["email"].value;
    if (v6 == null || v6 == "") {
        alert("Email cannot be left blank");
        return false;
    }
}
</script>
</head>
<body>
<h1 align="center">
<b>Welcome to Image Central</b>
</h1>
<form name="signupform" action="UserSignUp" onsubmit="return validateForm()" method="post">
<center>

<div> First Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="firstname" size="20" value="" /></div><br/>

<div> Last Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lastname" size="20" value=""/></div><br/>

<div> Username &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" size="20" value=""/></div><br/>

<div>Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" value=""/></div><br/>

<div>Confirm Password &nbsp;<input type="password" name="cfpassword" value=""/></div><br/>

<div>E-mail &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" value=""/></div><br/>

<input type="submit" value="Sign Up"/>

<input type="reset" value="Reset" />

</center>
</form>
</body>
</html>