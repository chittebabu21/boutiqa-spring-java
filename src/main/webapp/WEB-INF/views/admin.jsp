<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous" defer></script>
<title>Admin Panel</title>
</head>
<body>
	<div class="container mt-2 mb-2">
		<h1 class="text-center text-info">Admin Panel</h1>
		<br>
		<table class="table table-striped">
		
			<!-- header tag -->
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">User Type</th>
				</tr>
			</thead>
			
			<!-- body tag -->
			<tbody>
				<c:forEach items="${logins}" var="login">
				<tr>
					<td>${ login.userId }</td>
					<td>${ login.email }</td>
					<td>${ login.password }</td>
					<td>${ login.userType }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<h4 class="text-secondary text-center mt-5 mb-5"><a href="${ pageContext.request.contextPath }/return-home" class="link-secondary">BACK</a></h4>
	</div>
</body>
</html>