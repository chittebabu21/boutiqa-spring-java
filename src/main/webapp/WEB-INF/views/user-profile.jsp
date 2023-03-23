<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous" defer></script>
<title>Profile</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 mt-5">
				<h3 class="text-dark mb-4">My Profile</h3>
				<label class="text-info mb-2">Name: </label>
				<c:out value="${ name }"/><br>
				<label class="text-info mb-2">Email: </label>
				<c:out value="${ email }"/><br>
				<label class="text-info mb-2">Gender: </label>
				<c:out value="${ gender }"/>
			</div>
		</div>
	</div>
</body>
</html>