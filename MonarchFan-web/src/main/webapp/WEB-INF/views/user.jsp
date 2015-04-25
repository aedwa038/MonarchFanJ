<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>User</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<p>${user.id}</p>
				<p>${user.userName}</p>
				<p>${user.emailAddress}</p>
				
				<h3> Topics</h3>
				<c:forEach items="${topics}" var="topic">
				<div class="" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<p><a href="<spring:url value="/topics/${topic.id}" />">${topic.topicName}</a><p>
						</div>
					</div>
				</div>
			</c:forEach>
			
			<h3> Posts </h3>
			<c:forEach items="${posts}" var="post">
				<div class="" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<p><a href="<spring:url value="/posts/${post.id}" />">${post.contents}</a><p>
						</div>
					</div>
				</div>
			</c:forEach>

			</div>
		</div>
	</section>
</body>
</html>
