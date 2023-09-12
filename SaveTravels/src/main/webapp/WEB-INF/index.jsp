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
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="/expenses/<c:out value="${expense.id}"></c:out>"><c:out value="${expense.name}"></c:out></a></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td><c:out value="${expense.amount}"></c:out></td>
					<td><a href="/expenses/edit/${expense.id}">edit</a><a href="/expenses/delete/${expense.id}">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<h1>Add an expense:</h1>
		<form:form action="/expenses" method="post" modelAttribute="expense">
			<div>
				<form:label path="name">Expense name: </form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
			<div>
				<form:label path="vendor">Vendor: </form:label>
				<form:errors path="vendor"/>
				<form:input path="vendor"/>
			</div>
			<div>
				<form:label path="amount">Amount: </form:label>
				<form:errors path="amount"/>
				<form:input type="number" step="0.01" min="0" path="amount"/>
			</div>
			<div>
				<form:label path="description">Description: </form:label>
				<form:errors path="description"/>
				<form:textarea rows="3" path="description"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>
			
		</form:form>
		
	</div>
</body>
</html>