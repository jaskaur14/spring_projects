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
	<h1>Add a book to your shelf!</h1>
	<a href="/books">back to the shelves</a>
	
	<form:form action="/books/new" method="post" modelAttribute="newBook">
		<div class="form-group">
			<form:label path="title">Title: </form:label>
			<form:errors path="title"></form:errors>
			<form:input class="form-control" path="title"></form:input>
		</div>
		<div class="form-group">
			<form:label path="author">Author: </form:label>
			<form:errors path="author"></form:errors>
			<form:input class="form-control" path="author"></form:input>
		</div>
		<div class="form-group">
			<form:label path="thoughts">Thoughts: </form:label>
			<form:errors path="thoughts"></form:errors>
			<form:input class="form-control" path="thoughts"></form:input>
		</div>
		<form:input class="form-control" type="hidden" path="user" value="${loggedIn}"></form:input>
		<div class="form-group">
			<button>Submit</button>
		</div>
	</form:form>
	
</body>
</html>