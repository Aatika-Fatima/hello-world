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
			element.closest('.input-group').children(0).prepend(error);
		} else {
			//	error.insertAfter(element);
			error.appendTo(element.parent().next());
		}
		//error.appendTo(element.parent().next());
	}
});
