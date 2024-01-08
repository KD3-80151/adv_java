<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.sunbeam.beans.LoginBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
<jsp:setProperty name="lb" property="email" param="email"/>
<jsp:setProperty name="lb" property="password" param="passwd"/>
<jsp:setProperty name="lb" property="status" value="false"/>

<% lb.Login(); %>
Login Status:<jsp:getProperty property="status"
 name="lb"/>
 <%
 	if(lb.getStatus())
 		out.println("Welcome");
 	else
 		out.println("Invalid");
 
 %>
</body>
</html>