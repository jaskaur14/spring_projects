<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fruity loops</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Fruit Store</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
			<c:forEach var="fruit" items="${fruits}">
			<tr>
				<td><c:out value="${fruit.name}"></c:out></td>
				<td><c:out value="$ ${fruit.price}"></c:out></td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>