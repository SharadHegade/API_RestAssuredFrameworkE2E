package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class LoginApiTest2 {
	
	@Test
	
	public void LoginTest()
	{
		baseURI="http://64.227.160.186:8080";
		Response res = given().baseUri("http://64.227.160.186:8080")
		.header("Content-Type","application/json")
		.body("{\"username\": \"sharad2109\",\"password\": \"wAGONR@16\"}")
		.post("/api/auth/login");
	
		System.out.println(res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(),200);
	}

}
