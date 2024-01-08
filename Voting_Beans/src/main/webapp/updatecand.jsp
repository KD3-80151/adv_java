<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Candidate</title>
</head>
<body>
	<jsp:useBean id="ucb" class="com.sunbeam.beans.UpdateCandidateBean"/>
	<jsp:setProperty name="ucb" property="*"/>
	${ucb.updateCandidate()}
	<jsp:forward page="result.jsp">
		<jsp:param name="ucbMessage" value="${ucb.message}"/>
	</jsp:forward>
</body>
</html>
