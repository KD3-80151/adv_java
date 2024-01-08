<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com.sunbeam.beans.SignUpBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.SignUpBeans"/>
	<jsp:setProperty name="lb" property="*"  />
	<% lb.register(); %>
	

	
</body>
</html>