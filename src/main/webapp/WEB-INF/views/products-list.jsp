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
<title>Products List</title>
</head>
<body>
	<div class="container mt-2 mb-2">
		<div class="row">
			<h1 class="text-center text-info">Products Lists</h1>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<form:form action="${ pageContext.request.contextPath }/search" method="GET" modelAttribute="product">
					<div class="form-group">
						<input type="text" name="searchTerm" class="form-control mb-1" placeholder="Search for products..." />
						<c:if test="${ not empty error }">
							<p class="text-danger">${ error }</p>
						</c:if>
					</div>
					<button type="submit" class="btn btn-outline-info mt-1">SEARCH</button>
				</form:form>
			</div>
		</div>
		<br>
		<table class="table table-striped">
		
			<!-- header tag -->
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Product Name</th>
					<th scope="col">Product Description</th>
					<th scope="col">Seller ID</th> 
				</tr>
			</thead>
			
			<!-- body tag -->
			<tbody>
				<c:forEach items="${products}" var="product">
				<tr>
					<td>${ product.productId }</td>
					<td>${ product.productName }</td>
					<td>${ product.productDescription }</td>
					<td>${ product.login.userId }</td> 
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<h4 class="text-secondary text-center mt-5"><a href="${ pageContext.request.contextPath }/return-home" class="link-secondary">BACK</a></h4>
	</div>
</body>
</html>