$.validator.setDefaults({
		rules : {
			categorySelect : {
				required : true,
			},
			difficultySelect : {
				required : true,
			
			},
			question : {
				required : true,
			
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
