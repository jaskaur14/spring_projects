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
<title>New Table</title>
</head>
<body>
	<h1>New Table</h1>
	<form:form action="/tables/new" method="post" modelAttribute="newGuest">
		<div class="form-group">
			<form:label path="guestName">Guest Name: </form:label>
			<form:errors path="guestName"/>
			<form:input class="form-control" path="guestName"></form:input>
		</div>
		<div class="form-group">
			<form:label path="numGuests"># of Guests: </form:label>
			<form:errors path="numGuests"/>
			<form:input class="form-control" type="number" min="1" max="10" path="numGuests"></form:input>
		</div>
		<div class="form-group">
			<form:label path="notes">Notes: </form:label>
			<form:input class="form-control" path="notes"></form:input>
		</div>
		<form:input class="form-control" type="hidden" path="user" value="${loggedIn}"></form:input>
		<div class="form-group">
			<button>Submit</button>
		</div>
	</form:form>
	<a href="/home">Cancel</a>
</body>
</html>