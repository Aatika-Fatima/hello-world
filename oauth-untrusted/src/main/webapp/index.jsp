<html>
<body>
	<h2>Hello World!</h2>
	<input type="button" value="FACEBOOK" onclick="makeRequest()"/>
	<script>
		function makeRequest() {
			// Define properties
			var AUTH_ENDPOINT = "https://www.facebook.com/dialog/oauth";
			var RESPONSE_TYPE = "token";
			var CLIENT_ID = "152617568647187";
			var REDIRECT_URI = "http://localhost:8081/oauth-untrusted/callbackJSP.jsp";
			var SCOPE = "public_profile user_posts";
			// Build authorization request endpoint
			var requestEndpoint = AUTH_ENDPOINT + "?" + "response_type="
					+ encodeURIComponent(RESPONSE_TYPE) + "&" + "client_id="
					+ encodeURIComponent(CLIENT_ID) + "&" + "redirect_uri="
					+ encodeURIComponent(REDIRECT_URI) + "&" + "scope="
					+ encodeURIComponent(SCOPE);
			// Send to authorization request endpoint
			window.location.href = requestEndpoint;
		}
	</script>
</body>
</html>
