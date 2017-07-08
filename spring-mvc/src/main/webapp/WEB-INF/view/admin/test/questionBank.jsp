<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

</head>
<body>

	<div class="container">

		<form class="form-horizontal">
			<div class="form-group">

				<div class="row col-sm-offset-2">
					<div class="col-sm-3">
						<label class="control-label" for="pwd">Difficulty :</label>
						<select class="form-control" id="difficultyLevel">
							<option>Easy</option>
							<option>Medium</option>
							<option>Difficult</option>
						</select>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="pwd">Category :</label>
						<select class="form-control" id="difficultyLevel">
							<option>Easy</option>
							<option>Medium</option>
							<option>Difficult</option>
						</select>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="pwd">Author :</label>
						<select class="form-control" id="difficultyLevel">
							<option>Easy</option>
							<option>Medium</option>
							<option>Difficult</option>
						</select>
					</div>
					<div class="col-sm-3">
						<label class="control-label" for="pwd">Content :</label>
						<select class="form-control" id="difficultyLevel">
							<option>Easy</option>
							<option>Medium</option>
							<option>Difficult</option>
						</select>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-6 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>

				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">No Questions:</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" name="numOfQuestion" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-10">
					<button type="submit" class="btn btn-default">Add Randomly</button>
					<button type="submit" class="btn btn-default">Add Manually</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
