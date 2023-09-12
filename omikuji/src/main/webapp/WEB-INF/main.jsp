<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Send an Omikuji</h1>
	<div class = "container">
	
		<form action="/submit" method="post">
		
			<div>
				<label>Pick any number from 5 to 25</label>
				<input class="num" type= "number" name="number">
			</div>
			<div>
				<label>Enter the name of any city.</label>
				<input type="text" name="city">
			</div>
			<div>
				<label>Enter the name of a real person.</label>
				<input type="text" name="name">
			</div>
			<div>
				<label>Enter professional endeavor or hobby.</label>
				<input type="text" name="hobby">
			</div>
			<div>
				<label>Enter any type of living thing.</label>
				<input type="text" name="living">
			</div>
			<div>
				<label>Say something nice to someone.</label>
				<textarea name="message" cols="30" rows="10"></textarea>
			</div>
			<div>
				<p>Send and show a friend</p>
				<input type="submit" value="Send">
			</div>

		</form>
	
	</div>
</body>
</html>