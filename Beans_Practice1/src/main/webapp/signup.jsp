<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<%System.out.println("hello");  %>
	<jsp:useBean id ="rb" class="com.sunbeam.beans.RegisterationBean" />
	<jsp:setProperty name ="rb" property = "*"/>
	
	<%rb.addUser(); %>
	
	<%if (rb.getStatus()){
		out.println("Successfull SignUp");	
		}
	else{
		out.println("Sign Up Failed.");
	}
	%>
</body>
</html>