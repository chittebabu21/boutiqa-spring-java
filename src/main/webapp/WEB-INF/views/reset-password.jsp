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
<title>Reset Password</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 mt-5">
				<h3 class="text-dark mb-4">Verify Email</h3>
				<form:form action="verify-email" method="POST" modelAttribute="login">
					<div class="form-group">
						<label for="email" class="text-info">Email Address</label>
						<form:input path="email" id="email" class="form-control mb-2" placeholder="Enter your email address..."/>
						<c:if test="${ not empty error }">
							<p class="text-danger">${ error }</p>
						</c:if>
					</div>
					<button class="btn btn-outline-info mt-2" type="submit" id="showButton" name="showButton">VERIFY</button>
				</form:form>
				<h4 class="text-secondary text-center mt-5"><a href="${ pageContext.request.contextPath }/return-home" class="link-secondary">HOME</a></h4>
			</div>
		</div>
	</div>
</body>
</html>