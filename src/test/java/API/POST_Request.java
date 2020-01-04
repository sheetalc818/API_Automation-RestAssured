package API;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Request 
{
	@Test
	public void PostUser() 
	{
		RestAssured.baseURI = "http://localhost:8000/api/user/login";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JsonObject requestParams = new JsonObject();

		requestParams.addProperty("email", "sheetalbdz@gmail.com");

		requestParams.addProperty("password", "Sheetal123");
		request.body(requestParams.toString());
		Response response = request.post("http://localhost:8000/api/user/login");
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved:" + statusCode);
		System.out.println("Response body: " + response.asString());
		// ResponseBody body = response.getBody();
		// System.out.println(response.body().asString());
	}

	@Test
	public void Post_Signup() 
	{
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
