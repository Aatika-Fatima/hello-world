
<form class="form-horizontal" id="registrationForm">
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Category:</label>
		<div class="col-sm-10">
			<select class="form-control" id="categorySelect" name="categorySelect">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">Category:</label>
		<div class="col-sm-10">
			<select class="form-control" id="sel1">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">Question:</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="3" name="question"></textarea>
		</div>
	</div>

	<div class="form-group">
	 <label class="control-label col-sm-2"></label>
		<div class="radio">
			<label class="control-label col-sm-2"><input type="radio" name="optradio">A</label>
		</div>
		<div class="col-sm-10">
			<textarea class="form-control" rows="2" id="comment" name="option_A_text"></textarea>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">
			<div class="radio">
				<label><input type="radio" name="optradio">B</label>
			</div>
		</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="2" id="option_B_text" name="option_B_text"></textarea>
		</div>
	</div>
	<div></div>


	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd"><div class="radio">
				<label><input type="radio" name="optradio">C</label>
			</div></label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="2" id="option_C_text" name="option_C_text"></textarea>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd"><div class="radio">
				<label><input type="radio" name="optradio">D</label>
			</div></label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="2" id="option_D_text" name="option_D_text"></textarea>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-5 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
			<button type="reset" class="btn btn-default">Reset</button>
		</div>
	</div>

</form>
<script>
	$(document).ready(function() {
		$.validator.setDefaults({
			rules : {
				question : {
					required : true,
				},
				categorySelect : {
					required : true
				},
				optradio : {
					required : true
				},
				option_A_text:{
					required:true
				},
				option_B_text:{
					required:true
				},
				option_C_text:{
					required:true
				}	, 
				option_D_text:{
					required:true
				}
			},
			messages:{
				optradio:{
					required:"Please select the option"
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
				} else if (element.attr('type') == 'radio') {
					element.closest('.form-group').prepend(error);
					//error.insertBefore('#radioBtnError');
				} else {
					error.insertBefore(element);
				//	error.appendTo(element.parent().next());
				} 
				//error.appendTo(element.parent().next());
			}
		});
		$('#registrationForm').validate({
			submitHandler : function(event) {
				alert('ahdfjhdsf');
			}
		});
	});
</script>