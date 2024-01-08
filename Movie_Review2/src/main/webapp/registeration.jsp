<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	
	<div style="margin-right:200px; margin-bottom: 20px" >
	<form method="post" action="register.jsp">
		First Name:<input type="text" name ="firstName"> <br/>
		Last Name:<input type="text" name ="lastName"> <br/>
		Email: <input type="text" name="email"/> <br/>
		Mobile No.:<input type="number" name ="mobile"> <br/>
		DOB: <input type="date" name="birth" > <br/>
		Password: <input type="password" name="password"/> <br/>
		
		<input type="submit" value="Sign Up"/>
	</form>
	</div>
</body>
</html>
