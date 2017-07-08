<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Bootstrap Theme Company</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="<c:url value="/resources/js/jquery_validation/jquery.validate.min.js"/>"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<%-- <base href="<c:url value="/resources/images/" />">
 --%>
 <style>
.error {
	color: red;
	font-size: 0.8em;
}
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
	<div class="container-fluid text-center">
		<div class="jumbotron">
			<h1>${message}</h1>
			<h3>Resend Email</h3>
			<form class="form-inline" action="resendRegistrationEmail.htm" method="post">
				<div class="input-group">
					<input type="email" class="form-control" size="50" placeholder="Email Address" required  name="email"/>
					<div class="input-group-btn">
						<button type="submit" class="btn btn-danger">send</button>
					</div>
				</div>
			</form>
		</div>
		<c:if test="${message=='sent'}">
			<a href="">Please check ur mail</a>login
		</c:if>
	</div>
</body>
</html>