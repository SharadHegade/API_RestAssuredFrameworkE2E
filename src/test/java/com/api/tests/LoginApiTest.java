package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginApiTest {
	
	@Test(description="To verify Login API ")
	
	public void LoginTest()
	{
		RestAssured.baseURI="http://64.227.160.186:8080";
		RequestSpecification x=RestAssured.given();
		RequestSpecification y=x.header("Content-Type","application/json");
		RequestSpecification z=y.body("{\"username\": \"sharad2109\",\"password\": \"wAGONR@16\"}");
		Response res =z.post("/api/auth/login");
		System.out.println(res.asPrettyString());
		
		Assert.assertEquals(res.getStatusCode(),200);
	}

}
