<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="../css/main.css" var="jstlCss" />
<%-- <link href="${jstlCss}" rel="stylesheet" />
 --%>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
		<c:if test="${param.error=='error'}">
			<font color=red>username/password invalid</font>
		</c:if>
			 <form action="login" method="post">
			 	<input type="text" name="username" value="aatika"><br>
			 	<input type="password" name="password" value="fatima"><br>
			 	<input type="checkbox" name="remember-me">Remember Me<br>
			 	<input type="submit"/>
			 </form>
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>

</body>

</html>
