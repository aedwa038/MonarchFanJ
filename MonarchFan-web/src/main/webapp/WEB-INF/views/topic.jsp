<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Monarch Fan</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/css/jumbotron.css" />

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/">Monarch Fan</a>
        </div>
        <security:authorize access="isAnonymous()">
        <div id="navbar" class="navbar-collapse collapse">
         <form class="navbar-form navbar-right" method="POST" action="<c:url value='j_spring_security_check'/>">
            <button type="submit" class="btn btn-primary">Sign Up</button>
          </form>
          <form class="navbar-form navbar-right" method="POST" action="<c:url value='/j_spring_security_check'/>">
            <div class="form-group">
              <input name="j_username" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" placeholder="Username" class="form-control">
            </div>
            <div class="form-group">
              <input  name="j_password" type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
          
        </div><!--/.navbar-collapse -->
        </security:authorize>
        <security:authorize access="isAuthenticated()">
          <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
		</security:authorize>
      </div>
    </nav>
    
    <div class="jumbotron">
      <div class="container">
        <h1>Monarch Fan </h1>
        <p>Place for Monarch Lions!</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
      </div>
 </div>
 <p>${topic.id}</p>
				<p>${topic.topicName}</p>
				<p>${topic.description}</p>

		<div class="container-fluid">
			<table class="table table-bordered">
				
				<c:forEach items="${posts}" var="post">	
				<tbody>
               	    	<tr>	
               	    	<td class="col-md-2"> <span style="font-size:2.5em;" class="glyphicon glyphicon-align-right" aria-hidden="true"></span>
               	    	<p>Post by ${post.user.userName}</p></td>
               	    	 <td class="col-md-8" >
				  				<small>${post.contents}</small>
				 		</td>
							
						</tr>
					</tbody>
				</c:forEach>
					</thead>

			</table>



	<security:authorize access="isAuthenticated()">
    <form:form method="post" modelAttribute="post" >
    	<td><form:label path="contents">Reply</form:label></td>
        <td><form:textarea path="contents" rows="5" cols="30" /></td> 
    	<td><input type="submit" name="submit" value="reply" /></td> 
    </form:form>
	</security:authorize>
	
<hr>

      <footer>
        <p>&copy; Company 2014</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>

