<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Here's your Omikuji!</h1>
	<h3>
	<c:out value="${result}"/>
	</h3>
	<div>
	<a href="/omikuji">Go back</a>
	</div>
</body>
</html>