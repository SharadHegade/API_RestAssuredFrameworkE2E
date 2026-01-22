package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	//Base Service class is Wrapper for RestAssured
	//Handling the Base URI
	//Responsible for creating the Request
	//Handling the Response
	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	
	//STATIC is executed only once and It's available for everyone 
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	
	public BaseService()
	{
		requestSpecification= given().baseUri(BASE_URL);
	}
	
	//Authorizing the Token
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer "+ token);
		
	}
	
	//Method for Passing Object parameters for Authentication POST requests
	protected Response postRequest(Object playload,String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(playload).post(endpoint);
	}
	
	//Method for UserManagement/UseeProfile GET
	protected Response getRequest(String endpoint)
	{
		return requestSpecification.get(endpoint);
	}
	
	//Method for UserManagement/Update Profile PUT
	protected Response putRequest(Object playload,String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(playload).put(endpoint);
	}
	
	
	
	
	//Method overloading is a another method
	//LoginRequest
	//protected Response postRequest(LoginRequest playload,String endpoint)
	//{
	//	return requestSpecification.contentType(ContentType.JSON).body(playload).post(endpoint);
	//}
	
	//SignUpRequest
	//protected Response postRequest(SignUpRequest payload,String endpoint)
	//{
	//	return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	//}

}
