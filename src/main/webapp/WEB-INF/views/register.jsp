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
	<div class="container">
		<div class="jumbotron">
		<h1>Please Enter Your Information</h1>
			<form action="add-user">
				Name: <input type="text" name="name" required><br>
				Email: <input type="email" name="email" id="email" required><br>
				Password: <input type="password" value="" id="myInput" name="password" required><br>
				<div class="form-check">
					<label class="form-check-label"> <input
						class="form-check-input" type="checkbox" onclick="showAndHide()">Show
						Password
					</label>
				</div>
				<input class="btn-primary" type="submit" value="Submit"><br>
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
	
	function validatePass() {

		var pass1 = document.getElementById("myInput").value;
		var pass2 = document.getElementById("myInput1").value;
		if(pass1 === pass2){
			return true;
		} else {
			alert("Your passwords do not match!");
			return false;
		}
		
	}
	</script>
</body>
</html>