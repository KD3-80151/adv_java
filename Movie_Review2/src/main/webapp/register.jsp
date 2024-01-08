<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sign Up</title>
</head>
<body>

    <h2>You're registered:</h2>
    <h4>Kindly please login again</h4>
    
	<jsp:useBean id="ab" class= "com.sunbeam.beans.RegisterationBean"/>
	<jsp:setProperty name="ab" property="*"/>	
	${ab.addUser()}
	
	<form method="post" action="index.jsp">
		<button type="submit">Go to Login</button>
	</form>
	
</body>
</html>
