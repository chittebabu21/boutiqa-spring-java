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
<title>Registration</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 mt-5">
				<h3 class="text-dark mb-4">Register Here</h3>
				<form:form action="process-registration" method="POST" modelAttribute="login">
					<div class="form-group">
						<label for="email" class="text-info">Email Address</label>
						<form:input path="email" type="email" id="email" class="form-control mb-2" placeholder="Enter your email address..."/>
					</div>
					<div class="form-group">
						<label for="password" class="text-info">Password</label>
						<form:input path="password" type="password" id="password" class="form-control mb-2" placeholder="Enter your password..."/> 
					</div>
					<div class="form-group">
						<label for="confirmPassword" class="text-info">Confirm Password</label>
						<input name="confirmPassword" type="password" id="confirmPassword" class="form-control mb-2" placeholder="Enter your password again...">
						<c:if test="${ not empty error }">
							<p class="text-danger">${ error }</p>
						</c:if>
					</div> 
					<div class="form-group">
						<label for="userType" class="text-info">User Type</label>
						<form:select path="userType" class="form-select mb-2" aria-label="Default select example">
							<form:option value="consumer" label="Consumer"/>
							<form:option value="seller" label="Seller"/>
						</form:select>
					</div>
					<button class="btn btn-outline-info mt-2" type="submit" id="button" name="button">REGISTER</button>
				</form:form>
				<h4 class="text-secondary text-center mt-5"><a href="${ pageContext.request.contextPath }/return-home" class="link-secondary">BACK</a></h4>
			</div>
		</div>
	</div>
</body>
</html>