<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
</head>
<body>
	<jsp:useBean id ="lb" class ="com.sunbeam.beans.LoginBean" scope = "page"/>
	<jsp:setProperty name ="lb" property="email" param="email"/>
	<jsp:setProperty name = "lb" property="password" param="password"/>
	<jsp:setProperty name = "lb" property="status" value="false"/>
	
	<%lb.authenticate(); %>
	<%if (lb.getStatus()){
		out.println("Welcome User");
	}
	else {
		out.println("Invalid Login");
	}
	%>
	Status of Login :<jsp:getProperty name= "lb" property="status"/>
	

</body>
</html>