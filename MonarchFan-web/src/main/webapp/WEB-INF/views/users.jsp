<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Users</h1>
				<p>All users in registered on our site</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${users}" var="user">
				<div class="" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<p><a href="<spring:url value="/users/${user.userName}" />">${user.userName}</a><p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
