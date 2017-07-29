package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

@WebServlet(urlPatterns = "/callbackServlet")
public class CallBackListener extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		if (code != null && code.length() > 0) {
			final String TOKEN_ENDPOINT = "https://graph.facebook.com/oauth/access_token";
			final String GRANT_TYPE = "authorization_code";
			final String REDIRECT_URI = "http://localhost:8081/oauth-trusted-client-server-side/callbackServlet";
			final String CLIENT_ID = "152617568647187";
			final String CLIENT_SECRET = "3cc501c30588297dc48518ba9150cb6f";

			String accessTokenURL = TOKEN_ENDPOINT + "?grant_type="
					+ URLEncoder.encode(GRANT_TYPE, StandardCharsets.UTF_8.name()) + "&code="
					+ URLEncoder.encode(code, StandardCharsets.UTF_8.name()) + "&redirect_uri="
					+ URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8.name()) + "&client_id="
					+ URLEncoder.encode(CLIENT_ID, StandardCharsets.UTF_8.name());
			String clientCredentials = CLIENT_ID + ":" + CLIENT_SECRET;
			String encodeClientCredentials = new String(Base64.encodeBase64(clientCredentials.getBytes()));

			HttpPost httpPost = new HttpPost(accessTokenURL);
			httpPost.setHeader("Authorization", "Basic " + encodeClientCredentials);

			// Make the access token request
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpResponse httpResponse = httpClient.execute(httpPost);

			// handle access token response
			Reader reader = new InputStreamReader(httpResponse.getEntity().getContent());
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			line = line.replace("{", "");
			line = line.replace("}", "");
			line = line.replace("\"", "");
 
			String[] responseTokens = line.split(",");
			String accessToken = null;
 			for (String token : responseTokens) {
				// System.out.println(token);
				String keys[] = token.split(":");

				if (keys[0].equals("access_token")) {
					accessToken = keys[1];
					System.out.println(keys[0]);
					break;
				}
				// System.err.println(keys[0]+"="+keys[1]);
			}
			System.out.println("Access Token = " + accessToken);
			httpClient.close();
			String requestUrl = "https://graph.facebook.com/v2.5/me/feed?limit=25";
			httpClient = HttpClients.createDefault();
			httpPost = new HttpPost(requestUrl);
			httpPost.addHeader("Authorization", "Bearer " + accessToken);
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("method", "get"));
			httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
			httpResponse = httpClient.execute(httpPost);
			// Extract feed data from response
			bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String feedJson = bufferedReader.readLine();
			System.out.println("Feed data: " + feedJson);
		} else {
			PrintWriter out = resp.getWriter();
			out.println("Authorization code not detected");
		}

	}
}
