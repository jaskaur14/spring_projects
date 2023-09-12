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
    <title>Dojos and Ninjas</title>
</head>
<body>
   <h1>New Dojo</h1>
	<form:form action="/dojos" method="post" modelAttribute="dojoModel">
		<div>
			<form:label path="name">Name: </form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>