<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>Welcome back, <c:out value="${loggedInUser.name}"></c:out>!</h1>
	<p><a href="/logout">logout</a></p>
	<h2>Your Tables</h2>
	<table>
		<tr>
			<th>Guest Name</th>
			<th># of Guests</th>
			<th>Arrived at</th>
			<th>Actions</th>
		</tr>
			<%-- <c:choose> --%>
					<c:forEach var="guest" items="${allGuests}">
			    		<tr>
						<c:if test= "${loggedInUser.id == guest.user.id}">
							<td><c:out value="${guest.guestName}"/></td>
							<td><c:out value="${guest.numGuests}"/></td>
							<td><c:out value="${guest.createdAt}"/></td>
							<td><a href="/tables/${guest.id}/delete">finished</a>
							<a href="/tables/${guest.id}/edit">edit</a></td>
						</c:if> 
						</tr>
					</c:forEach>
				<%-- <c:otherwise>
				
				<p>get tables</p>
				</c:otherwise>
			</c:choose> --%>
	</table>
	<a href="/tables/new">New Table</a>
</body>
</html>