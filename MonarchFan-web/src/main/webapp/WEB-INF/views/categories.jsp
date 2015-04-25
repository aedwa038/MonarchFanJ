<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Users</h1>
				<p>All categories in registered on our site</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${categories}" var="category">
				<div class="" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<p><a href="<spring:url value="/categories/${category.id}" />">${category.categoryName}</a><p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
