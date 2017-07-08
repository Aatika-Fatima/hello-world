<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="<c:url value="/resources/js/jquery_validation/jquery.validate.min.js"/>"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
  
</head>
<body>
	admin Home
	<sec:authorize access="isAuthenticated()">
	Welcome ...Admin Home Page<sec:authentication property="principal.username" />
		<a href="../../j_spring_security_logout">Logout>></a>
	</sec:authorize>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<!--                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>                        
                                        </button>-->
			<a class="navbar-brand" href="#myPage">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">


			</ul>

		</div>

	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 sidebar navbar-fixed">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
					<li><a  href="?name=settingsLink"  id="settingsLink">Settings</a></li>
					<li><a   href="?name=editQuestionLink" id="editQuestionLink">Edit Question</a></li>
					<li><a href="?name=questionBankLink" id="questionBankLink">QuestionBank</a>
					<li><a href="?name=testPropertiesLink" id="testPropertiesLink">Test Properties Link</a>
					<li><a href="?name=categoriesLink"  id="categoriesLink">Categories</a>
					<li><a href="?name=difficultyLink"  id="adddifficultyLink">Difficulty</a>
					<li><a href="?name=addQuestionLink"  id="addQuestionLink">Create Question</a>
					
				</ul>
			</div>
			<div id="content" class="col-sm-10">
				<c:choose>
					<c:when test="${param.name == 'settingsLink'}"><%@include file="settings.jsp" %></c:when>
					<c:when test="${param.name == 'editQuestionLink'}"><c:import url="editQuestion.jsp"/></c:when>
					<c:when test="${param.name == 'questionBankLink'}"><c:import url="questionBank.jsp"/></c:when>
					<c:when test="${param.name == 'testPropertiesLink'}"><c:import url="testProperties.jsp"/></c:when>
					<c:when test="${param.name == 'categoriesLink'}"><c:import url="/addCategory.htm"/></c:when>
					<c:when test="${param.name == 'addQuestionLink'}"><c:import url="addQuestion.jsp"/></c:when>
					<c:when test="${param.name == 'difficultyLink'}"><c:import url="difficultyLevel.jsp"/></c:when>
				</c:choose>
			</div>
		</div>
		<!-- End of div row -->
	</div>
	<!-- End of container fluid -->
<!-- 	<div id="reportsContent" class="col-sm-9">Report Content to be displayed</div>
	<div id="operationContent" class="col-sm-9">Operations to be displayed</div> -->
<script>
/* $(document).ready(function(){
	$('#reportLink').click(function(){
	//	alert('reportlink');
		$( "#content" ).load( " #settingsContainer" );
	});
	
	$('#operationLink').click(function(){
		alert('operationLink');
		$( "#content" ).text( "Reports  Operation" );
	});
}); */
</script>

</body>
</html>