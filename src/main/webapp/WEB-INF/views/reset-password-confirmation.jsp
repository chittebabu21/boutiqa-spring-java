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
<title>Reset Password Confirmation</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 mt-5">
				<h3 class="text-dark mb-4">Reset Password</h3>
				<form:form  method="POST" action="reset-password-confirmation" modelAttribute="login">
					<div class="form-group">
						<label for="password" class="text-info">New Password</label>
						<form:password path="password" id="password" class="form-control mb-2"  placeholder="Enter your password..."/>
					</div>
					<div class="form-group">
						<label for="confirmPassword" class="text-info">Confirm Password</label>
						<input name="confirmPassword" type="password" id="confirmPassword" class="form-control mb-2" placeholder="Enter your password again...">
						<c:if test="${ not empty error }">
							<p class="text-danger">${ error }</p>
						</c:if>
						<form:hidden path="email" />
					</div>
					<button class="btn btn-outline-info mt-2" type="submit" id="reset-button" name="button">RESET</button>
				</form:form>
			</div> 
		</div>
	</div>
</body>
</html>