<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="<c:url value="/resources/js/jquery_validation/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/scripts/validation.js" />"></script>
<script src="<c:url value="/resources/js/scripts/main.js" />"></script>

</head>
<body>
	<div sec:authorize="hasAuthority('CHANGE_PASSWORD_PRIVILEGE')">
		<br> <br>
		<p id="changePasswordMessage" class="alert alert-info"></p>
		<div class="row col-md-offset-5">
			<div class="col-sm-4">
				<form id="changePassword" name="changePassword" method="post">
					<div class="input-group">
						<span class="input-group-addon  form-logo-color"><i class="glyphicon glyphicon-eye-open"></i></span>
						<input type="password" class="form-control" id="pwd" name="password" placeholder="<spring:message code="label.form.register.password"/>">

					</div>
					<div></div>

					<br>

					<div class="input-group">
						<span class="input-group-addon  form-logo-color"><i class="glyphicon glyphicon-eye-open"></i></span>
						<input type="password" class="form-control" id="reEnterPassword" name="reEnterPassword"
							placeholder="<spring:message code="label.form.register.reEnterPassword"/>">


					</div>
					<div></div>
					<br>
					<button style="align: center;" type="submit" class="btn btn-default btn-md col-sm-offset-5">
						<spring:message code="label.form.login.submit" />
					</button>
				</form>
			</div>
		</div>
		<p id="msg"></p>

		<script>
			
		</script>
	</div>
</body>
</html>