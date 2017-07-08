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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="<c:url value="/resources/js/jquery_validation/jquery.validate.min.js"/>"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<%-- <base href="<c:url value="/resources/images/" />">
 --%>
</head>
<body>
	<div class="alert alert-info" align="center">
		<c:if test="${message != null}">
			<strong>A new registration link is sent ...please check the email</strong>
		</c:if>
	</div>

	${expired}

	<div class="alert alert-danger">

		<c:if test="${param.expired != null}">
			<strong>Please click on the link</strong>
			<a href="../resendRegistrationToken.htm?token=${param.token} "> <spring:message code="auth.link.resend" /></a>
		</c:if>
		<c:if test="${param.expired != null}">
			<strong>Please click on the link</strong>
			<a href=""> <spring:message code="auth.link.resend" /></a>
		</c:if>
	</div>

	<div class="container">
		<h2>Reset Password</h2>
		<form>
			<input type="hidden" name="userId" value="${param.id }" />
			
				<div class="input-group">
				<span class="input-group-addon  form-logo-color"><i class="glyphicon glyphicon-eye-open"></i></span>
				<input type="password" class="form-control" id="pwd" name="password"
					placeholder="<spring:message code="label.form.register.password"/>">
				<span class="text-danger" id="emailErrorMessage"></span>
			</div>
			<div></div>
			
			
			<div class="input-group">
				<span class="input-group-addon  form-logo-color"><i class="glyphicon glyphicon-eye-open"></i></span>
				<input type="password" class="form-control" id="reEnterPassword" name="reEnterPassword"
					placeholder="<spring:message code="label.form.register.reEnterPassword"/>">
				<span class="text-danger" id="emailErrorMessage"></span>
			</div>
			<div></div>

			<br>
			<div class="input-group">
				<span class="input-group-addon form-logo-color"><i class="glyphicon glyphicon-envelope"></i></span>
				<input type="text" class="form-control" id="email" name="email" placeholder="<spring:message code="label.form.register.email"/>">
				<span class="text-danger" id="emailErrorMessage"></span>
			</div>
			<div></div>

			<button type="button" class="btn btn-default">Submit</button>
		</form>
	</div>

































	<script>
		function getUrlVars() {
			var vars = [], hash;
			var hashes = window.location.href.slice(
					window.location.href.indexOf('?') + 1).split('&');
			for (var i = 0; i < hashes.length; i++) {
				hash = hashes[i].split('=');
				vars.push(hash[0]);
				vars[hash[0]] = hash[1];
			}
			return vars;
		}
		var serverContext = "spring-mvc";
		/* 		function resendToken( ) {
		 event.preventDefault();
		 alert('token');
		 var token = getUrlVars()["token"];
		 alert('token = ' + token);
		 $.ajax({
		 type : 'GET',
		 url : "spring-mvc../resendRegistrationToken.htm",
		 data : token,
		 success : function(response) {
		 alert('success');
		 window.location.href = "spring-mvc/main.htm";
		 },
		 error : function(xhr, status, error) {
		 alert(xhr.responseText);
		 alert(status);
		 alert(error);
		 alert(window.location.href);
		 },
		 done:function(xml){
		 alert(this.url);
		 }

		 });
		 }  
		 */
		$(document).ready(function() {
			$("a").click(function(event) {
				event.preventDefault();
				alert('token');
				var token = getUrlVars()["token"];
				alert('token = ' + token);
				$.ajax({
					type : 'GET',
					url : 'spring-mvc/resendRegistrationToken.htm',
					data : token,
					success : function(response) {
						alert('success');
						window.location.href = "/spring-mvc/main.htm";
					},
					error : function(xhr, status, error) {
						alert(xhr.responseText);
						alert(status);
						alert(error);
						alert(window.location.href);
					},
					done : function(xml) {
						alert(this.url);
					}

				});

			});
		});
	</script>
</body>
</html>