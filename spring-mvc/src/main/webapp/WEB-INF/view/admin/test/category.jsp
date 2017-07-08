<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.error {
	color: white;
}
</style>
<div class="container">
	<div class="panel" id="categoryPanel">
		<div class="panel-heading">
			<label id="errorMessage" style="color: white;"></label>
			<form class="form-group" id="categoryForm">
				<div class="form-group col-xs-4">
					<input type="text" class="form-control" id="category" placeholder="Enter Category" name="categoryName">
				</div>
				<div class="form-group"></div>
				<button type="submit" class="btn btn-default" id="categoryBtn">ADD NEW CATEOGRY</button>
			</form>
		</div>
		<div class="panel-body">

			<table class="table table-striped  table-hover" id="categoryTable">
				<thead>
					<tr>
						<th>Category Id</th>
						<th>Category Name</th>
						<th>EDIT</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="category" items="${categoryList }">
						<tr>
							<td>${category.categoryId }</td>
							<td>${category.categoryName}</td>
							<%-- 				<td>
								<div class="col-xs-6">
									<select id="categoryName" class="form-control" disabled>
										<c:forEach var="category" items="${categoryList}">
											<option value="${category.categoryId }">${category.categoryName}</option>
										</c:forEach>
									</select>
								</div>
							</td> --%>

							<td><button id="editButton" type="button" class="btn btn-default">EDIT</button></td>
							<!-- <th><button  id="editButton" type="button" class="btn btn-default" data-toggle="modal" data-target="#editModal">EDIT</button></th> -->
							<td><button type="button" class="btn btn-default" data-toggle="modal" data-target="#deleteModal">DELETE</button></td>
						</tr>
					</c:forEach>
					<%-- 					<tr>
						<td>1</td>
						<td>
							<div class="col-xs-6">
								<select id="categoryName" class="form-control" disabled>
									<c:forEach var="category" items="${categoryList}">
										<option value="${category.categoryId }">${category.categoryName}</option>
									</c:forEach>
								</select>
							</div>
						</td>
						<td><button id="editButton" type="button" class="btn btn-default">EDIT</button></td>
						<!-- <th><button  id="editButton" type="button" class="btn btn-default" data-toggle="modal" data-target="#editModal">EDIT</button></th> -->
						<th><button type="button" class="btn btn-default" data-toggle="modal" data-target="#deleteModal">DELETE</button></th>
					</tr>
 --%>


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

<!-- Modal -->
<div class="modal fade" id="successModal" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Success</h4>
			</div>
			<div class="modal-body">
				<p id="successMessage">Category Added Successfully</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script>
	/* 	$(document).ready(function() {
	 $("#editButton").click(function() {
	 $('#categoryName').attr('disabled', false);
	 $('#editButton').html('SAVE');
	 });
	 }); */
	$(document).ready(function() {
		$.validator.setDefaults({
			rules : {
				category : {
					required : true,
				}
			},
			messages : {
				category : {
					required : "Category  cannot be left blank"
				}
			},
			highlight : function(element, errorClass) {
				$(element).closest('.form-inline').addClass('has-error');
			},
			unhighlight : function(element, errorClass) {
				$(element).closest('.form-inline').removeClass('has-error');
			},
			errorPlacement : function(error, element) {
				error.insertAfter(element);
				//	$('#errorMessage').text($(error).text()).show();
			}
		});
		$('#categoryForm').validate({

			submitHandler : function(form, event) {
				alert('hello');
				event.preventDefault();
				var formData =$('#categoryForm').serialize();
				alert('form data = ' + formData);
				$.ajax({
					type : 'POST',
					url : '/spring-mvc/addCategory.htm',
					data : formData,
					success : function(response) {
					  
						if(response.message=='failure')
							$("#successMessage").html(response.message);
						else{
						alert('success');
						$("#successMessage").html("catefory added successfully");
					    jQuery("#successModal").modal('show');
					    $("#categoryPanel").load(location.href + " #categoryPanel>*", "");
						}
					},
					error : function(xhr, status) {
						alert(xhr);
					}
				});
			},
		});
	});
</script>
