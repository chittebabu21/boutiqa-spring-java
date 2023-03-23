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
<title>Home</title>
</head>
<body>
	<div class="container mt-2 mb-2">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="text-center text-info">Home</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<h3 class="text-info mb-3"><a href="${ pageContext.request.contextPath }/return-home" class="link-secondary">Logo</a></h3>
				<form:form>
					<div class="form-group">
						<input type="text" id="search" class="form-control mb-3" placeholder="Search for products..." >
					</div>
				</form:form>
				<h3 class="text-info mb-3"><a href="/assignment/login" class="link-secondary">Login</a></h3>
				<h3 class="text-info mb-3"><a href="/assignment/registration" class="link-secondary">Register</a></h3>
				<h3 class="text-info mb-3"><a href="<c:url value='/products-list'/>" class="link-secondary">View All Products</a></h3>
			</div>
		</div>
	</div>
</body>
</html>