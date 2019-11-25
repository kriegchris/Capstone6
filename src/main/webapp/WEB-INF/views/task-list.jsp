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
			${goBack } ${register }
			<hr>
			<h1>Task List</h1>
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Description</th>
					<th>Due Date</th>
					<th>Completed</th>
					<th>Mark Done</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="t" items="${list }">
					<tr>
						<td>${t.taskId }</td>
						<td>${t.description }</td>
						<td>${t.date }</td>
						<td>${t.completed }</td>
						<td>*Add Link*</td>
						<td>*Add Link*</td>
						<%-- <td><a href="/complete?id=${f.id }" class="btn btn-primary">Mark Complete</a></td>
						<td><a href="/delete?id=${t.id }" class="btn btn-primary">Delete</a></td> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>