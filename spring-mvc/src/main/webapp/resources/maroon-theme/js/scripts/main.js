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
	$.validator.setDefaults({
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
				required : "You must select at least 1 box"
			},
			reEnterPassword : {
				passwordMatch : "password doesnot match"
			}
		},
		highlight : function(element, errorClass) {
			$(element).closest('.input-group').addClass('has-error');
		},
		unhighlight : function(element, errorClass) {
			$(element).closest('.input-group').removeClass('has-error');
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
				alert('prevent default');
				alert('submit handler for login')
				var formdata = $('#login').serialize();
				alert(formdata);
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
				$.ajax({
					type:'POST',
					url:'/spring-mvc/resetPassword.htm', 
					data:email,
					success:function(response){
						$('#forgotPasswordMessage').text(response.message);
						alert(response.message);
						 
					},
					error:function(xhr, status, error){
						alert(status);alert(error);alert(xhr.responeText);
					} 
				});
			}
		});
		$('#changePassword').validate({

			submitHandler : function(form, event) {
				event.preventDefault();
				alert('prevent default');
				alert('submit handler for changePassword');
				//ajaxFunction();
				var password ='password='+ $('#pwd').val();
				alert(password);
				$.ajax({
					type:'POST',
					url:'/spring-mvc/savePassword.htm', 
					data:password,
					success:function(response){
						 
						alert(response.message + '   success');
						 
					},
					error:function(xhr, status, error){
						alert(status);alert(error);alert(xhr.responeText);
					} 
				});
			}
		});
	});