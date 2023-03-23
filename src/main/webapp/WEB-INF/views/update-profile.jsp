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
<title>Update Profile</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 mt-5">
				<h3 class="text-dark mb-4">Update Your Profile</h3>
				<form:form action="process-profile-update" method="POST" modelAttribute="profile">
					<label class="text-info mb-2"># </label>
					<c:out value="${ id }"/><br>
					<label class="text-info mb-2">Email: </label>
					<c:out value="${ email }"/>
					<div class="form-group">
						<label for="name" class="text-info">Name</label>
						<form:input path="name" id="name" class="form-control mb-2" placeholder="Enter your name..."/>
					</div>
					<div class="form-group">
						<label for="gender" class="text-info">Gender</label>
						<form:select path="gender" class="form-select mb-2">
							<form:option value="male" label="Male"/>
							<form:option value="female" label="Female"/>
						</form:select>
					</div>
					<button class="btn btn-outline-info mt-2" type="submit" id="updateButton" name="button">UPDATE</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>