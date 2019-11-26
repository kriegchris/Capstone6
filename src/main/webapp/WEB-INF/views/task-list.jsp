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
			<h1>${message }.</h1>
			<a href="/" class="btn btn-primary">Logout</a>
			<hr>
			<h1>Add Task</h1>
			<form action="/add-task">
				<input type="hidden" name="userId" value="${id }">
				Description: <input type="text" name="description" placeholder="description">
				Date: <input type="date" name="date" placeholder="yyyy-mm-dd">
				<input type="submit" class="btn btn-primary" value="Add Task">
			</form>
			<hr>
			<h1>Task List</h1>
			<table class="table">
				<tr>
					<th>Task#</th>
					<th>Description</th>
					<th>Due Date</th>
					<th>Completed</th>
					<th>Mark Done</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="t" items="${list }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td>${t.description }</td>
						<td>${t.date }</td>
						<td>${t.completed }</td>
						<td><a href="/complete?id=${t.taskId }" class="btn btn-primary">Mark Complete</a></td>
						<td><a href="/delete?id=${t.taskId }" class="btn btn-primary">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>