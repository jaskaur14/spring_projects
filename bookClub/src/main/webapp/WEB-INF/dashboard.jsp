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
<title>Book Club</title>
</head>
<body>
	<h1>Welcome, <c:out value="${loggedInUser.name}"></c:out>!</h1>
	<p><a href="/books/new">add to my shelf!</a></p>
	<p>Books from everyone's shelves:</p>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="book" items="${allBooks}">
    		<tr>
				<td><c:out value="${book.id}"/></td>
				<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.author}"/></td>
				<td><c:out value="${book.user.name}"/></td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="/logout">logout</a></p>
</body>
</html>