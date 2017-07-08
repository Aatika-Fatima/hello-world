<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

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
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script>

 
	/* var loginFailed = function(data, status) {
	 alert('asdf');
	 };

	 $("#login").live('click', function(e) {
	 e.preventDefault();
	 $.ajax({url: getHost() + "${ctx}/api/login.json",
	 type: "POST",
	 beforeSend: function(xhr) {
	 xhr.withCredentials = true;
	 },
	 data: $("#loginForm").serialize(),
	 success: function(data, status) {
	 if (data.loggedIn) {
	 // success
	 dialog.dialog('close');
	 location.href = getHost() + '${ctx}/users';
	 } else {
	 loginFailed(data);
	 }
	 },
	 error: loginFailed
	 });
	 }); */
 
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
	<!--                                                     Navigation Bar
                ==================================================================================================================-->
	<nav class="navbar navbar-default navbar-fixed-top">
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
					<li><a href="#about">ABOUT</a></li>
					<li><a href="#services">SERVICES</a></li>
					<li><a href="#portfolio">PORTFOLIO</a></li>
					<li><a href="#pricing">PRICING</a></li>
					<li><a href="#contact">CONTACT</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="modal" data-backdrop="static" data-keyboard="false" data-target="#authenticationModal"><span
							class="glyphicon glyphicon-user"></span>SIGN UP</a></li>
					<li><a href="#" data-toggle="modal" data-target="#authenticationModal" data-backdrop="static" data-keyboard="false"><span
							class="glyphicon glyphicon-log-in"></span>SIGN IN</a></li>
				</ul>
			</div>

		</div>
	</nav>
	<!--JumboTron Container-->
	<!--==============================================================================================================-->
	<div class="container-fluid text-center">
		<div class="jumbotron">
			<h1>Company</h1>
			<sec:authentication property="name" />
			<p>We specialize in blah blah</p>
			<form class="form-inline">
				<div class="input-group">
					<input type="email" class="form-control" size="50" placeholder="Email Address" required />
					<div class="input-group-btn">
						<button type="button" class="btn btn-danger">Subscribe</button>
					</div>
				</div>
			</form>
		</div>

	</div>
	<!--About Container-->
	<!--==============================================================================================================-->
	<!-- Container (About Section) -->
	<div id="about" class="container-fluid">
		<div class="row">
			<div class="col-sm-8">
				<h2>About Company Page</h2>
				<h4>Lorem ipsum..</h4>
				<p>Lorem ipsum..</p>
				<button class="btn btn-default btn-lg">Get in Touch</button>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-signal  logo" />
			</div>
		</div>

	</div>
	<!--Mission Container-->
	<!--==============================================================================================================-->
	<div class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-globe  logo" />
			</div>
			<div class="col-sm-8">
				<h2>Our Values</h2>
				<h4>
					<strong>MISSION:</strong> Our mission lorem ipsum..
				</h4>
				<p>
					<strong>VISION:</strong> Our vision Lorem ipsum..
			</div>
		</div>

	</div>
	<!--Services Container-->
	<!--==============================================================================================================-->
	<div id="services" class="container-fluid text-center">
		<h2>SERVICES</h2>
		<h4>What we offer</h4>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-off logo-small"></span>
				<h4>POWER</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-heart logo-small"></span>
				<h4>POWER</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-lock logo-small"></span>
				<h4>POWER</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
		</div>
		<div class="container-fluid"></div>
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-leaf logo-small"></span>
				<h4>POWER</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-certificate logo-small"></span>
				<h4>POWER</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-wrench logo-small"></span>
				<h4>POWER</h4>
				<p>Lorem ipsum dolor sit amet..</p>
			</div>
		</div>
	</div>

	<!--Portfolio Container-->
	<!--=========================================================================-->
	<div id="portfolio" class="container-fluid text-center bg-grey">
		<h2>Portfolio</h2>
		<h4>What we have created</h4>
		<div class="row text-center">
			<div class="col-sm-4">
				<div class="img-thumbnail">
					<img src="bird.jpg" />
					<p>
						<strong>Bird</strong>
					</p>
					<p>Yes its a bird</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="img-thumbnail">
					<img src="bird.jpg" />
					<p>
						<strong>Bird</strong>
					</p>
					<p>Yes its bird</p>
				</div>
			</div>

			<div class="col-sm-4">
				<div class="img-thumbnail">
					<img src="bird.jpg" />
					<p>
						<strong>Bird</strong>
					</p>
					<p>Yes its bird</p>
				</div>
			</div>
		</div>
	</div>
	<!--Carousel Container-->
	<!--==============================================================================================================-->
	<div id="myCarousel" class="carousel slide text-center" data-ride="slide">
		<h2>What Our Customer have to say</h2>

		<ol class="carousel-indicators">
			<li data-target="" data-slide-to="0" class="active"></li>
			<li data-target="" data-slide-to="1"></li>
			<li data-target="" data-slide-to="2"></li>
		</ol>

		<!--Wrapper for Inner Slide-->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<h4>
					"This company is the best. I am so happy with the result!"<br> <span style="font-style: normal;">Michael Roe, Vice President, Comment Box</span>
				</h4>
			</div>

			<div class="item">
				<h4>
					"One word... WOW!!"<br> <span style="font-style: normal;">John Doe, Salesman, Rep Inc</span>
				</h4>
			</div>

			<div class="item">
				<h4>
					"Could I... BE any more happy with this company?"<br> <span style="font-style: normal;">Chandler Bing, Actor, FriendsAlot</span>
				</h4>
			</div>
		</div>
		<!--Left and Right Controlls-->
		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
	</div>
	<!--Pricing Container-->
	<!--        ===================================================================-->
	<div id="pricing" class="container-fluid">
		<div class="text-center">
			<h2>Pricing</h2>
			<h4>Choose a payment plan that works for you</h4>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h1>Basic</h1>
					</div>
					<div class="panel-body">
						<p>
							<strong>20</strong> Lorem
						</p>
						<p>
							<strong>15</strong> Ipsum
						</p>
						<p>
							<strong>5</strong> Dolor
						</p>
						<p>
							<strong>2</strong> Sit
						</p>
						<p>
							<strong>Endless</strong> Amet
						</p>
					</div>
					<div class="panel-footer">
						<h3>$19</h3>
						<h4>per month</h4>
						<button class="btn btn-lg" style="background-color: #c7254e">Sign Up</button>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h1>Pro</h1>
					</div>
					<div class="panel-body">
						<p>
							<strong>50</strong> Lorem
						</p>
						<p>
							<strong>25</strong> Ipsum
						</p>
						<p>
							<strong>10</strong> Dolor
						</p>
						<p>
							<strong>5</strong> Sit
						</p>
						<p>
							<strong>Endless</strong> Amet
						</p>
					</div>
					<div class="panel-footer">
						<h3>$29</h3>
						<h4>per month</h4>
						<button class="btn btn-lg" style="background-color: #c7254e">Sign Up</button>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h1>Premium</h1>
					</div>
					<div class="panel-body">
						<p>
							<strong>100</strong> Lorem
						</p>
						<p>
							<strong>50</strong> Ipsum
						</p>
						<p>
							<strong>25</strong> Dolor
						</p>
						<p>
							<strong>10</strong> Sit
						</p>
						<p>
							<strong>Endless</strong> Amet
						</p>
					</div>
					<div class="panel-footer">
						<h3>$49</h3>
						<h4>per month</h4>
						<button class="btn btn-lg" style="background-color: #c7254e">Sign Up</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--                                            Contact Container
     ============================================================================================================-->
	<div id="contact" class="container-fluid bg-grey">
		<h2 class="text-center">CONTACT</h2>
		<div class="row">
			<div class="col-sm-5">
				<p>Contact us and we'll get back to you within 24 hours.</p>
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> Chicago, US
				</p>
				<p>
					<span class="glyphicon glyphicon-phone"></span> +00 1515151515
				</p>
				<p>
					<span class="glyphicon glyphicon-envelope"></span> myemail@something.com
				</p>
			</div>
			<div class="col-sm-7">
				<div class="row">
					<div class="col-sm-6 form-group">
						<input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
					</div>
					<div class="col-sm-6 form-group">
						<input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
					</div>
				</div>
				<textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
				<br>
				<div class="row">
					<div class="col-sm-12 form-group">
						<button class="btn btn-default pull-right" type="submit">Send</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--                                                        Login Modal
                ==========================================================================================================================-->
	<!-- Modal -->
	<!-- Modal -->
	<div class="modal fade" id="authenticationModal" role="dialog" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" onclick="javascript:window.location.reload()">&times;</button>
					<h4 class="modal-title">Authentication</h4>
				</div>
				<div class="modal-body">
					<div class="container">

						<ul class="nav nav-pills text-center">
							<li class=""><a data-toggle="pill" href="#home">Login</a></li>
							<li class=""><a data-toggle="pill" href="#registerMenu">Register</a></li>
							<li class=""><a data-toggle="pill" href="#menu2">Forgot Password</a></li>
						</ul>
						<%-- 		<h5 id="errorMessage">
							<c:if test="${param.error != null}">
								<font color="red"><strong></strong><c:out value="${SPRING_SECURITY_LAST_EXCEPTION}"/></font>
							</c:if>
						</h5> --%>
						<div class="tab-content">
							<div id="home" class="tab-pane fade in active">
								<br> <br>
								<div class="container">
									<div class="row col-md-offset-1">
										<div class="col-sm-4">
											<div class="alert alert-danger fade in" id="validation_sign_in_error" style="display: none">
												<!-- 	<a href="#" class="close" data-dismiss="alert">&times;</a> -->
												<strong>Error!</strong>
												<%-- <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}" /> --%>
											</div>

											<form id="login" name="login" method="post" action="j_spring_security_check">
												<div class="input-group">
													<span class="input-group-addon form-logo-color"><i class="glyphicon glyphicon-user"></i></span>
													<input type="text" class="form-control" id="userName" placeholder="<spring:message code="label.form.login.username"/>" name="j_username">
													<span class="text-danger" id="emailErrorMessage"></span>
												</div>
												<div></div>
												<br>
												<div class="input-group">
													<span class="input-group-addon form-logo-color"><i class="glyphicon glyphicon-eye-open"></i></span>
													<input type="password" class="form-control" id="pwd" placeholder="<spring:message code="label.form.login.password"/>" name="j_password">
													<span class="text-danger" id="emailErrorMessage"></span>
												</div>
												<div></div>
												<br>
												<div class="checkbox">
													<label><input type="checkbox" name="remember-me"><small> <spring:message code="label.form.login.rememberMe" />
													</small></label>
												</div>

												<button style="align: center;" id="signInBtn" type="submit" class="btn btn-default btn-md col-sm-offset-5">
													<spring:message code="label.form.login.submit" />
												</button>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div id="registerMenu" class="tab-pane fade">
								<br> <br>
								<div class="container">
									<div class="row col-md-offset-1">
										<div class="col-sm-4">
											<form id="registrationForm" name="registrationForm" method="post">
												<div class="input-group">
													<span class="input-group-addon  form-logo-color"><i class="glyphicon glyphicon-user"></i></span>
													<input type="text" class="form-control" id="userName" name="userName" placeholder="<spring:message code="label.form.register.username"/>">
													<span class="text-danger" id="emailErrorMessage"></span>
												</div>
												<div></div>
												<br>
												<div class="input-group">
													<span class="input-group-addon  form-logo-color"><i class="glyphicon glyphicon-eye-open"></i></span>
													<input type="password" class="form-control" id="pwd" name="password" placeholder="<spring:message code="label.form.register.password"/>">
													<!-- 													<span class="text-danger" id="emailErrorMessage">Email entered is incorrect</span>
 -->
												</div>
												<div></div>

												<br>

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
													<input type="email" class="form-control" id="email" name="email" placeholder="<spring:message code="label.form.register.email"/>">
													<span class="text-danger" id="emailErrorMessage"></span>
												</div>
												<div></div>

												<div class="checkbox">
													<div></div>
													<label><input type="checkbox" name="agree"><small> <spring:message code="label.form.register.agree" />
													</small></label>
												</div>
												<div class="checkbox">
													<label><input type="checkbox"> <small><spring:message code="label.form.register.subscribe" /></small></label>
												</div>
												<button style="align: center;" type="submit" class="btn btn-default btn-md col-sm-offset-5">
													<spring:message code="label.form.register.submit" />
												</button>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div id="menu2" class="tab-pane fade">
								<div class="container">
									<div class="row col-md-offset-1">
										<div class="col-sm-4">
											<br>
											<div id='forgotPasswordMessage' class="alert alert-info" style='display: none;'></div>
											<!-- 											<span class="label label-info col-md-offset-2" id="forgotPasswordMessage"></span> <br> <br>
 -->
											<form id="forgotPassword" name="forgotPassword" method="POST">
												<div class="input-group">
													<span class="input-group-addon  form-logo-color"><i class="glyphicon glyphicon-user"></i></span>
													<input type="email" class="form-control" id="email" name="email" placeholder="Enter Username">
													<span class="text-danger" id="emailErrorMessage"></span>
												</div>
												<div></div>
												<br>

												<button style="align: center;" type="submit" class="btn btn-default btn-md col-sm-offset-5">Submit</button>
											</form>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>

			</div>

		</div>
	</div>




	<!--                                                        Footer
             ==============================================================================================================================                                   -->
	<footer class="footer text-center">
		<a href="#myPage" title="To Top"> <span class="glyphicon glyphicon-chevron-up"></span>
		</a>
		<p class="text-muted">
			Bootstrap Theme Made By <a href="https://www.w3schools.com" title="Visit w3schools">www.w3schools.com</a>
		</p>
	</footer>

	<!--        </footer>
                                                                  Java Script
            ================================================================================================================================-->

	<script type="text/javascript">
		/* 		$(document).ready(function() {
		 $("#registrationForm").submit(function(event) {
		 alert('Registration form');
		 doAjaxPost(event);
		 });
		 }

		 );

		 function doAjaxPost(event) {
		 // get the form values  
		 event.preventDefault();
		
		 var formData = $("#registrationForm").serialize();
		 alert(formData);
		 $.ajax({
		 type : "POST",
		 url : "/spring-mvc/registerUser.htm",
		 data : formData,
		 success : function(data) {
		 alert("success"+data);
		 window.location.href="/spring-mvc/adminHome.htm"
		 },
		 error : function(xhr, status, error) {
		 alert(xhr.responseText);
		 alert(status);
		 alert(error);
		 },
		 done : function(e) {
		 console.log("DONE");
		 alert('done');
		 }
		 });
		 }
		 */
		jQuery.validator.addMethod('passwordMatch', function(value, element) {

			// The two password inputs
			var password = $("#pwd").val();
			var confirmPassword = $("#reEnterPassword").val();

			// Check for equality with the password inputs
			if (password != confirmPassword) {
				return false;
			} else {
				return true;
			}

		}, "Your Passwords Must Match");

		/* 		$.validator.addMethod("startsWithA", function(value, element) {
		 return /^A/.test(value);
		 }, 'Fields Must start with A');

		 $('#registrationForm').validate({
		 rules : {
		 userName : {
		 required : true,
		 },
		 email : {
		 required : true,
		 email : true
		 },
		 password : {
		 required : true,
		 minlength : 8
		 },
		 reEnterPassword : {
		 passwordMatch : true,
		 minlength : 8,
		 required : true
		 },
		 agree : {
		 required : true,
		 }
		 },
		 messages : {
		 agree : {
		 required : "You must select at least 1 box",
		 },
		 reEnterPassword : {
		 passwordMatch : "password doesnot match"
		 }
		 },
		 highlight : function(element, errorClass) {
		 $(element).closest('.form-group').addClass('has-error');
		 },
		 unhighlight : function(element, errorClass) {
		 $(element).closest('.form-group').removeClass('has-error');
		 },
		 errorPlacement : function(error, element) {
		 if (element.attr('type') == 'checkbox') {
		 element.closest('.form-group').children(0).prepend(error);
		 } else {
		 //	error.insertAfter(element);
		 error.appendTo(element.parent().next());
		 }
		 //error.appendTo(element.parent().next());
		 },
		 submitHandler : function(form, event) {
		 alert('ajax being called');
		 var formData = $('#registrationForm').serialize();

		 alert(formData);
		 event.preventDefault();
		 $.ajax({
		 type : 'POST',
		 url : '/spring-mvc/registerUser.htm',
		 data : formData,
		 success : function(response) {
		 var url = "";
		 switch (response.message) {
		 case "success":
		 url = "/spring-mvc/adminHome.htm";
		 break;
		 case "failure":
		 break;
		 }
		 window.location.href = "/spring-mvc/adminHome.htm"
		 },
		 error : function(xhr, status, error) {
		 alert(xhr.responseText);
		 alert(status);
		 alert(error);
		 }
		 });

		 }
		 });
		 */
		$('#authenticationModal').on('hidden', function() {
			window.location.reload();
		})

		$.validator.setDefaults({
			rules : {
				userName : {
					required : true,
				},
				j_username : {
					required : true
				},
				j_password : {
					required : true
				},
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					minlength : 8
				},
				reEnterPassword : {
					passwordMatch : true,
					minlength : 8,
					required : true
				},
				agree : {
					required : true,
				}
			},
			messages : {
				agree : {
					required : "You must select at least 1 box"
				},
				reEnterPassword : {
					passwordMatch : "password doesnot match"
				}
			},
			highlight : function(element, errorClass) {
				$(element).closest('.form-group').addClass('has-error');
			},
			unhighlight : function(element, errorClass) {
				$(element).closest('.form-group').removeClass('has-error');
			},
			errorPlacement : function(error, element) {
				if (element.attr('type') == 'checkbox') {
					element.closest('.form-group').children(0).prepend(error);
				} else {
					//	error.insertAfter(element);
					error.appendTo(element.parent().next());
				}
				//error.appendTo(element.parent().next());
			}
		});

		$(document).ready(function() {

			$('#login').validate({

				submitHandler : function(form, event) {
				 	event.preventDefault();
					$('#signInBtn').attr('disabled', true);
					alert('submit handler for login');
					var formdata = $('#login').serialize();
					alert(formdata);
				//	$("#validation_sign_in_error").empty();
					$.ajax({
						type : 'POST',
						url : '/spring-mvc/j_spring_security_check',
						data : formdata,
						beforeSend:function(xhr){
							xhr.setRequestHeader("X-Ajax-Call","true");
						},
					 	success : function(response, status, jqXHR) {
				//	 		 alert(status);alert(response);
			//		alert(jqXHR.status);
				//   alert( jqXHR.getResponseHeader("targetUrl"));
				   var targetUrl=jqXHR.getResponseHeader("targetUrl");
				   if(jqXHR.status==200 && targetUrl != null)
						 window.location=targetUrl;
				   
				   if(jqXHR.getResponseHeader("errorMessage") != null){
						 // 	 var springException = '${sessionScope.SPRING_SECURITY_LAST_EXCEPTION}';
						  //	 alert('Exception = ' +springException);
 					  		 $("#validation_sign_in_error").empty();
							 $('#validation_sign_in_error').text(jqXHR.getResponseHeader("errorMessage"));
							 $("#validation_sign_in_error").show();
					 	 	 $('#signInBtn').attr('disabled', false);
				   }
				 
						}
					});
				}
			});
			$('#registrationForm').validate({

				submitHandler : function(form, event) {
					event.preventDefault();

					alert('submit handler for formA');
					var formData = $('#registrationForm').serialize();
					alert(formData);
					$.ajax({
						type : 'POST',
						url : '/spring-mvc/registerUser.htm',
						data : formData,
						success : function(response) {
							var url = "";
							switch (response.message) {
							case "success":
								url = "/spring-mvc/adminHome.htm";
								break;
							case "failure":
								break;
							}
							window.location.href = "/spring-mvc/adminHome.htm"
						},
						error : function(xhr, status, error) {
							alert(xhr.responseText);
							alert(status);
							alert(error);
						}
					});
				}
			});
			$('#forgotPassword').validate({

				submitHandler : function(form, event) {
					event.preventDefault();
					alert('prevent default');
					alert('submit handler for formA');
					//ajaxFunction();
					var email = $('#forgotPassword').serialize();
					$('#pwdMessage').hide();
					$.ajax({
						type : 'POST',
						url : '/spring-mvc/resetPassword.htm',
						data : email,
						success : function(response) {
							$('#pwdMessage').text(response.message).show();
							$('#forgotPasswordMessage').text(response.message);
							var err_html = response.message;
							$("#forgotPasswordMessage").empty();
							$("#forgotPasswordMessage").append(err_html);
							$("#forgotPasswordMessage").show();
							alert(response.message);

						},
						error : function(xhr, status, error) {
							alert(status);
							alert(error);
							alert(xhr.responeText);
						}
					});
				}
			});
		});
	</script>
</body>
</html>