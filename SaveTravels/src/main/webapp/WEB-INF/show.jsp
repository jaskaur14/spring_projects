<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href="/expenses">go back</a>
	<table>
		<tbody>
			<tr>
				<td> Expense Name: </td>
				<td><c:out value="${expense.name}"></c:out></td>
			</tr>
			<tr>
				<td> Expense Description: </td>
				<td><c:out value="${expense.description}"></c:out></td>
			</tr>
			<tr>
				<td> Vendor: </td>
				<td><c:out value="${expense.vendor}"></c:out></td>
			</tr>
			<tr>
				<td> Amount spent: </td>
				<td><c:out value="${expense.amount}"></c:out></td>
			</tr>
		</tbody>
	</table>
</body>
</html>