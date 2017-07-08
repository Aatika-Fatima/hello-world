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
		<h2>Hover Rows</h2>
		<p>The .table-hover class enables a hover state on table rows:</p>
		<table class="table table-hover table-striped table-condensed">
			<thead>
				<tr>
					<th>qid</th>
					<th>Question</th>
					<th>opt A</th>
					<th>opt B</th>
					<th>opt C</th>
					<th>opt D</th>
					<th>Answer</th>
				</tr>
			</thead>
			<tbody>

				<tr>

					<td><input type="checkbox" name="qid" value="" /></td>
					<td>What is Java</td>
					<td>Java is prg language</td>
					<td>It is blah blah</td>
					<td>It is blah blah</td>
					<td>It is blah blah</td>
					<td>C</td>
					<td>
						<button type="button" class="btn btn-default" data-toggle="collapse" data-target="#demo">Edit</button>
					</td>
					
				</tr>

				<tr>
					<td><input type="checkbox" name="qid" value="" /></td>
					<td>What is Java</td>
					<td>Java is prg language</td>
					<td>It is blah blah</td>
					<td>It is blah blah</td>
					<td>It is blah blah</td>
					<td>C</td>
					<td>
						<button type="button" class="btn btn-default" data-toggle="collapse" data-target="#demo">Edit</button>
					</td>
				</tr>
			
			</tbody>
		</table>
		<div id="demo" class="collapse">
			<h2>Question</h2>
			<form class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Category:</label>
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
						<textarea class="form-control" rows="3" id="comment"></textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd"><div class="radio">
							<label><input type="radio" name="optradio">A</label>
						</div></label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="2" id="comment"></textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd"><div class="radio">
							<label><input type="radio" name="optradio">B</label>
						</div></label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="2" id="comment"></textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd"><div class="radio">
							<label><input type="radio" name="optradio">C</label>
						</div></label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="2" id="comment"></textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd"><div class="radio">
							<label><input type="radio" name="optradio">D</label>
						</div></label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="2" id="comment"></textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
						<button type="reset" class="btn btn-default">Reset</button>
					</div>
				</div>

			</form>
		</div>
	</div>
<script>
	
</script>
</body>
</html>
