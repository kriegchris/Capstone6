<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">
</head>
<body>
	<div class="Container">
		<div class="jumbotron">
			<h1>Welcome to Tasky!</h1>
			<h2>A simple and faster way of keeping track of your To-Do's</h2>
			<hr>
			<form action="/login"  name="myForm" method="post" onsubmit="return validateEmail()">
				Email: <input type="text" name="email" required><br>
				Password: <input type="password" value="" id="myInput" name="password" required><br>
				<div class="form-check">
					<label class="form-check-label"> <input
						class="form-check-input" type="checkbox" onclick="showAndHide()">Show
						Password
					</label>
				</div>
				<input class="btn-primary" type="submit" value="Submit">
			</form>
		</div>
	</div>
	<script>
		function showAndHide() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		function validateEmail() {
			var email = document.getElementById("email").value;
			console.log(email);
			var emailReg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			if (email.match(emailReg)) {
				return true;
			} else {
				alert("You have entered an invalid email address!");
				return false;
			}
		}
	</script>
</body>
</html>