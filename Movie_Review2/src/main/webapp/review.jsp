<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review</title>
</head>
<body>
	Hello, ${lb.user.firstName } ${lb.user.lastName }<hr/>
	<jsp:useBean id="cd" class="com.sunbeam.beans.ReviewBean"/>
	${cd.fetchReview() }
	<form method="post" action="review.jsp">
	<div style="margin-left: 400px"> 
	<table border="1" >
		<thead>
			<tr>
				<th>ID</th>
				<th>Movie</th>
				<th>Rating</th>
				<th>Review</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>	
			<c:forEach var="c" items ="${cd.revMov }"> 
				<tr>
				<td>${ c.review_id}</td>
				<td>${ c.title}</td>
				<td>${ c.rating}</td>
				<td>${ c.review}</td>
				<td>
					<a href=editreview.jsp><img alt="edit" src="edit.jpeg" height="15px" width="15px"></a>
					<a href=editreview.jsp><img alt="delete" src="delete.jpeg" height="15px" width="15px"></a>
					<a href=editreview.jsp><img alt="share" src="share.jpeg" height="15px" width="15px"></a>
				</td>
				</tr>
				</c:forEach>
		</tbody>			
		</table>
		<br/>
		<input style="margin-left: 60px" type="submit" value="Add Review"/>
		</div>
	</form>
	<form method="post" action="logout.jsp" style="display: inline;">
                <button type="submit">Logout</button>
            </form>
</body>
</html>
