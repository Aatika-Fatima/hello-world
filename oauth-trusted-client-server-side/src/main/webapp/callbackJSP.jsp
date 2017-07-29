<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		// Extract fragment from URL
		var fragment = location.hash.replace('#', '');
		// Detect presence of response by examining fragment
		if (fragment !== "") {
			var responseProperties = fragment.split("&");
			// Isolate access token and write it to the "response" div
			var accessToken = "";
			for (var i = 0; i < responseProperties.length; i++) {
				if (responseProperties[i].indexOf("access_token=") === 0) {
					accessToken = responseProperties[i].split("=")[1];
					$("#response").html("Access token: " + accessToken);
					break;
				}
			}
			// TODO: Request profile and feed data with access token
		} else {
			$("#response").html("No response detected.");
		}
	});
</script>
</head>
<body>

	<p id="response">Access Token</p>

	 

</body>
</html>
