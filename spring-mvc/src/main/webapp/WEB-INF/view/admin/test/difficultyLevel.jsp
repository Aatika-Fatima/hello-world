<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<label id="errorMessage" style="color: white;"></label>
			<form class="form-group" id="difficultyForm">
				<div class="form-group col-xs-4">
					<input type="text" class="form-control" id="email" placeholder="Enter Difficulty Level" name="difficultyLevel">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-default">ADD NEW DIFFICULTY LEVEL</button>
				</div>
			</form>

		</div>
		<div class="panel-body">

			<table class="table table-striped  table-hover">
				<thead>
					<tr>
						<th>Difficulty Id</th>
						<th>Difficulty Name</th>
						<th>EDIT</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>
							<div class="col-xs-6">
								<select id="categoryName" class="form-control" disabled>
									<option>LOW</option>
									<option>MEDIUM</option>
									<option>HIGH</option>
								</select>
							</div>
						</td>
						<td><button id="editButton" type="button" class="btn btn-default">EDIT</button></td>
						<!-- <th><button  id="editButton" type="button" class="btn btn-default" data-toggle="modal" data-target="#editModal">EDIT</button></th> -->
						<th><button type="button" class="btn btn-default" data-toggle="modal" data-target="#deleteModal">DELETE</button></th>
					</tr>
					<tr>
						<td>2</td>
						<td>HIGH</td>
						<th><input type="submit" class="btn btn-default" value="EDIT"></th>
						<th><input type="submit" class="btn btn-default" value="DELETE"></th>
					</tr>
					<tr>
						<td>2</td>
						<td>HIGH</td>
						<th><input type="submit" class="btn btn-default" value="EDIT"></th>
						<th><input type="submit" class="btn btn-default" value="DELETE"></th>
					</tr>

				</tbody>
			</table>

		</div>


		<!-- Modal -->
		<div class="modal fade" id="deleteModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">
							<strong>Confirm Deletion<strong>
						</h4>
					</div>
					<div class="modal-body">
						<p style="">Are You sure you want to delete this category??</p>
						<p>
							<strong><big>Please Note: </big></strong>Delete this Category will delete all the question related to this category
						</p>
					</div>
					<div class="modal-footer">
						<div>
							<button style="align: center" type="button" class="btn btn-success" data-dismiss="modal">Yes</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
						</div>
					</div>
				</div>

			</div>
		</div>

		<div class="modal fade" id="editModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">
							<strong>EDIT CATEGORY</strong>
						</h4>
					</div>
					<div class="modal-body">

						<div class="row col-md-offset-4" id="editCategory">
							<input type="text" name="categoryName" />
						</div>
					</div>
					<div class="modal-footer">

						<button style="align: center" type="button" class="btn btn-success col-sm-offset-5" data-dismiss="modal">SAVE</button>
						<button type="button" class="btn btn-danger col-sm-offset-5" data-dismiss="modal">CANCEL</button>


					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<script>
		$(document).ready(function() {
			$("#editButton").click(function() {
				$('#categoryName').attr('disabled', false);
				$('#editButton').html('SAVE');
			});
		});
		
		
 		$(document).ready(function() {
			$.validator.setDefaults({
				rules : {
					difficultyLevel : {
						required : true,
					}
				},
				messages:{
					difficultyLevel:{
						required:"diffuclty level cannot be left blank"
					}
				},
				highlight : function(element, errorClass) {
					$(element).closest('.form-group').addClass('has-error');
				},
				unhighlight : function(element, errorClass) {
					$(element).closest('.form-group').removeClass('has-error');
				},
				errorPlacement : function(error, element) {
					error.insertAfter(element);
				}
			});
			$('#difficultyForm').validate({
	
				submitHandler : function(form,event) {
					alert('ahdfjhdsf');form.submit();
				},
			});
		});
	</script>
<style>
.error {
	color: white;
}
</style>
