<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<title></title>
<link href="<c:url value="/resources/js/bootstrap/3.3.7/css/bootstrap.min.css"/>" rel="stylesheet" />
<script src="<c:url value="/resources/js/bootstrap/jquery/1.9.1/jquery-1.9.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery_validation/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>
<style>
.error {
	color: red;
	font-size: 0.8em;
}

body {
	margin: 30px;
}
</style>
</head>
<body>

	<form id="formA">
		<input type="text" name="username" />
		<input type="submit" value="submit" />
	</form>

	<form id="formB">
		<input type="text" name="email" />
		<input type="submit" value="submit" />
	</form>

</body>

<script>
	$(document).ready(function() {
		$('#formA').validate({
			rules:{
				username:{
					required:true,
			 
				}
			}, 
			submitHandler:function(event){
				alert('prevent default');
				alert('submit handler for formA')
			}
		});
		$('#formB').validate({
			rules:{
				email:{
					required:true,
					email:true
				}
			}, 
			submitHandler:function(event){
				alert('prevent default');
				alert('submit handler for formB')
			}
		});
	});
</script>


</html>
