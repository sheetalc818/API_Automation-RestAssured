package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get_Request {

	@Test
	public void GetuserDetails() {

		Response resp = RestAssured.get("http://localhost:8000/api/user");
		int code = resp.getStatusCode();
		System.out.println("Status code is" + code);
		Assert.assertEquals(code, 200);
	}

	@Test
	public void GetResponseBody() {
		Response resp = RestAssured.get("http://localhost:8000/api/user");
		String data1 = resp.asString();
		System.out.println("Response body with data is" + data1);
		System.out.println("Response time for Get UserDetails" + resp.getTime());

	}

	@Test
	public void GetUser() {

		RestAssured.baseURI = "http://localhost:8000/api/user";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/5e019fc3377f71743496dae2");
		// ResponseBody interface also has a method called
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
		String data = body.asString();
		System.out.println("Response body for particular Candidate" + data);

	}

	// https://www.toolsqa.com/rest-assured/post-request-using-rest-assured/
	@Test
	public void PostUser() {
		RestAssured.baseURI = "http://localhost/api/user/login";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonObject requestParams = new JsonObject();

		requestParams.addProperty("email", "sheetalc818@gmail.com");

		requestParams.addProperty("password", "Sheetal@123");
		request.body(requestParams.toString());
		Response response = request.post("http://localhost:8000/api/user/login");
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved:" + statusCode);
		System.out.println("Response body: " + response.asString());
		// ResponseBody body = response.getBody();
		// System.out.println(response.body().asString());
	}

	@Test
	public void Post_Signup() {
		RestAssured.baseURI = "http://localhost:8000/api/user/userSignUp";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonObject requestParams = new JsonObject();
		requestParams.addProperty("firstName", "Sheetal");
		requestParams.addProperty("lastName", "Chaudhari");
		requestParams.addProperty("service", "advanced");
		requestParams.addProperty("email", "sheetalc818@gmail.com");
		requestParams.addProperty("password", "Sheetal@123");
		request.body(requestParams.toString());
		Response response = request.post("http://localhost:8000/api/user/userSignUp");
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved:" + statusCode);
		System.out.println("Response body: " + response.asString());

	}
}
